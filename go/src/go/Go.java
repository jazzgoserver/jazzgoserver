package go;

import java.util.List;

import go.goban.Colore;
import go.goban.Goban;
import go.gruppi.Punto;
import go.turni.Turno;
import go.util.Single;

/**
 * stato dell'arte:
 * <li>gioco casuale OK
 * <li>calcolo libertà OK
 * <li>suicidio illegale OK
 * <li>riconoscimento gruppo OK
 * <li>scanner sgf OK
 * <li>parser sgf OK
 * <li>backtracking OK
 * 
 * @author Guido Zuccaro
 *
 */
public class Go implements Single {
	private Goban goban;
	private Turno turno = new Turno();

	public Go(int lato) {
		goban = new Goban(lato);
	}

	public boolean finita() {
		return goban.legali().isEmpty();
	}

	public Punto muovi() {
		List<Punto> mosse = goban.legali();
		Punto mossa = mosse.get(caso.nextInt(mosse.size()));
		Colore colore = turno.prossimo().getColore();
		goban.set(mossa, colore);
		return mossa;
	}

	public Goban getGoban() {
		return goban;
	}

	@Override
	public String toString() {
		return goban.toString();
	}
}
