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

        Cell startPoint = null;
        Layers layers = new Layers(R, C, L);
        int nLayer = -1;
        int nLine = 0;
        for (int i = 0; i < ln; i++) {
            String line = in.nextLine();
            if (Objects.equals(line, "")) {
                nLayer++;
                nLine=0;
            } else {
                for (int j = 0; j < C; j++) {
                    layers.dungeon[nLayer][nLine][j].setC(line.charAt(j));
                    if(line.charAt(j) == 'A'){
                        startPoint = layers.dungeon[nLayer][nLine][j];
                    }
                }
                nLine++;
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        if(startPoint != null){
            Integer result = Router.process(startPoint, layers);
            if (result!=null){
                return ""+result;
            }
        }
        return "NO PATH";
    }
}
