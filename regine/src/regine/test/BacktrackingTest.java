package regine.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import regine.Regine;
import regine.scacchi.Mossa;
import regine.scacchi.Scacchiera;
import regine.util.Single;
import regine.util.Tempo;

class BacktrackingTest implements Single {

	@Test
	void test() {
		try {
			Tempo tempo = new Tempo();
			Regine.backtracking(new Scacchiera(7), new Mossa(0, 0));
			log.debug(tempo);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
