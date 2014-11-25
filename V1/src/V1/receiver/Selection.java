package V1.receiver;

public class Selection {

	private int _debutSelection;
	private int _finSelection;

	public int getDebut() {
		return _debutSelection;
	}
	
	public int getFin() {
		return _finSelection;
	}

	public int getLongueur() {
		return _finSelection-_debutSelection;
	}

	public void setDebut(int debutSelection) {
		_debutSelection = debutSelection;
	}

	public void setFin(int finSelection) {
		_finSelection = finSelection;
	}
}
