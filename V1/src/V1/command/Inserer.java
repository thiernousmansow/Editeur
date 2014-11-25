package V1.command;

import V1.invoker.IHM;
import V1.receiver.Moteur_impl;

public class Inserer implements Command {

	private Moteur_impl _moteur;
	private IHM _ihm;
	
	public Inserer(Moteur_impl moteur, IHM ihm) {
		_moteur = moteur;
		_ihm = ihm;
	}

	@Override
	public void execute() {
		_moteur.Inserer(_ihm.getDernierCharactere());
	}

}
