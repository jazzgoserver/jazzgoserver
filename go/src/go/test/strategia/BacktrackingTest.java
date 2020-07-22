package go.test.strategia;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.goban.Colore;
import go.goban.Goban;
import go.gruppi.Punto;
import go.sgf.SGF;
import go.sgf.SGFParser;
import go.sgf.SGFScanner;
import go.strategia.Backtracking;
import go.util.Single;
import go.util.Tempo;

class BacktrackingTest implements Single {

	@Test
	void test() {
		try {
			Tempo tempo = new Tempo();
			for (String linea : SGFScanner.load("cho.sgf")) {

				SGFScanner scanner = new SGFScanner(linea);
				SGFParser parser = new SGFParser(scanner.getTokens());

				SGF sgf = parser.getSgf();
				Goban goban = sgf.toGoban().ritaglia();

				Backtracking backtracking = new Backtracking(Backtracking.DECIMO, 10 * Backtracking.MILLE, 3);
				backtracking.backtracking(goban, new Punto(0, 0), Colore.NERO, 0);

				log.debug(backtracking);
			}
			log.debug(tempo);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
