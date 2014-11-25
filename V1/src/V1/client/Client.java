package V1.client;
import java.util.HashMap;

import V1.observer.Observer_IHM;
import V1.receiver.*;
import V1.command.*;

public class Client {

	Moteur_impl _moteur;
	Observer_IHM _ihm;
	HashMap<String,Command> _commandes;

	public Client(){
		_moteur = new Moteur_impl();
		_ihm = new Observer_IHM(_moteur);
		_commandes = new HashMap<String,Command>();
		_commandes.put("couper", new Couper(_moteur));
		_commandes.put("copier", new Copier(_moteur));
		_commandes.put("coller", new Coller(_moteur));
		_commandes.put("selectionner", new Selectionner(_moteur, _ihm));
		_commandes.put("inserer", new Inserer(_moteur, _ihm));
		_commandes.put("supprimer", new Supprimer(_moteur));
	}

	public void start(){
		_ihm.initComposants(_commandes);
		_moteur.registerObserver(_ihm);
		_ihm.affichage();
	}

	public static void main(String args[]) {
		Client client = new Client();
		client.start();
	}

}
