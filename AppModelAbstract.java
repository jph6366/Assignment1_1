

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AppModelAbstract implements SDModel {
	
	private int distance;
	private int duration;
	private int exhalation;
	private Boolean safe;
	
	@Override
	public int getDistance() {
		return this.distance;
	}

	@Override
	public int getDuration() {
		return this.duration;
	}

	@Override
	public int getExhalation() {
		return this.exhalation;
	}

	
	public PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(PropertyChangeListener aListener) {
		propertyChangeSupport.addPropertyChangeListener(aListener);
	}
	
	
	@Override
	public void setInteraction(int distance, int duration, int exhalation_level) {
		int oldDistance = this.distance;
		int oldDuration = this.duration;
		int oldExhalation = this.exhalation;
		Boolean oldSafe = this.safe;
		this.distance = distance;
		this.duration = duration;
		this.exhalation = exhalation_level;
		propertyChangeSupport.firePropertyChange(SDModel.Distance, oldDistance, this.distance);
		propertyChangeSupport.firePropertyChange(SDModel.Duration, oldDuration, this.duration);
		propertyChangeSupport.firePropertyChange(SDModel.ExhalationLevel, oldExhalation, this.exhalation );
		this.isSafe();
	}

}
