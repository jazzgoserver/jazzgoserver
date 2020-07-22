package go.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.Go;
import go.goban.Goban;
import go.util.Single;

class GoTest implements Single {

	@Test
	void test() {
		try {
			Go go = new Go(Goban.PICCOLO);
			while (!go.finita())
				go.muovi();
			log.debug(go);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
