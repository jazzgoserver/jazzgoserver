package go.test.sgf;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.goban.Goban;
import go.sgf.SGF;
import go.sgf.SGFParser;
import go.sgf.SGFScanner;
import go.util.Single;

class ChoTest implements Single {

	@Test
	void test() {
		try {
			for (String linea : SGFScanner.load("cho.sgf")) {

				SGFScanner scanner = new SGFScanner(linea);
				SGFParser parser = new SGFParser(scanner.getTokens());

				SGF sgf = parser.getSgf();
				Goban goban = sgf.toGoban().ritaglia();

				log.debug(goban);
				log.debug(sgf);
			}

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
