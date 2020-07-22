package go.sgf;

import go.util.Single;

public class SGFValue implements Single {
	private String chiave;
	private String valore;

	public SGFValue(String chiave, String valore) {
		this.chiave = chiave;
		this.valore = valore;
	}

	public SGFValue(String chiave) {
		this.chiave = chiave;
		this.valore = EMPTY;
	}

	public SGFValue() {
		this.chiave = EMPTY;
		this.valore = EMPTY;
	}

	public String getValore() {
		return valore;
	}

	public void addValore(String valore) {
		this.valore += valore;
	}

	public String getChiave() {
		return chiave;
	}

	@Override
	public String toString() {
		return chiave + valore;
	}

}
