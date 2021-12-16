import java.util.ArrayList;

public class Router {
    public static Integer process(Cell startPoint, Layers dungeon) {
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
                        if (c.isReachable){
                            nextTest.add(c);
                            c.isReachable = false;
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