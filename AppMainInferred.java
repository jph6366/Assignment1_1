
public class AppMainInferred {

	public static void main(String[] args) 
	{
		SDModelFactory.setSingleton(new AppModelInferred());
		SDControllerFactory.setSingleton(new SDController());
		MVCApp.startMVC();
		
		
	}


}
