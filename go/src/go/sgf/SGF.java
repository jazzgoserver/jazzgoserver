package go.sgf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import go.goban.Colore;
import go.goban.Goban;
import go.gruppi.Punto;

public class SGF {
	public static final String QUADRA_APERTA = "[";
	public static final String QUADRA_CHIUSA = "]";
	public static final String TONDA_APERTA = "(";
	public static final String TONDA_CHIUSA = ")";
	public static final String SEMICOLON = ";";
	public static final String SIZE = "SZ";
	public static final String PIETRE_NERE = "AB";
	public static final String PIETRE_BIANCHE = "AW";
	private static final int SPAZIO_MOSSA = 4;
	private Map<String, String> chiavi = new HashMap<>();

	public SGF() {
		this(Goban.GRANDE);
	}

	public SGF(Integer lato) {
		chiavi.put(SIZE, encode(lato.toString()));
	}

	public void add(SGFValue coppia) {
		switch (coppia.getChiave()) {
		case SIZE:
		case PIETRE_NERE:
		case PIETRE_BIANCHE:
			chiavi.put(coppia.getChiave(), coppia.getValore());
			break;
		}
	}

	public Goban toGoban() {
		Goban goban = new Goban(getLato());
		for (Punto pietra : parsePietre(PIETRE_NERE))
			goban.set(pietra, Colore.NERO);
		for (Punto pietra : parsePietre(PIETRE_BIANCHE))
			goban.set(pietra, Colore.BIANCO);
		return goban;
	}

	private List<Punto> parsePietre(String colore) {
		List<Punto> pietre = new ArrayList<>();
		String valori = chiavi.get(colore);
		for (int v = 0; v < valori.length(); v += SPAZIO_MOSSA) {
			String valore = valori.substring(v, v + SPAZIO_MOSSA);
			Punto pietra = new Punto(decode(valore));
			pietre.add(pietra);
		}
		return pietre;
	}

	public Integer getLato() {
		Integer lato = Goban.GRANDE;
		try {
			String size = chiavi.get(SIZE);
			lato = Integer.parseInt(decode(size));

		} catch (Exception e) {
		}
		return lato;
	}

	private String encode(String valore) {
		return QUADRA_APERTA + valore + QUADRA_CHIUSA;
	}

	private String decode(String stringa) {
		return stringa.substring(1, stringa.length() - 1);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer(TONDA_APERTA);
		buffer.append(SEMICOLON);
		buffer.append(new SGFValue(PIETRE_NERE, chiavi.get(PIETRE_NERE)));
		buffer.append(new SGFValue(PIETRE_BIANCHE, chiavi.get(PIETRE_BIANCHE)));
		buffer.append(TONDA_CHIUSA);
		return buffer.toString();
	}

}
