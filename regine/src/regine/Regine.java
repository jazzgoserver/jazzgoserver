package regine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import regine.scacchi.Mossa;
import regine.scacchi.Scacchiera;
import regine.scacchi.Stato;
import regine.util.Single;

/**
 * stato dell'arte:
 * <li>mosse OK
 * <li>backtracking OK
 * 
 * @author Guido Zuccaro
 *
 */
public class Regine implements Single {
	public static final int VUOTA = 0;
	public static final int PRIMA = 1;

	public static void backtracking(Scacchiera scacchiera, Mossa mossa) {
		scacchiera.occupa(mossa);
		if (scacchiera.completa())
			log.debug(scacchiera);
		for (Mossa candidata : scacchiera.select(Stato.LIBERA))
			backtracking(new Scacchiera(scacchiera), candidata);
	}

	public static List<Mossa> regina(Mossa partenza, int lato) {
		List<Mossa> mosse = torre(partenza, lato);
		mosse.addAll(alfiere(partenza, lato));
		return mosse;
	}

	public static List<Mossa> torre(Mossa partenza, int lato) {
		List<Mossa> mosse = colonna(partenza, lato);
		mosse.addAll(traversa(partenza, lato));
		return mosse;
	}

	public static List<Mossa> alfiere(Mossa partenza, int lato) {
		List<Mossa> mosse = ascendente(partenza, lato);
		mosse.addAll(discendente(partenza, lato));
		return mosse;
	}

	public static List<Mossa> colonna(Mossa partenza, int lato) {
		List<Mossa> mosse = new ArrayList<>();
		for (int t = 0; t < lato; t++)
			if (t != partenza.getTraversa())
				mosse.add(new Mossa(partenza.getColonna(), t));
		return mosse;
	}

	public static List<Mossa> traversa(Mossa partenza, int lato) {
		List<Mossa> mosse = new ArrayList<>();
		for (int c = 0; c < lato; c++)
			if (c != partenza.getColonna())
				mosse.add(new Mossa(c, partenza.getTraversa()));
		return mosse;
	}

	public static List<Mossa> ascendente(Mossa partenza, int lato) {
		List<Mossa> mosse = new ArrayList<>();
		int somma = partenza.getTraversa() + partenza.getColonna();
		for (int c = 0; c < lato; c++)
			if (c != partenza.getColonna())
				mosse.add(new Mossa(c, somma - c));
		return legali(mosse, lato);
	}

	public static List<Mossa> discendente(Mossa partenza, int lato) {
		List<Mossa> mosse = new ArrayList<>();
		int differenza = partenza.getTraversa() - partenza.getColonna();
		for (int c = 0; c < lato; c++)
			if (c != partenza.getColonna())
				mosse.add(new Mossa(c, c + differenza));
		return legali(mosse, lato);
	}

	private static List<Mossa> legali(List<Mossa> mosse, int lato) {
		return mosse.stream().filter(mossa -> mossa.legale(lato)).collect(Collectors.toList());
	}

	public static void debug(List<Mossa> mosse, int lato) {
		Scacchiera scacchiera = new Scacchiera(lato);
		for (Mossa mossa : mosse)
			scacchiera.set(mossa, Stato.REGINA);
		log.debug(scacchiera);
	}

}
