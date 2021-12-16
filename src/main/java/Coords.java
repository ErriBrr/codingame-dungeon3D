public class Coords {
    int x;
    int y;
    int z;
    boolean isValid = true;
    public Coords(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Coords(int x, int y, int z, int rows, int cols, int layers){
        this.x = x;
        this.y = y;
        this.z = z;
        //this.isValid = (0 <= x && x < rows && 0 <= y && y < cols && 0 <= z && z < layers);
    }
    public boolean equals(Coords c){
        return this.x == c.x && this.y == c.y && this.z == c.z;
    }
}
