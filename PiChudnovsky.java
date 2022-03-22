/*

1st term (q=0): gives 6 decimal digits of accuracy:.
   3.141592......

First 4 terms (q=0, 1, 2, 3): gives 15 decimal digits of accuracy:.
   3.141592653589793...    Pi is correct to 15 digits


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
      //BigDecimal numeratorTerm1   = MINUS_ONE.pow (q); // Math.pow (-1, k)

      BigDecimal numeratorTerm1   = factorial (6 * q);

      BigDecimal numeratorTerm2   = new BigDecimal ("" + q);
      numeratorTerm2              = numeratorTerm2.multiply (new BigDecimal ("545140134") );
      numeratorTerm2              = numeratorTerm2.add      (new BigDecimal ("13591409")  );

      BigDecimal denominatorTerm1 = factorial (3 * q);
      BigDecimal denominatorTerm2 = factorial (q);
      denominatorTerm2            = denominatorTerm2.pow (3);

      BigDecimal denominatorTerm3 = new BigDecimal ("-262537412640768000");
      denominatorTerm3            = denominatorTerm3.pow (q);


      BigDecimal numerator   = numeratorTerm1.multiply   (numeratorTerm2);

      BigDecimal denominator = denominatorTerm1.multiply (denominatorTerm2);
      denominator            = denominator.multiply      (denominatorTerm3);

      BigDecimal result1     = numerator.divide (denominator, PRECISION);

      System.out.println ("    numeratorTerm1:   " + numeratorTerm1);
      System.out.println ("    numeratorTerm2:   " + numeratorTerm2);
    //System.out.println ("    numeratorTerm3:   " + numeratorTerm3);
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
      /* Matt Parker used:
         426880 x SQRT (10005) = 42698672 approx - NOPE - not good enough.
         SQRT (10005) = 100.025  (approx)  - NOPE - not good enough.
      */

      BigDecimal numerator      = new BigDecimal     ("426880");
      numerator                 = numerator.multiply (new BigDecimal ("" + Math.sqrt (10005) ) );

      BigDecimal denominatorSum = new BigDecimal ("0");

      for (int k = 0; k < 1; k++)
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