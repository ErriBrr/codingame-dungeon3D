import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filename = args[0];

        try {
            System.out.println(Solution.proceed(filename));
        } catch (IOException e){
            System.err.println("ERROR : " + filename + "\n" + e.getMessage());
        }
    }
}
