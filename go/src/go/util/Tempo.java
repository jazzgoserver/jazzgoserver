package go.util;

import java.util.Date;

public class Tempo {
	private Date inizio = new Date();

	public long trascorso() {
		return new Date().getTime() - inizio.getTime();
	}

	@Override
	public String toString() {
		return String.format("tempo trascorso:%,d ms", trascorso());
	}
}
