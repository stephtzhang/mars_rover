package mission;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.*;


public class Parser {
  private List<Rover> rovers;
  private Plateau plateau;
  private String filepath;

  public Parser(String filepath) {
    this.filepath = filepath;
    rovers = new ArrayList<Rover>();
  }

  public Mission parseInput() {
    File file = new File(filepath);

    Rover rover;
    String position;
    String instructions;
    try {
      Scanner scanner =  new Scanner(file);
      if (scanner.hasNextLine()) {
        plateau = makePlateau(scanner.nextLine());
      } else {
        throw new NoSuchElementException("Your input file is blank!");
      }

      while (scanner.hasNextLine()){
        position = scanner.nextLine();
        instructions = scanner.nextLine();
        if(checkInstructions(instructions) && checkPosition(position)) {
          rover = makeRover(position, instructions);
          rovers.add(rover);
        }
      }
      scanner.close();
    }
    catch (FileNotFoundException error) {
      System.out.println("We couldn't find that file.");
    }

    return new Mission(rovers, plateau);
  }

  public boolean checkInstructions(String instructions) {
    return instructions.matches("^[LMR]+$");
  }

  public boolean checkPosition(String position) {
    return position.matches("^\\d* \\d* [NSEW]$");
  }

  public Rover makeRover(String position, String instructions) {
    String[] positionArr = position.split("\\s");
    int x = Integer.parseInt(positionArr[0]);
    int y = Integer.parseInt(positionArr[1]);
    String direction = positionArr[2];
    return new Rover(x, y, direction, instructions);
  }

  public Plateau makePlateau(String coordinates) {
    String[] coordArr = coordinates.split("\\s");
    try {
      int x = Integer.parseInt(coordArr[0]);
      int y = Integer.parseInt(coordArr[1]);
      return new Plateau(x, y);
    } catch(NumberFormatException error) {
      System.out.println("Plateau coordinates must be two integers.");
    }
    return new Plateau(-1, -1); // to prevent no return error
  }
}