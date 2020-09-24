

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SDAppView implements SDView,PropertyChangeListener {
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.toString());
		if(evt.getPropertyName().equals("safe")) {
			if((boolean) evt.getNewValue()) {
				System.out.println("Safe");
			} else {
				System.out.println("Not Safe!");
			}
		}
	}
}
