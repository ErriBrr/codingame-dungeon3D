import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public interface FileReader {
    static String readFile(String filename) throws IOException {
        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + filename);
        }
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        String line;
        StringBuilder testStringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            testStringBuilder.append(line).append('\n');
        }
        return testStringBuilder.toString();
    }
}
