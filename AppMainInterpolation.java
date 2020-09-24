
public class AppMainInterpolation {

	public static void main(String[] args) 
	{
		SDModelFactory.setSingleton(new AppModelInterpolation());
		SDControllerFactory.setSingleton(new SDController());
		MVCApp.startMVC();
		
		
	}


}
