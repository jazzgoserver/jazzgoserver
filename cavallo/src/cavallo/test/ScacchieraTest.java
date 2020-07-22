package cavallo.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import cavallo.scacchi.Scacchiera;
import cavallo.util.Single;

class ScacchieraTest implements Single {

	@Test
	void test() {
		try {
			Scacchiera scacchiera = new Scacchiera(4);
			log.debug(scacchiera);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
