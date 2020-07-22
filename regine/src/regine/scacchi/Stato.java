package regine.scacchi;

public enum Stato {
	LIBERA("."), MINACCIA("x"), REGINA("d");
	private String simbolo;

	private Stato(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {
		return simbolo;
	}

}
