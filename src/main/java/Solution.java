import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static String proceed(String filename) throws IOException {
        Scanner in = new Scanner(FileReader.readFile(filename));
        int L = in.nextInt();
        int R = in.nextInt();
        int C = in.nextInt();
        int ln = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        ArrayLayers dungeon = new ArrayLayers(L, R, C);
        int nLayer = -1;
        int nLine = 0;
        int nCell = 0;
        int nCellTotal = 0;
        for (int i = 0; i < ln; i++) {
            String line = in.nextLine();
            if (Objects.equals(line, "")) {
                nLayer++;
                nLine = 0;
                nCell = 0;
            } else {
                for (int j = 0; j < C; j++) {
                    Cell aCell = new Cell(j, nLine, nLayer, line.charAt(j));
                    dungeon.layers[nLayer].cells[nCell] = aCell;
                    dungeon.cells[nCellTotal] = aCell;
                    nCell++;
                    nCellTotal++;
                }
            }
            nLine++;
        }


        Layer firstStage = dungeon.getAnyaLayer();
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        Integer result = Router.process(firstStage.getAnya(), dungeon);
        if (result == null) {
            return "NO PATH";
        } else {
            return "" + result;
        }
    }
}
