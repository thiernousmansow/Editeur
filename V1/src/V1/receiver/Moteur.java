package V1.receiver;

public interface Moteur  {
	
	void Selectionner(int debutSelection, int finSelection);
	public void Copier();
	public void Couper();
	public void Coller();
	public void Supprimer();
	public void Inserer(char c);	

}
