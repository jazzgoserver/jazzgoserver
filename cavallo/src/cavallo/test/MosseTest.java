package cavallo.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import cavallo.Cavallo;
import cavallo.scacchi.Mossa;
import cavallo.util.Single;

class MosseTest implements Single {

	@Test
	void test() {
		try {
			int lato = 8;
			Cavallo.debug(Cavallo.mosse(new Mossa(3, 4), lato), lato);

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
