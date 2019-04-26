import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class TeamList {
    public List<String> load(File file) throws IOException {
        return Files.lines(file.toPath()).collect(Collectors.toList());
    }

    public List<String> loadFromResources(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        return load(new File(classLoader.getResource(fileName).getFile()));
    }
}
