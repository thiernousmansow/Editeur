package V1.command;

import V1.receiver.Moteur_impl;

public class Copier implements Command {

	private Moteur_impl _moteur;
	
	public Copier(Moteur_impl moteur) {
		_moteur = moteur;
	}

	@Override
	public void execute() {
		_moteur.Copier();
	}

}
