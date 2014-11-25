package V1.receiver;

import java.util.ArrayList;

import V1.observer.Observer;
import V1.observer.Subject;

public class Moteur_impl extends Subject implements Moteur {

	private Buffer _buffer;
	private Selection _selection;
	private PressePapier _pressePapier;
	
	public Moteur_impl(){
		_buffer = new Buffer();
		_selection = new Selection();
		_pressePapier = new PressePapier();
		_observers = new ArrayList<Observer>();
	}
	
	public String getTexte(){
		return _buffer.getTexte(0, _buffer.getLongueurTexte());
	}
	
	public int getSelectionDebut(){
		return _selection.getDebut();
	}
	
	public int getSelectionFin(){
		return _selection.getFin();
	}
	
	@Override
	public void Selectionner(int debutSelection, int finSelection) {
		_selection.setDebut(debutSelection);
		_selection.setFin(finSelection);
	}

	@Override
	public void Copier() {
		if(_selection.getLongueur() > 0){
			_pressePapier.setTexte(_buffer.getTexte(_selection.getDebut(), _selection.getFin()));
		}
	}

	@Override
	public void Couper() {
		
		if(_selection.getLongueur() > 0){
			_pressePapier.setTexte(_buffer.getTexte(_selection.getDebut(), _selection.getFin()));
			_buffer.delete(_selection.getDebut(), _selection.getFin());
			Selectionner(_selection.getDebut(),_selection.getDebut());
			
			notifyObservers();
		}
	}

	@Override
	public void Coller() {
		if(_selection.getLongueur() > 0){
			_buffer.delete(_selection.getDebut(), _selection.getFin());
			Selectionner(_selection.getDebut(),_selection.getDebut());
		}
		_buffer.insert(_selection.getDebut(), _pressePapier.getTexte());
		int select = _selection.getDebut() + _pressePapier.getLongueurTexte();
		Selectionner(select, select);
		
		notifyObservers();
	}

	@Override
	public void Inserer(char c) {
		if(_selection.getLongueur() > 0){
			_buffer.delete(_selection.getDebut(), _selection.getFin());
			Selectionner(_selection.getDebut(),_selection.getDebut());
		}
		_buffer.insert(_selection.getDebut(), Character.toString(c));
		Selectionner(_selection.getDebut()+1,_selection.getDebut()+1);

		notifyObservers();
	}

	@Override
	public void Supprimer() {
		if(_selection.getLongueur() > 0){
			_buffer.delete(_selection.getDebut(), _selection.getFin());
			Selectionner(_selection.getDebut(),_selection.getDebut());
		} else if(_selection.getDebut() > 0){
			_buffer.delete(_selection.getDebut()-1, _selection.getDebut());
			Selectionner(_selection.getDebut()-1,_selection.getDebut()-1);
		}
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for(Observer o : _observers){
			o.notifyMe();
		}
	}

	@Override
	public void registerObserver(Observer o) {
		_observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		_observers.remove(o);
	}

}
