import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Dictionary {

    private List<String> filteredDictionary = new ArrayList<>();

    private final Path path = Paths.get("src/singular.txt");

    public void createFilteredDictionary() {
        if (filteredDictionary.isEmpty()) {
            try {
                filteredDictionary = Files.lines(path)
                        .filter(word -> word.length() >= 5 && word.length() <= 9)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> createRandomWord() {
        int randomLineIndex = new Random().nextInt(filteredDictionary.size());
        return Arrays.asList((filteredDictionary.get(randomLineIndex)).split(""));
    }
}