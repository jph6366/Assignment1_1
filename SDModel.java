
import java.beans.PropertyChangeListener; // type of an observer of editable properties
public interface SDModel {
	public static final String Distance = "distance";
	public static final String Duration = "duration";
	public static final String ExhalationLevel = "exhalation level";
	public static final String Safe = "safe";
	
	int getDistance();
	int getDuration();
	int getExhalation();
	Boolean isSafe();
	
	void setInteraction(int distance, int duration, int exhalation_level);
	void addPropertyChangeListener(PropertyChangeListener aListener);
	
}
