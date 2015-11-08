package mission;
import java.util.*;
import mission.Plateau;
import mission.Rover;

public class Mission {
  private List<Rover> rovers;
  private Plateau plateau;

  public Mission(List<Rover> rovers, Plateau plateau) {
    this.rovers = rovers;
    this.plateau = plateau;
  }

  public String advanceRovers() {
    String finalCoords = "";

    for (Rover rover : rovers) {
      String instructions = (String)rover.getInstructions();
      for (int i = 0; i < instructions.length(); i++ ) {
        rover.advance(Character.toString(instructions.charAt(i)));
        if (!plateau.inBounds(rover.getX(), rover.getY())) {
          rover.setX(-1);
          rover.setY(-1);
          break;
        }
      }
      finalCoords += rover + "\n";
    }
    return finalCoords;
  }
}