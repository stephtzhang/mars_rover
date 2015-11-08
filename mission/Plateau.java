package mission;
import java.util.*;

public class Plateau {
  private int xBoundary;
  private int yBoundary;

  public Plateau(int xBoundary, int yBoundary) {
    this.xBoundary = xBoundary;
    this.yBoundary = yBoundary;
  }

  public boolean inBounds(int x, int y) {
    if(x > xBoundary || y > yBoundary || x < 0 || y < 0) {
      return false;
    }
    return true;
  }

  public int getX() {
    return xBoundary;
  }

  public int getY() {
    return yBoundary;
  }

}