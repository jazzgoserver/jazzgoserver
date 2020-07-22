package cavallo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cavallo.scacchi.Mossa;
import cavallo.scacchi.Scacchiera;
import cavallo.util.Single;

/**
 * stato dell'arte:
 * <li>mosse OK
 * <li>backtracking OK
 * 
 * @author Guido Zuccaro
 *
 */
public class Cavallo implements Single {
	public static final int VUOTA = 0;
	public static final int PRIMA = 1;

	public static void backtracking(Scacchiera scacchiera, Mossa mossa, int numero) {
		scacchiera.set(mossa, numero);
		if (scacchiera.completa())
			log.debug(scacchiera);
		for (Mossa candidata : mosse(mossa, scacchiera.getLato()))
			if (scacchiera.get(candidata) == VUOTA)
				backtracking(new Scacchiera(scacchiera), candidata, numero + 1);
	}

	public static List<Mossa> mosse(Mossa partenza, int lato) {
		List<Mossa> mosse = new ArrayList<>();
		for (int t = -2; t <= +2; t++)
			for (int c = -2; c <= +2; c++)
				if (c != 0 && t != 0 && Math.abs(c) != Math.abs(t))
					mosse.add(partenza.trasla(c, t));
		return legali(mosse, lato);
	}

	private static List<Mossa> legali(List<Mossa> mosse, int lato) {
		return mosse.stream().filter(mossa -> mossa.legale(lato)).collect(Collectors.toList());
	}

	public static void debug(List<Mossa> mosse, int lato) {
		Scacchiera scacchiera = new Scacchiera(lato);
		for (Mossa mossa : mosse)
			scacchiera.set(mossa, PRIMA);
		log.debug(scacchiera);
	}

}
