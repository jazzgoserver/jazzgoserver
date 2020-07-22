package go.test.sgf;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.sgf.SGFScanner;
import go.util.Single;

class ScannerTest implements Single {

	@Test
	void test() {
		try {
			for (String linea : SGFScanner.load("cho.sgf")) {
				log.debug(linea);

				SGFScanner scanner = new SGFScanner(linea);
				log.debug(scanner);
			}

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
