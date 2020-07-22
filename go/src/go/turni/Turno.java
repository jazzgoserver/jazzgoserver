package go.turni;

import java.util.ArrayList;
import java.util.List;

import go.goban.Colore;

public class Turno {
	private List<Giocatore> giocatori = new ArrayList<>();
	private int corrente = 0;

	public Turno() {
		giocatori.add(new Giocatore(Colore.NERO));
		giocatori.add(new Giocatore(Colore.BIANCO));
	}

	public Giocatore prossimo() {
		Giocatore prossimo = giocatori.get(corrente++);
		if (corrente >= giocatori.size())
			corrente = 0;
		return prossimo;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

}
