
public class AppMainDerived {

	public static void main(String[] args) 
	{
		SDModelFactory.setSingleton(new AppModelDerived());
		SDControllerFactory.setSingleton(new SDController());
		MVCApp.startMVC();
		
		
	}


}
