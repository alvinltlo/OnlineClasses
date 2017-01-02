package test.designPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Screen is observing the datastore
 *
 */
public class ObserverPattern {

	public static void main(String[] args) {
		Screen screen = new Screen();
		DataStore dataStore = new DataStore();

		// register observer
		dataStore.addObserver(screen);
		dataStore.setData("test");

		// remove observer
		dataStore.deleteObserver(screen);
	}
}

class DataStore extends Observable {
	private String data;

	public void setData(String data) {
		this.data = data;
		/**
		 * mark the observable as changed Note: In a long running program you
		 * may call several times setChanged() but at end, only call once
		 * notifyObservers(). If, before end, for internal reason you decide to
		 * rollback you may choose to call clearChanged(). In the later case,
		 * notifyObservers() has no effect.
		 */
		setChanged();
		/**
		 * optional to pass-in any parameter to the Observer
		 */
		this.notifyObservers(data);
	}
}

class Screen implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Screen is notified: " + arg);
	}
}