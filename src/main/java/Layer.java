public class Layer {
    Cell[] cells;
    int width;
    int height;
    Layer prev;
    Layer next;

    public Layer(int cellsLength){
        this.cells = new Cell[cellsLength];
    }

    public Cell getAnya(){
        for (Cell c: cells){
            if (c.isAnya){
                return c;
            }
        }
        return null;
    }
    public Cell getHotSpring(){
        for (Cell c: cells){
            if (c.isHotSpring){
                return c;
            }
        }
        return null;
    }
    public boolean hasAnya(){
        return this.getAnya() != null;
    }
    public boolean hasHotSpring(){
        return this.getHotSpring() != null;
    }
}

