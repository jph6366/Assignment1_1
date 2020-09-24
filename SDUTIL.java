
import java.util.ArrayList;
import java.util.List;

import gradingTools.comp524f20.assignment1.WekaUtil;

public class SDUTIL{

	/**
	If the combination of the method parameters is safe, based on the given data,  the function returns true. Otherwise, it returns false.
	  */
	public static boolean isGivenSafe(int dist, int durat, int exhal)
	{
		if (dist == 13 && durat == 30 && exhal == 30) return true;
		else if (dist == 6 && durat == 30 && exhal == 10) return true;
		else if (dist == 27 && durat == 30 && exhal == 50) return true;
		else if (dist == 13 && durat == 15 && exhal == 50) return true;
		else if (dist == 13 && durat == 120 && exhal == 10) return true;
		else if (dist == 27 && durat == 120 && exhal == 30) return true;
		else if (dist == 6 && durat == 15 && exhal == 30) return true;
		else { return false;}
	}
	
	/**
	 the three parameters represent distance, duration, and exhalation level. The
	function interpolates each of the parameters to a value in Table 2, and determines if the
	interpolated values are safe based on whether they occur in Table 2. Returns true if safe.
	 **/
	public static boolean isInterpolateSafe(int dist,int durat,int exhal)
	{
		String dist_intrp; 
		String durat_intrp; 
		String exhal_intrp;
		//dist
		if (dist > 0 && dist <= 6) dist_intrp = "Small";
		else if (dist > 6 && dist <= 13) dist_intrp = "Medium";
		else if (dist > 13 && dist <=27) dist_intrp = "Large";
		else {return false;}
		//durat
		if (durat > 0 && durat <= 15) durat_intrp = "Small";
		else if (durat > 15 && durat <= 30) durat_intrp = "Medium";
		else if (durat > 30 && durat <= 120) durat_intrp = "Large";
		else {return false;}
		//exhal
		if (exhal > 0 && exhal <= 10) exhal_intrp = "Small";
		else if (exhal > 10 && exhal <= 30) exhal_intrp = "Medium";
		else if (exhal > 30 && exhal <= 50) exhal_intrp = "Large";
		else {return false;}
		
		if (dist_intrp == "Small") dist = 6;
		if (dist_intrp == "Medium") dist = 13;
		if (dist_intrp == "Large") dist = 27;
		if (durat_intrp == "Small") durat = 15;
		if (durat_intrp == "Medium") durat = 30;
		if (durat_intrp == "Large") durat = 120;
		if (exhal_intrp == "Small") exhal = 10;
		if (exhal_intrp == "Medium") exhal = 30;
		if (exhal_intrp == "Large") exhal = 50;
		
		return isGivenSafe(dist, durat, exhal);
	}
	
	// two parameter
	public static boolean isInterpolateSafe(int dist,int durat) 
	{
		return isInterpolateSafe(dist, durat, 30);
	}
	
	// one parameter
	public static boolean isInterpolateSafe(int dist) 
	{
		return isInterpolateSafe(dist, 30, 30);
	}
	
	/**
	It uses Math.random() function to generate a distance, duration, and exhalation level
	combination.
	It determines whether this combination is safe based on the isDerivedSafe() function
	described below
	It prints the (distance, duration, exhalation level, and safety) tuple, using a comma to
	separate the elements of the 4-tuple.
	**/
	public static void printGeneratedCombinationDerivedSafety() 
	{
		int dist = (int)(Math.random()*100);
		int durat = (int)(Math.random()*200);
		int exhal = (int)(Math.random()*100);
		
		String[] tuple = {Integer.toString(dist),Integer.toString(durat),Integer.toString(exhal),Boolean.toString(isDerivedSafe(dist, durat, exhal))};
		
		System.out.println(tuple[0]+","+tuple[1]+","+tuple[2]+","+tuple[3]);
	}
	
	/**
	It prints the following header:

	Distance,Duration,Exhalation,IsSafe

	For each 3-tuple combination in Table 2, it adds the Boolean true to create a 4-tuple combination and prints the 4-tuple, again using a comma to separate the elements of the tuple.

	It prints a separator line with one or more hyphens.

	It then calls printGeneratedCombinationDerivedSafety() ten times.

	**/
	public static void printGivenAndGeneratedCombinationsDerivedSafety() 
	{ 
		System.out.println("Distance,Duration,Exhalation,IsSafe");
		System.out.println("	13,30,30,true");
		System.out.println("	6,30,10,true");
		System.out.println("	27,30,50,true");
		System.out.println("	13,15,50,true");
		System.out.println("	13,120,10,true");
		System.out.println("	27,120,30,true");
		System.out.println("	6,15,30,true");
		System.out.println("----------------");
		for (int i=0; i<10; i++) {
			printGeneratedCombinationDerivedSafety();
		}
	}
	
