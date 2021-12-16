import java.util.ArrayList;

public class Router {
    public static Integer process(Cell startPoint, ArrayLayers dungeon) {
        int i = 0;
        if (!startPoint.isHotSpring) {
            ArrayList<Cell> currentCells = new ArrayList<>();
            currentCells.add(startPoint);
            while(!currentCells.isEmpty()){
                ArrayList<Cell> nextTest = new ArrayList<>();
                for (Cell test: currentCells){
                    if (test.isHotSpring){
                        return i;
                    }
                    for (Cell c: dungeon.getNextCells(test)){
                        if (c != null){
                            nextTest.add(c);
                        }
                    }
                }
                currentCells = nextTest;
                i++;
            }
            return null;
        }
        return i;
    }
}