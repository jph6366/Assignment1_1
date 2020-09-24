

public class MVCApp {

	public static void startMVC() 
	{
		SDModelFactory.getSingleton().addPropertyChangeListener(SDViewFactory.getSingleton());
		SDControllerFactory.getSingleton().processInput();
		
		
	}


}
