package tests;
import mission.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.* ;
import java.util.*;

public class ParserTest {
   private Parser parser;

   @Before
   public void makeParser() {
      parser = new Parser("input.txt");
   }

   @Test
   public void testMakePlateauLargeCoords() {
      System.out.println("makePlateau should return a plateau with multi-digit input");
      Plateau plateau = parser.makePlateau("7000 6000");
      assertTrue(plateau.getX() == 7000);
      assertTrue(plateau.getY() == 6000);
   }

   @Test
   public void testMakePlateauBadInput() {
      System.out.println("makePlateau should return a plateau with coords -1, -1 for bad input");
      Plateau plateau = parser.makePlateau("banana grams");
      assertTrue(plateau.getX() == -1);
      assertTrue(plateau.getY() == -1);
   }

   @Test
   public void testCheckInstructions() {
      System.out.println("checkInstructions should return true for well-formatted instructions");
      boolean result = parser.checkInstructions("LMLMRRM");
      assertTrue(result == true);
   }

   @Test
   public void testCheckInstructionsBadInput() {
      System.out.println("checkInstructions should return false for instructions with bad chars");
      boolean result = parser.checkInstructions("LMRbananaMRLL");
      assertTrue(result == false);
   }

   @Test
   public void checkPosition() {
      System.out.println("checkPosition should return true for well-formatted position info");
      boolean result = parser.checkPosition("100 500 N");
      assertTrue(result == true);
   }

   @Test
   public void checkPositionBadXYInput() {
      System.out.println("checkPosition should return false for non-number x or y coordinates");
      boolean result = parser.checkPosition("100 banana N");
      assertTrue(result == false);
   }

   @Test
   public void checkPositionBadDirectionInput() {
      System.out.println("checkPosition should return false for non-cardinal direction info");
      boolean result = parser.checkPosition("100 500 NW");
      assertTrue(result == false);
   }
}