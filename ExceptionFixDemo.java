import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.MathContext;



public class ExceptionFixDemo
{

   public static void main (String[] args)
   {
      MathContext precision = new MathContext(1000); // 100 decimal digits of accuracy
      BigDecimal a = new BigDecimal("1");
      BigDecimal b = new BigDecimal("3");
      BigDecimal c = a.divide(b, precision);

      System.out.println (c);
   }
}
