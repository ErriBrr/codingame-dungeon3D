import java.util.ArrayList;

public class Layers {
    Cell[][][] dungeon;
    Cell[] cells;
    int rows;
    int cols;
    int layers;

    public Layers(int rows, int cols, int layers){
        this.dungeon = new Cell[layers][rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.layers = layers;
        int i=0;
        for (int z=0; z < layers; z++){
            for (int y=0; y < rows; y++){
                for (int x=0; x < cols; x++){
                    Cell aCell = new Cell(x,y,z);
                    this.dungeon[z][y][x] = aCell;
                    // this.cells[i] = aCell;
                }
            }
        }
    }

    public ArrayList<Cell> getNextCells(Cell ref){
        Coords[] someCoords = {
                new Coords(ref.coords.x, ref.coords.y + 1, ref.coords.z, this.rows, this.cols, this.layers),
                new Coords(ref.coords.x, ref.coords.y - 1, ref.coords.z, this.rows, this.cols, this.layers),
                new Coords(ref.coords.x + 1, ref.coords.y, ref.coords.z, this.rows, this.cols, this.layers),
                new Coords(ref.coords.x - 1, ref.coords.y, ref.coords.z, this.rows, this.cols, this.layers),
                new Coords(ref.coords.x, ref.coords.y, ref.coords.z + 1, this.rows, this.cols, this.layers),
                new Coords(ref.coords.x, ref.coords.y, ref.coords.z - 1, this.rows, this.cols, this.layers)
        };
        ArrayList<Cell> cells = new ArrayList<>();
        for (Coords c: someCoords){
            if (c.isValid){
                cells.add(this.dungeon[c.z][c.y][c.x]);
            }
        }
        return cells;
    }
}
