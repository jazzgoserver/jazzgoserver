package go.turni;

import go.goban.Colore;

public class Giocatore {
	private Colore colore;

	public Giocatore(Colore colore) {
		this.colore = colore;
	}

	public Colore getColore() {
		return colore;
	}

	@Override
	public String toString() {
		return colore.toString();
	}
}
