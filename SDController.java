

import java.util.Scanner;

public class SDController{

	public void processInput()
	{
		int dist = 0; 
		int durat = 0;
		int exhal = 0;
		
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Please enter data regarding your guest interaction.");
			System.out.println("Distance?");
			dist = input.nextInt();
			if(dist == -1) break;
			System.out.println("Duration?");
			durat = input.nextInt();
			if(durat == -1) break;
			System.out.println("Exhalation Level?");
			exhal = input.nextInt();
			if(exhal == -1) break;
			
			SDModelFactory.getSingleton().setInteraction(dist, durat, exhal);
			
		}
		System.out.println("Quitting");
		input.close();
	}
}
