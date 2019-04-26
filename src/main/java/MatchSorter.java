import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatchSorter {
    private List<String> teams;

    public MatchSorter(String fileName) throws IOException {
        teams = new TeamList().loadFromResources(fileName);
    }

    public List<Match> generate() {
        return IntStream.range(1, teams.size())
                .mapToObj(i -> new Match(teams.get(i - 1), teams.get(i)))
                .collect(Collectors.toList());
    }
}
