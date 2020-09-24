
import java.beans.PropertyChangeListener;

public class AppModelDerived extends AppModelAbstract {

	@Override
	public Boolean isSafe() {
		Boolean k = SDUTIL.isDerivedSafe(getDistance(), getDuration(), getExhalation());
		propertyChangeSupport.firePropertyChange(Safe, null, k);
		return k;
	}



}
