package cavallo.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import cavallo.Cavallo;
import cavallo.scacchi.Mossa;
import cavallo.scacchi.Scacchiera;
import cavallo.util.Single;
import cavallo.util.Tempo;

class BacktrackingTest implements Single {

	@Test
	void test() {
		try {
			Tempo tempo = new Tempo();
			Cavallo.backtracking(new Scacchiera(5), new Mossa(0, 0), Cavallo.PRIMA);
			log.debug(tempo);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
