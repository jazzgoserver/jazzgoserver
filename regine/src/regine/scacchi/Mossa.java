package regine.scacchi;

import regine.util.Single;

public class Mossa implements Single {
	private int colonna;
	private int traversa;

	public Mossa(int colonna, int traversa) {
		this.colonna = colonna;
		this.traversa = traversa;
	}

	public Mossa trasla(int colonna, int traversa) {
		return new Mossa(this.colonna + colonna, this.traversa + traversa);
	}

	public boolean legale(int lato) {
		return colonna >= 0 && colonna < lato && traversa >= 0 && traversa < lato;
	}

	public int getColonna() {
		return colonna;
	}

	public int getTraversa() {
		return traversa;
	}

}
