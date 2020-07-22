package go.strategia;

import go.goban.Colore;
import go.goban.Goban;
import go.gruppi.Punto;
import go.util.Tempo;

public class Backtracking {
	public static final long SECONDO = 1000;
	public static final long DECIMO = SECONDO / 10;
	public static final long CENTESIMO = SECONDO / 100;
	public static final double MILLE = 1000;
	public static final double MILIONE = MILLE * MILLE;
	private long maxTempo;
	private double maxNodi;
	private int maxLivello;
	private Tempo tempo = new Tempo();
	private double nodi;

	public Backtracking(long maxTempo, double maxNodi, int maxLivello) {
		this.maxTempo = maxTempo;
		this.maxNodi = maxNodi;
		this.maxLivello = maxLivello;
	}

	public void backtracking(Goban goban, Punto mossa, Colore colore, int livello) {
		nodi += 1;
		if (continua(livello))
			for (Punto candidata : goban.legali())
				backtracking(new Goban(goban), candidata, colore.avversario(), livello + 1);
	}

	private boolean continua(int livello) {
		return tempo.trascorso() < maxTempo && nodi < maxNodi && livello < maxLivello;
	}

	@Override
	public String toString() {
		return String.format("%,.0f in %,d ms", nodi, tempo.trascorso());
	}

}
