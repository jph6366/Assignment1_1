
public class AppModelBasic extends AppModelAbstract {

	@Override
	public Boolean isSafe() {
		Boolean k = SDUTIL.isGivenSafe(getDistance(), getDuration(), getExhalation());
		propertyChangeSupport.firePropertyChange(Safe, null, k);
		return k;
		
	}



}
