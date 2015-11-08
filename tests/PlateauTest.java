package tests;
import mission.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.* ;

public class PlateauTest {
   private Plateau plateau;

   @Before
   public void makePlateau() {
      int xBound = 5;
      int yBound = 5;
      plateau = new Plateau(xBound, yBound);
   }

   @Test
   public void testExceedsBoundsInBounds() {
      System.out.println("inBounds should return false for x or y that exceeds boundaries");
      int x = 6;
      int y = 5;
      assertFalse(plateau.inBounds(x, y));
   }

   @Test
   public void testNegativeInputInBounds() {
      System.out.println("inBounds should return false for x or y less than 0");
      int x = 5;
      int y = -1;
      assertFalse(plateau.inBounds(x, y));
   }

   @Test
   public void testInBounds() {
      System.out.println("inBounds should return true for x and y within bounds");
      int x = 5;
      int y = 5;
      assertTrue(plateau.inBounds(x, y));
      x = 0;
      y = 0;
      assertTrue(plateau.inBounds(x, y));
   }
}