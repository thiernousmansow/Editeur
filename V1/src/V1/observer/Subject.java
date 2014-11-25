package V1.observer;

import java.util.Collection;

public abstract class Subject {

	protected Collection<Observer> _observers;
	public abstract void notifyObservers();
	public abstract void unregisterObserver(Observer o);
	public abstract void registerObserver(Observer o);
}
