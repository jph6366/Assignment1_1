

public class AppModelInterpolation extends AppModelAbstract {

	@Override
	public Boolean isSafe() {
		Boolean k = SDUTIL.isInterpolateSafe(getDistance(), getDuration(), getExhalation());
		propertyChangeSupport.firePropertyChange(Safe, null, k);
		return k;
	}



}
