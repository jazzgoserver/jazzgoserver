package go.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.goban.Goban;
import go.util.Single;

class GobanTest implements Single {

	@Test
	void test() {
		try {
			Goban goban = new Goban(Goban.PICCOLO);
			log.debug(goban);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
