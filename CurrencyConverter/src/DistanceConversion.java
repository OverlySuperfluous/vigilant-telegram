import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DistanceConversion
{
	// Everything is based off of FEET
	// The code converts using ratios...
	
//	private static float       inch = 0.08333f;
//	private static float       foot = 1.0000f;
//	private static float       yard = 3.0000f;    		// As in, 3 feet in a yard.
//	private static float       mile = 5280.0000f;		// As in, 5280 feet in a mile.
//	
//	private static float micrometer = 0.00000328084f;
//	private static float millimeter = 0.00328084f;
//	private static float centimeter = 0.0328084f;
//	private static float      meter = 3.28084f;
//	private static float  kilometer = 3280.8400f; 		// As in, 3280.8400 feet in a kilometer
//	
//	private static float   nautmile = 6076.1200f;
	
	// To make the code simpler...
	public static String[]  units = { "Inch", "Foot", "Yard", "Mile", "Micrometer", "Millimeter", "Centimeter",
									  "Meter", "Kilometer", "Nautical Mile" };
	private static float[] ratios = { 0.0833333333f, 1.0000f, 3.0000f, 5280.0000f, 0.00000328084f, 0.00328084f,
									  0.0328084f, 3.28084f, 3280.8400f, 6076.1200f };

	public static float convert(int sourceUnit, int targetUnit, float distance)
	{		
		return distance * (ratios[sourceUnit] / ratios[targetUnit]);
	}
	
	public static String convertWithPrecision(int sourceUnit, int targetUnit, float distance, int decimalPlaces)
	{
		String result = "";
		
		if (decimalPlaces > 0)
		{
			String formatting = "##.";
			for (int i = 0; i < decimalPlaces; i++)
				formatting += "#";
			
			DecimalFormat df = new DecimalFormat(formatting); // Set decimal places
			df.setRoundingMode(RoundingMode.HALF_UP);
			
			result = df.format(convert(sourceUnit, targetUnit, distance));
		}
		else
		{
			result = Float.toString(convert(sourceUnit, targetUnit, distance));
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println("3 miles to inches: " + convertWithPrecision(3, 0, 3.0f, 2));
	}
}