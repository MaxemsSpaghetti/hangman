import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class Word {

    public String getWord() {
        Path path = Paths.get("src/singular.txt");
        try (Stream<String> linesStream = Files.lines(path)) {
            long totalLines = linesStream.count();
            int randomLineIndex = new Random().nextInt((int) totalLines);

            try (Stream<String> linesStream2 = Files.lines(path)) {
                return linesStream2.skip(randomLineIndex).findFirst().orElse(null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}