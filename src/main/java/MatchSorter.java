import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatchSorter {
    private final List<String> teams;
    private List<Match> permutations = new ArrayList<>();

    public MatchSorter(String fileName) throws IOException {
        teams = new TeamList().loadFromResources(fileName);
    }

    public List<Match> generateAllMatches() {
        for (String teamA:teams) {
            List<Match> newPermutations = teams.stream()
                    .filter(teamB -> !(teamA.equals(teamB) || isMatchDuplicate(teamA, teamB)))
                    .map(teamB -> new Match(teamA, teamB))
                    .collect(Collectors.toList());
            permutations.addAll(newPermutations);
        }
        return permutations;
    }

    private boolean isMatchDuplicate(String teamA, String teamB) {
        return permutations.stream()
                .anyMatch(match -> match.isBetween(teamA, teamB));
    }
}
