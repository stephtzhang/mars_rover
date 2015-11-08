import mission.*;

public class Runner {
  public static void main(String [] argv) {
    String filepath;

    if (argv.length == 0) {
      filepath = "input_files/input.txt";
    } else {
      filepath = "input_files/" + argv[0];
    }

    Parser parser = new Parser(filepath);
    Mission mission = parser.parseInput();
    String finalCoords = mission.advanceRovers();
    System.out.println(finalCoords);
  }
}