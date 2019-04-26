import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TurnSorter {
    private final MatchSorter matchSorter;
    private final List<Match> turnsMatches;
    private List<Turn> round = new ArrayList<>();

    public TurnSorter(String fileName) throws IOException {
        matchSorter = new MatchSorter(fileName);
        turnsMatches = matchSorter.generateAllTurnsMatches();
    }

    public List<Turn> generate() {
        if(round.size() == 0) {
            for (Match match : turnsMatches) {
                if(round.stream().noneMatch(turn -> turn.containsMatch(match))) {
                    List<Match> matchesForTurn = new ArrayList<>();
                    matchesForTurn.add(match);
                    matchesForTurn.addAll(
                            turnsMatches.stream()
                                    .filter(m -> !m.containsAtLeatOneTeam(match))
                                    .collect(Collectors.toList())
                    );

                    round.add(new Turn(matchesForTurn));
                }
            }
        }
        return round;
    }
}
