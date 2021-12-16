public class ArrayLayers {
    Layer[] layers;
    Cell[] cells;
    int layersLength;
    int cellsLength;
    int rows;
    int cols;

    public ArrayLayers(int length, int rows, int cols) {
        this.cells = new Cell[length * rows * cols];
        this.layersLength = length;
        this.cellsLength = rows * cols;
        this.rows = rows;
        this.cols = cols;
        this.layers = new Layer[length];
        for (int i=0; i < length; i++){
            this.layers[i] = new Layer(this.cellsLength);
        }
        for (int i=0; i < length; i++){
            if (i > 0){
                this.layers[i].prev = this.layers[i-1];
            }
            if (i < length - 1){
                this.layers[i].next = this.layers[i+1];
            }
        }
    }

    public Layer getAnyaLayer(){
        for (Layer l: layers){
            if(l.hasAnya()){
                return l;
            }
        }
        return null;
    }

    public String getDirection(Layer first){
        String direction = "here";
        Layer test = first;
        if(!test.hasHotSpring()){
            System.err.println(test.next.hasHotSpring());
            while(test.next != null){
                if(test.next.hasHotSpring()){
                    return "up";
                }
                test = test.next;
            }
            test = first;
            while(test.prev != null){
                if(test.prev.hasHotSpring()){
                    return "down";
                }
                test = test.prev;
            }
        }
        return direction;
    }

    public Cell findCell(Coords aCoord){
        for (Cell aCell: this.cells){
            if (aCell.coords.equals(aCoord)){
                return aCell;
            }
        }
        return null;
    }

    public Cell[] getNextCells(Cell cell){
        Cell[] cells = new Cell[6];
        Coords[] nextCoords = cell.nextCells(this.rows, this.cols, this.layersLength);
        int i = 0;
        for (Coords c : nextCoords){
            if (c.isValid){
                Cell nextCell = this.findCell(c);
                if (nextCell != null && nextCell.isReachable){
                    cells[i] = nextCell;
                }
            }
            i++;
        }
        cell.isReachable = false;
        return cells;
    }
}
