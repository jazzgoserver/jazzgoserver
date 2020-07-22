package go.gruppi;

import java.util.ArrayList;

import go.goban.Colore;
import go.goban.Goban;
import go.util.Single;

public class Gruppo extends ArrayList<Punto> implements Single {
	private static final long serialVersionUID = 1L;
	private Colore colore;

	public Gruppo(Colore colore) {
		this.colore = colore;
	}

	public static Gruppo riconosci(Gruppo gruppo, Goban goban, Punto pietra) {
		if (amica(gruppo, goban, pietra))
			gruppo.add(pietra);
		for (Punto direzione : Punto.CARDINALI) {
			Punto punto = pietra.trasla(direzione);
			if (amica(gruppo, goban, punto))
				riconosci(gruppo, goban, punto);
		}
		return gruppo;
	}

	public static boolean amica(Gruppo gruppo, Goban goban, Punto pietra) {
		return !gruppo.contains(pietra) && pietra.legale(goban.getLato()) && goban.get(pietra) == gruppo.colore;
	}

	public Colore getColore() {
		return colore;
	}

	@Override
	public String toString() {
		return colore + DEBUG + new ArrayList<>(this);
	}
}
