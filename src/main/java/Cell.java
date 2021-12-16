import java.util.ArrayList;

public class Cell {
    Coords coords;
    char c;
    boolean isAnya;
    boolean isHotSpring;
    boolean isReachable;
    ArrayList<Cell> nextCells = new ArrayList<>();

    public void setC(char c) {
        this.c = c;
        this.isAnya = c == 'A';
        this.isHotSpring = c == 'S';
        this.isReachable = (c != '#');
    }

    public Cell(int x, int y, int z){
        this.coords = new Coords(x,y,z);
    }
}
