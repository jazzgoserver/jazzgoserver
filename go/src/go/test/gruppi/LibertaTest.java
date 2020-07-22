package go.test.gruppi;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import go.Go;
import go.goban.Goban;
import go.gruppi.Punto;
import go.util.Single;

class LibertaTest implements Single {

	@Test
	void test() {
		try {
			Go go = new Go(Goban.PICCOLO);
			Goban goban = go.getGoban();
			while (!go.finita()) {
				Punto mossa = go.muovi();
				List<Punto> liberta = mossa.liberta(goban);
				if (!liberta.isEmpty())
					log.debug(mossa + DEBUG + liberta);
			}

		} catch (Exception e) {
			log.error(e);
			fail(e.getMessage());
		}
	}
}
