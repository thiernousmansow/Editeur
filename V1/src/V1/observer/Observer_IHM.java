package V1.observer;

import V1.receiver.Moteur_impl;
import V1.invoker.IHM;


public class Observer_IHM extends IHM implements Observer {

	Subject _subject;
	
	public Observer_IHM(Subject subject) {
		_subject = subject;
	}

	@Override
	public void notifyMe() {
		Moteur_impl moteur = (Moteur_impl) _subject;
		_zoneDeSaisie.miseAJour( moteur.getTexte(),	moteur.getSelectionDebut(),	moteur.getSelectionFin());
	}

}
