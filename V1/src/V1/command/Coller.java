package V1.command;

import V1.receiver.Moteur_impl;

public class Coller implements Command {

	private Moteur_impl _moteur;

	public Coller(Moteur_impl moteur) {
		_moteur = moteur;
	}

	@Override
	public void execute() {
		_moteur.Coller();
	}

}