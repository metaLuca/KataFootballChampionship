import java.util.Objects;

public class Match {
    private String home;
    private String visitor;

    public Match(String home, String visitor) {
        this.home = home;
        this.visitor = visitor;
    }

    @Override
    public String toString() {
        return home + " - " + visitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Match match = (Match) o;
        return Objects.equals(home, match.home) &&
                Objects.equals(visitor, match.visitor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(home, visitor);
    }
}
