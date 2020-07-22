package regine.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import regine.scacchi.Scacchiera;
import regine.util.Single;

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
