package V1.command;

import V1.receiver.Moteur_impl;

public class Supprimer implements Command {
	
	private Moteur_impl moteur;

	public Supprimer(Moteur_impl moteur) {
		this.moteur = moteur;
	}

	@Override
	public void execute() {
		moteur.Supprimer();
	}

}
