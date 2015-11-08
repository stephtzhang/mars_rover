package tests;
import mission.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.* ;
import java.util.*;

public class MissionTest {
   private Plateau plateau;
   private List<Rover> rovers;

   @Before
   public void makePlateau() {
      int xBound = 5;
      int yBound = 5;
      plateau = new Plateau(xBound, yBound);
   }

   @Before
   public void makeRoverMap() {
      rovers = new ArrayList<Rover>();
   }

   @Test
   public void testAdvanceRovers() {
      System.out.println("advanceRovers should return a string with rovers' final coords");
      String instructions = "LMLMLMLMM";
      int x = 1;
      int y = 2;
      String direction = "N";
      Rover rover = new Rover(x, y, direction, instructions);
      rovers.add(rover);

      Mission mission = new Mission(rovers, plateau);
      assertEquals(mission.advanceRovers(), "1 3 N\n");
   }

   @Test
   public void testExceedBoundsAdvanceRovers() {
      System.out.println("advanceRovers should return -1, -1 for an out of bounds rover");
      String instructions = "MMM";
      int x = 5;
      int y = 5;
      String direction = "N";
      Rover rover = new Rover(x, y, direction, instructions);
      rovers.add(rover);

      Mission mission = new Mission(rovers, plateau);
      assertEquals(mission.advanceRovers(), "-1 -1 N\n");
   }
}