import java.util.ArrayList;

public class Cell {
    Coords coords;
    char c;
    boolean isAnya;
    boolean isHotSpring;
    boolean isReachable;
    ArrayList<Cell> nextCells = new ArrayList<>();

    public Cell(int x, int y, int z, char c){
        this.coords = new Coords(x,y,z);
        this.c = c;
        this.isAnya = c == 'A';
        this.isHotSpring = c == 'S';
        this.isReachable = (c != '#');
    }

    public Coords[] nextCells(int rows, int cols, int layers){
        return new Coords[]{
                new Coords(this.coords.x, this.coords.y + 1, this.coords.z, rows, cols, layers),
                new Coords(this.coords.x, this.coords.y - 1, this.coords.z, rows, cols, layers),
                new Coords(this.coords.x + 1, this.coords.y, this.coords.z, rows, cols, layers),
                new Coords(this.coords.x - 1, this.coords.y, this.coords.z, rows, cols, layers),
                new Coords(this.coords.x, this.coords.y, this.coords.z + 1, rows, cols, layers),
                new Coords(this.coords.x, this.coords.y, this.coords.z - 1, rows, cols, layers)
        };
    }
}
