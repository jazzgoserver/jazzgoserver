package go.gruppi;

import java.util.ArrayList;
import java.util.List;

import go.goban.Colore;
import go.goban.Goban;
import go.util.Single;

public class Punto implements Single {
	private static final Punto NORD = new Punto(0, -1);
	private static final Punto EST = new Punto(+1, 0);
	private static final Punto SUD = new Punto(0, +1);
	private static final Punto OVEST = new Punto(-1, 0);
	public static final Punto[] CARDINALI = { NORD, EST, SUD, OVEST };
	private static final int A = 'a';
	private int x;
	private int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punto(String sgf) {
		try {
			this.x = sgf.charAt(0) - A;
			this.y = sgf.charAt(1) - A;
		} catch (Exception e) {
			log.error(e);
		}
	}

	public Punto trasla(Punto direzione) {
		return new Punto(x + direzione.x, y + direzione.y);
	}

	public boolean legale(int lato) {
		return x >= 0 && x < lato && y >= 0 && y < lato;
	}

	public List<Punto> liberta(Goban goban) {
		List<Punto> punti = new ArrayList<>();
		for (Punto direzione : Punto.CARDINALI) {
			Punto punto = this.trasla(direzione);
			if (punto.legale(goban.getLato()) && goban.get(punto) == Colore.VUOTO)
				punti.add(punto);
		}
		return punti;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%c%c", A + x, A + y);
	}
}
