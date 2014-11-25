package V1.command;

import V1.invoker.IHM;
import V1.receiver.Moteur_impl;

public class Selectionner implements Command {
	
	private Moteur_impl moteur;
	private IHM ihm;

	public Selectionner(Moteur_impl moteur, IHM ihm) {
		this.moteur = moteur;
		this.ihm = ihm;
	}

	@Override
	public void execute() {
		
		moteur.Selectionner(ihm.getDebutSelection(), ihm.getFinSelection());
	}

}
