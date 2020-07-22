package go.sgf;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import go.util.Single;

public class SGFScanner implements Single {
	private static final String OPERATORI = SGF.TONDA_APERTA + SGF.TONDA_CHIUSA + SGF.SEMICOLON;
	private static final String BARRA = "|";
	private static final String PATH = "src/go/sgf/";
	private String sgf;
	private List<String> tokens = new ArrayList<>();
	private int corrente;

	public static List<String> load(String file) {
		List<String> linee = new ArrayList<>();
		try (BufferedReader flusso = Files.newBufferedReader(Paths.get(PATH + file))) {
			for (String linea = flusso.readLine(); linea != null; linea = flusso.readLine())
				linee.add(linea);

		} catch (Exception e) {
			log.error(e);
		}
		return linee;
	}

	public SGFScanner(String sgf) {
		this.sgf = sgf;
		scan();
	}

	private void scan() {
		for (corrente = 0; corrente < sgf.length(); corrente++) {
			String token = EMPTY;
			if (Character.isAlphabetic(getChar()))
				token = buildName();
			else if (SGF.QUADRA_APERTA.equals(getString()))
				token = buildString();
			else if (OPERATORI.contains(getString()))
				token = getString();
			token = token.trim();
			if (!token.isEmpty())
				tokens.add(token);
		}
	}

	private String buildName() {
		String token = EMPTY;
		for (; corrente < sgf.length() && Character.isAlphabetic(getChar()); corrente++)
			token += getChar();
		corrente--;
		return token;
	}

	private String buildString() {
		String token = getString();
		corrente++;
		for (; corrente < sgf.length() && !SGF.QUADRA_CHIUSA.equals(getString()); corrente++)
			token += getChar();
		token += getChar();
		return token;
	}

	private String getString() {
		return sgf.substring(corrente, corrente + 1);
	}

	private char getChar() {
		return sgf.charAt(corrente);
	}

	public List<String> getTokens() {
		return tokens;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(BARRA);
		for (String token : tokens)
			buffer.append(token).append(BARRA);
		return buffer.toString();
	}

}
