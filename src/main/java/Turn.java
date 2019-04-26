import java.util.List;
import java.util.Objects;

public class Turn {

    private final List<Match> matches;

    public Turn(List<Match> matches) {
        this.matches = matches;
    }

    public boolean containsTeams(Match match) {
        return matches.stream().anyMatch(m -> m.isWithTheSameTeams(match));
    }

    public boolean containsMatch(Match match) {
        return matches.contains(match);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Turn turn = (Turn) o;
        return Objects.equals(matches, turn.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }
}
