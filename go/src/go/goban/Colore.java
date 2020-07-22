package go.goban;

public enum Colore {
	VUOTO("+"), NERO("x"), BIANCO("o");
	private String simbolo;

	private Colore(String simbolo) {
		this.simbolo = simbolo;
	}

	public Colore avversario() {
		switch (this) {
		default:
		case NERO:
			return BIANCO;
		case BIANCO:
			return NERO;
		}
	}

	@Override
	public String toString() {
		return simbolo;
	}

}
