
public class AppMainBasic {

	public static void main(String[] args) 
	{
		SDModelFactory.setSingleton(new AppModelBasic());
		SDControllerFactory.setSingleton(new SDController());
		MVCApp.startMVC();
		
		
	}


}
