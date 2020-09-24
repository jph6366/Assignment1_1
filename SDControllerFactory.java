

public class SDControllerFactory {
	
	static SDController Singleton;
	
	public static SDController getSingleton() 
	{
		if(Singleton == null) Singleton = new SDController();
		return Singleton;
	}
	
	public static void setSingleton(SDController newController)
	{
		Singleton = newController;
	}

}
