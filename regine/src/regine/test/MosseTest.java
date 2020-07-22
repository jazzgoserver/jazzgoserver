package regine.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import regine.Regine;
import regine.scacchi.Mossa;
import regine.util.Single;

class MosseTest implements Single {

	@Test
	void test() {
		try {
			int lato = 8;
			Regine.debug(Regine.regina(new Mossa(3, 4), lato), lato);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
