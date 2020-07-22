package go.goban;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import go.gruppi.Punto;
import go.util.Single;

public class Goban implements Single {
	public static final int PICCOLO = 9;
	public static final int MEDIO = 13;
	public static final int GRANDE = 19;
	private static final String TAB = " ";
	private int lato;
	private Colore[][] incroci;

	public Goban(int lato) {
		this.lato = lato;
		this.incroci = new Colore[lato][lato];
		for (int y = 0; y < lato; y++)
			for (int x = 0; x < lato; x++)
				this.incroci[y][x] = Colore.VUOTO;
	}

	public Goban(Goban goban) {
		this.lato = goban.lato;
		this.incroci = new Colore[lato][lato];
		for (int y = 0; y < lato; y++)
			for (int x = 0; x < lato; x++)
				this.incroci[y][x] = goban.incroci[y][x];
	}

	public List<Punto> select(Colore colore) {
		List<Punto> punti = new ArrayList<>();
		for (int y = 0; y < lato; y++)
			for (int x = 0; x < lato; x++)
				if (incroci[y][x] == colore)
					punti.add(new Punto(x, y));
		return punti;
	}

	public List<Punto> legali() {
		return select(Colore.VUOTO).stream().filter(mossa -> !mossa.liberta(this).isEmpty())
				.collect(Collectors.toList());
	}

	public Goban ritaglia() {
		int perimetro = perimetro();
		Goban piccolo = new Goban(perimetro);
		for (int y = 0; y < perimetro; y++)
			for (int x = 0; x < perimetro; x++)
				piccolo.incroci[y][x] = this.incroci[y][x];
		return piccolo;
	}

	private int perimetro() {
		int perimetro = 0;
		for (int y = 0; y < lato; y++) {
			for (int x = 0; x < lato; x++) {
				if (incroci[y][x] != Colore.VUOTO) {
					if (perimetro < x)
						perimetro = x;
					if (perimetro < y)
						perimetro = y;
				}
			}
		}
		return perimetro;
	}

	public int getLato() {
		return lato;
	}

	public Colore get(Punto punto) {
		return incroci[punto.getY()][punto.getX()];
	}

	public void set(Punto punto, Colore colore) {
		incroci[punto.getY()][punto.getX()] = colore;
	}

	@Override
	public String toString() {
		String goban = EOL;
		for (int y = 0; y < lato; y++) {
			for (int x = 0; x < lato; x++)
				goban += incroci[y][x] + TAB;
			goban += EOL;
		}
		return goban;
	}

}
