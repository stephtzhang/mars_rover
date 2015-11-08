package tests;
import mission.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.* ;

public class RoverTest {
   private Rover rover;

   @Before
   public void makerRover() {
      int x = 1;
      int y = 2;
      String direction = "N";
      String instructions = "MMM";
      rover = new Rover(x, y, direction, instructions);
   }

   @Test
   public void testAdvanceL() {
      System.out.println("advance should change rover's cardinal direction for input 'L'");
      rover.advance("L");
      assertTrue(rover.getDirection() == "W");
      rover.advance("L");
      assertTrue(rover.getDirection() == "S");
      rover.advance("L");
      assertTrue(rover.getDirection() == "E");
      rover.advance("L");
      assertTrue(rover.getDirection() == "N");
   }

   @Test
   public void testAdvanceR() {
      System.out.println("advance should change rover's cardinal direction for input 'R'");
      rover.advance("R");
      assertTrue(rover.getDirection() == "E");
      rover.advance("R");
      assertTrue(rover.getDirection() == "S");
      rover.advance("R");
      assertTrue(rover.getDirection() == "W");
      rover.advance("R");
      assertTrue(rover.getDirection() == "N");
   }

   @Test
   public void testAdvanceM() {
      System.out.println("advance should increment rover in correct direction for input 'M'");
      int oldX = rover.getX();
      int oldY = rover.getY();
      rover.advance("M");
      assertTrue(rover.getX() == oldX);
      assertTrue(rover.getY() == oldY + 1);
   }

   @Test
   public void testToString() {
      System.out.println("toString should return a string with rover's coords and direction");
      String result = rover.toString();
      String xString = Integer.toString(rover.getX());
      String yString = Integer.toString(rover.getY());
      assertTrue(result.contains(xString));
      assertTrue(result.contains(yString));
      assertTrue(result.contains(rover.getDirection()));
   }

   @Test
   public void testSetX() {
      System.out.println("setX should update rover's x coordinate to given value");
      rover.setX(100);
      assertTrue(rover.getX() == 100);
   }

   @Test
   public void testSetY() {
      System.out.println("setY should update rover's y coordinate to given value");
      rover.setY(100);
      assertTrue(rover.getY() == 100);
   }

   @Test
   public void testGetX() {
      System.out.println("getX should return rover's x coordinate");
      assertTrue(rover.getX() == 1);
   }

   @Test
   public void testGetY() {
      System.out.println("getY should return rover's y coordinate");
      assertTrue(rover.getY() == 2);
   }

   @Test
   public void testGetInstructions() {
      System.out.println("getInstructions should return correct instructions");
      assertTrue(rover.getInstructions() == "MMM");
   }
}