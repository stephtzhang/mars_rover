package mission;
import java.util.*;

public class Rover {
  private int x;
  private int y;
  private String direction;
  private String instructions;

  public Rover(int x, int y, String direction, String instructions) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.instructions = instructions;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setX(int val) {
    x = val;
  }

  public void setY(int val) {
    y = val;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public String getDirection() {
    return direction;
  }

  public void advance(String instruction) {
    switch (instruction) {
      case "L": this.turnLeft();
                break;
      case "R": this.turnRight();
                break;
      case "M": this.moveForward();
                break;
    }
  }

  public void turnLeft() {
    switch (direction) {
      case "N": direction = "W";
                break;
      case "E": direction = "N";
                break;
      case "S": direction = "E";
                break;
      case "W": direction = "S";
                break;
    }
  }

  public void turnRight() {
    switch (direction) {
      case "N": direction = "E";
                break;
      case "E": direction = "S";
                break;
      case "S": direction = "W";
                break;
      case "W": direction = "N";
                break;
    }
  }

  public void moveForward() {
    switch (direction) {
      case "N": y += 1;
                break;
      case "E": x += 1;
                break;
      case "S": y -= 1;
                break;
      case "W": x -= 1;
                break;
    }
  }

  public String toString() {
    return x + " " + y + " " + direction;
  }
}