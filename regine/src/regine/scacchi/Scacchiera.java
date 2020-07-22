package regine.scacchi;

import java.util.ArrayList;
import java.util.List;

import regine.Regine;
import regine.util.Single;

public class Scacchiera implements Single {
	private static final String TAB = " ";
	private int lato;
	private Stato[][] caselle;

	public Scacchiera(int lato) {
		this.lato = lato;
		this.caselle = new Stato[lato][lato];
		for (int t = 0; t < lato; t++)
			for (int c = 0; c < lato; c++)
				this.caselle[t][c] = Stato.LIBERA;
	}

	public Scacchiera(Scacchiera scacchiera) {
		this.lato = scacchiera.lato;
		this.caselle = new Stato[lato][lato];
		for (int t = 0; t < lato; t++)
			for (int c = 0; c < lato; c++)
				this.caselle[t][c] = scacchiera.caselle[t][c];
	}

	public List<Mossa> select(Stato stato) {
		List<Mossa> punti = new ArrayList<>();
		for (int t = 0; t < lato; t++)
			for (int c = 0; c < lato; c++)
				if (caselle[t][c] == stato)
					punti.add(new Mossa(c, t));
		return punti;
	}

	public boolean completa() {
		return select(Stato.REGINA).size() == lato;
	}

	public void occupa(Mossa mossa) {
		set(mossa, Stato.REGINA);
		for (Mossa minaccia : Regine.regina(mossa, lato))
			if (get(minaccia) == Stato.LIBERA)
				set(minaccia, Stato.MINACCIA);
	}

	public int getLato() {
		return lato;
	}

	public Stato get(Mossa punto) {
		return caselle[punto.getTraversa()][punto.getColonna()];
	}

	public void set(Mossa punto, Stato stato) {
		caselle[punto.getTraversa()][punto.getColonna()] = stato;
	}

	@Override
	public String toString() {
		String goban = EOL;
		for (int t = 0; t < lato; t++) {
			for (int c = 0; c < lato; c++)
				goban += caselle[t][c] + TAB;
			goban += EOL;
		}
		return goban;
	}

}
