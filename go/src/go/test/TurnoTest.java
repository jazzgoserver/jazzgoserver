package go.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.turni.Turno;
import go.util.Single;

class TurnoTest implements Single {

	@Test
	void test() {
		try {
			Turno turno = new Turno();
			for (int g = 0; g < turno.getGiocatori().size() + 1; g++)
				log.debug(turno.prossimo());

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
