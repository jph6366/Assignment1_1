

public class SDViewFactory {
	
	static SDView sDView;
	
	public static  SDView getSingleton() 
	{
		if(sDView == null) sDView = new SDAppView();
		return sDView;
	}
	
	public static void setSingleton(SDView newView)
	{
		sDView = newView;
	}

}
