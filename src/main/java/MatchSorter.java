import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.util.Pair;

public class MatchSorter {
    private List<String> teams;

    public MatchSorter(String fileName) throws IOException {
        teams = new TeamList().loadFromResources(fileName);
    }

    public List<Pair<String, String>> generate() {
        return IntStream.range(1, teams.size())
                .mapToObj(i -> (Pair<String, String>) new Pair(teams.get(i - 1), teams.get(i)))
                .collect(Collectors.toList());
    }
}
