import java.io.IOException;
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
        for (int i = 0; i < ln; i++) {
            String line = in.nextLine();
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        return "answer";
    }
}
