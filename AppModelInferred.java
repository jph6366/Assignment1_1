

public class AppModelInferred extends AppModelAbstract {

	@Override
	public Boolean isSafe() {
		Boolean k = SDUTIL.isInferredSafe(getDistance(), getDuration(), getExhalation());
		propertyChangeSupport.firePropertyChange(Safe, null, k);
		return k;
	}


}
