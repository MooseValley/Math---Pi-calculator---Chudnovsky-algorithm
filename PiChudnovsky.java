/*

This gives 6 decimal digits of accuracy for the 1st term (q=0).
   3.141592......

This gives 14 decimal digits of accuracy for the 2nd term (q=1).


*/
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.MathContext;



public class PiChudnovsky
{
   public static final BigDecimal  MINUS_ONE = new BigDecimal ("-1");
   public static final MathContext PRECISION = new MathContext(10_000); // Decimal Places


   public static BigDecimal factorial (int value1)
   {
      //BigDecimal count  = BigDecimal.ZERO;
      BigDecimal result = BigDecimal.ONE;

      BigDecimal count  = new BigDecimal ("" + value1 );

      while (count.compareTo (BigDecimal.ONE) > 0)
      {
         result = result.multiply (count);
         count  = count.subtract  (BigDecimal.ONE);
      }

      return result;
   }

   public static BigDecimal calculateTerm (int q)
   {
      BigDecimal numeratorTerm1 = MINUS_ONE.pow (q); // Math.pow (-1, k)

      BigDecimal numeratorTerm2 = factorial (6 * q);

      BigDecimal numeratorTerm3 = new BigDecimal ("" + q);
      numeratorTerm3 = numeratorTerm3.multiply (new BigDecimal ("545140134") );
      numeratorTerm3 = numeratorTerm3.add      (new BigDecimal ("13591409")  );

      BigDecimal denominatorTerm1 = factorial (3 * q);
      BigDecimal denominatorTerm2 = factorial (q);
      denominatorTerm2 = denominatorTerm2.pow (3);

      BigDecimal denominatorTerm3 = new BigDecimal ("-262537412640768000");
      denominatorTerm3 = denominatorTerm3.pow (q);


      BigDecimal numerator   = numeratorTerm1.multiply (numeratorTerm2).multiply (numeratorTerm3);
      BigDecimal denominator = denominatorTerm1.multiply (denominatorTerm2).multiply (denominatorTerm3);

      BigDecimal result1 = numerator.divide (denominator, PRECISION);

      System.out.println ("    numeratorTerm1:   " + numeratorTerm1);
      System.out.println ("    numeratorTerm2:   " + numeratorTerm2);
      System.out.println ("    numeratorTerm3:   " + numeratorTerm3);
      System.out.println ("    denominatorTerm1: " + denominatorTerm1);
      System.out.println ("    denominatorTerm2: " + denominatorTerm2);
      System.out.println ("    denominatorTerm3: " + denominatorTerm3);
      System.out.println ("    numerator:        " + numerator);
      System.out.println ("    denominator:      " + denominator);


      System.out.println ("-> Term " + q + ": " + result1);
      System.out.println ();

      return result1;
   }

   public static BigDecimal calculatePi ()
   {
      BigDecimal numerator      = new BigDecimal ("42698672");
      BigDecimal denominatorSum = new BigDecimal ("0");

      for (int k = 0; k < 2; k++)
      {
         denominatorSum = denominatorSum.add (calculateTerm (k) );
      }

      BigDecimal result2 = numerator.divide (denominatorSum, PRECISION);

      return result2;
   }


   public static void main (String[] args)
   {
      System.out.println (factorial (10) );
      System.out.println ((10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1) );
      //System.out.println (new BigDecimal (calculateTerm (1) ) );
      System.out.println (calculatePi () );
   }
}