	/**
	The procedure computes a (possibly empty) list of given safe distance and duration pairs that are associated with an interpolation of the exhalation level in Table 2.

	Each pair is returned by a two-element array whose first element is the distance and second element is the duration.

	**/
	public static List<Integer[]> generateSafeDistancesAndDurations(int exhal)
	{
		List<Integer[]> pairs = new ArrayList<Integer[]>();
		for(int i=6; i<28; i=(i*2)+1)
		{
			int count = 0;
			for(int j=15; j<121; j=j*(2*count))
			{
				count+=1;
				if (isInterpolateSafe(i,j,exhal)) 
				{
					pairs.add(new Integer[]{i,j});
				}
			}
		}
		
		return pairs;
	}
	
	/**
	Helper method to print out the the multiple pairs of distance and duration into one big string and return it
	**/
	public static String toString(List<Integer[]> pairs)
	{
		String ts = "[";
		for(int i = 0; i < pairs.size(); i++)
		{
			ts += "{" + pairs.get(i)[0].toString() + "," + pairs.get(i)[1].toString()+ "}";
        }
		return ts += "]";
		
	}
	
	/**
	The parameter is an exhalation-level. It uses the method above to determine the list of safe distances and durations for the passed exhalation-level and 
	prints the passed exhalation level together with the returned list using the format below:

	<exhalation level>, [{<destination,duration1}, … {<destination>, <duration>}]

	**/
	public static void printSafeDistancesAndDurations(int exhal) 
	{
		System.out.println(exhal + "," + toString(generateSafeDistancesAndDurations(exhal)));
	}
	
	/**
	It returns true if the combination of these three parameters is safer than at least one of the combinations in the table.
	**/
	public static boolean isDerivedSafe(int dist, int durat, int exhal)
	{
		List<Integer[]> pairs = generateSafeDistancesAndDurations(exhal);
		for(int i = 0; i < pairs.size(); i++)
		{
			if(dist >= pairs.get(i)[0] && durat <= pairs.get(i)[1])
			{
				return true;
			}
        }
		return false;
		
		
	}
	
	public static Boolean isInferredSafe(int dist, int durat, int exhal) {
		final String TRUE = "true";
		final String FALSE = "false";
		final String[] featureNames = {"distance", "duration","exhalation Level"};
		final String resultAttributeName = "safe";
		final String[] resultValueNames = {TRUE,FALSE};
		double[] inputValues = {dist, durat, exhal};
		String resultString = WekaUtil.predictString(ClassifierFactory.getSingleton(), featureNames, inputValues, resultAttributeName, resultValueNames);
		return TRUE.equals(resultString)?true:false;
	}
	
	public static void printGeneratedCombinationInferredSafety() 
	{
		int dist = (int)(Math.random()*100);
		int durat = (int)(Math.random()*200);
		int exhal = (int)(Math.random()*100);
		
		String[] tuple = {Integer.toString(dist),Integer.toString(durat),Integer.toString(exhal),Boolean.toString(isInferredSafe(dist, durat, exhal))};
		
		System.out.println(tuple[0]+","+tuple[1]+","+tuple[2]+","+tuple[3]);
	}
	
	public static void printGivenAndGeneratedCombinationsInferredSafety()
	{
		System.out.println("Distance,Duration,Exhalation,IsSafe");
		System.out.println("	13,30,30,true");
		System.out.println("	6,30,10,true");
		System.out.println("	27,30,50,true");
		System.out.println("	13,15,50,true");
		System.out.println("	13,120,10,true");
		System.out.println("	27,120,30,true");
		System.out.println("	6,15,30,true");
		System.out.println("----------------");
		for (int i=0; i<10; i++) {
			printGeneratedCombinationInferredSafety();
		}
	}
	
	public static void printGeneratedCombination()
	{
		int dist = (int)(Math.random()*100);
		int durat = (int)(Math.random()*200);
		int exhal = (int)(Math.random()*100);
		
		String[] tuple = {Integer.toString(dist),Integer.toString(durat),Integer.toString(exhal),Boolean.toString(isDerivedSafe(dist, durat, exhal)),Boolean.toString(isInferredSafe(dist, durat, exhal))};
		
		System.out.println(tuple[0]+","+tuple[1]+","+tuple[2]+","+tuple[3]+","+tuple[4]);
	}
	
	public static void compareSafetyComputations()
	{
		System.out.println(SDModel.Distance+","+SDModel.Duration+","+SDModel.ExhalationLevel+","+"Derived"+","+"Inferred");
		for (int i=0; i<10; i++) {
			printGeneratedCombination();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
