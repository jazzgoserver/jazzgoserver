package go.test.gruppi;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import go.Go;
import go.goban.Colore;
import go.goban.Goban;
import go.gruppi.Gruppo;
import go.gruppi.Punto;
import go.util.Single;

class GruppoTest implements Single {

	@Test
	void test() {
		try {
			Go go = new Go(Goban.PICCOLO);
			Goban goban = go.getGoban();
			while (!go.finita()) {
				Punto mossa = go.muovi();
				Colore colore = goban.get(mossa);
				Gruppo gruppo = Gruppo.riconosci(new Gruppo(colore), goban, mossa);
				if (gruppo.size() > 1)
					log.debug(gruppo);
			}

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
