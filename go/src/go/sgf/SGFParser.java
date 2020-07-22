package go.sgf;

import java.util.List;

public class SGFParser {
	private List<String> tokens;
	private SGF sgf = new SGF();

	public SGFParser(List<String> tokens) {
		this.tokens = tokens;
		parse();
	}

	private void parse() {
		SGFValue coppia = new SGFValue();
		for (String token : tokens) {
			if (Character.isAlphabetic(token.charAt(0))) {
				sgf.add(coppia);
				coppia = new SGFValue(token);
			} else if (token.startsWith(SGF.QUADRA_APERTA)) {
				coppia.addValore(token);
			}
		}
		sgf.add(coppia);
	}

	public SGF getSgf() {
		return sgf;
	}

	@Override
	public String toString() {
		return sgf.toString();
	}

}
