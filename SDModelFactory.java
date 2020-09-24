
public class SDModelFactory {
	
	// Singleton
	static SDModel Singleton;
	
	public static SDModel getSingleton() 
	{
		if(Singleton == null) Singleton = new AppModelBasic();
		return Singleton;
	}
	
	public static void setSingleton(SDModel newModel)
	{
		Singleton = newModel;
	}

}
