package cavallo.scacchi;

import java.util.ArrayList;
import java.util.List;

import cavallo.Cavallo;
import cavallo.util.Single;

public class Scacchiera implements Single {
	private int lato;
	private int[][] caselle;

	public Scacchiera(int lato) {
		this.lato = lato;
		this.caselle = new int[lato][lato];
		for (int t = 0; t < lato; t++)
			for (int c = 0; c < lato; c++)
				this.caselle[t][c] = Cavallo.VUOTA;
	}

	public Scacchiera(Scacchiera scacchiera) {
		this.lato = scacchiera.lato;
		this.caselle = new int[lato][lato];
		for (int t = 0; t < lato; t++)
			for (int c = 0; c < lato; c++)
				this.caselle[t][c] = scacchiera.caselle[t][c];
	}

	public List<Mossa> select(int numero) {
		List<Mossa> punti = new ArrayList<>();
		for (int t = 0; t < lato; t++)
			for (int c = 0; c < lato; c++)
				if (caselle[t][c] == numero)
					punti.add(new Mossa(c, t));
		return punti;
	}

	public boolean completa() {
		return select(Cavallo.VUOTA).isEmpty();
	}

	public int getLato() {
		return lato;
	}

	public int get(Mossa punto) {
		return caselle[punto.getTraversa()][punto.getColonna()];
	}

	public void set(Mossa punto, int numero) {
		caselle[punto.getTraversa()][punto.getColonna()] = numero;
	}

	@Override
	public String toString() {
		String goban = EOL;
		for (int t = 0; t < lato; t++) {
			for (int c = 0; c < lato; c++)
				goban += String.format(" %02d", caselle[t][c]);
			goban += EOL;
		}
		return goban;
	}

}
