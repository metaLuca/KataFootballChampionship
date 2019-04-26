import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchSorterTest {

    @Test
    void shouldGenerateMatchFor2Teams() throws IOException {
        List<Match> expectedMatches = new ArrayList<>();
        expectedMatches.add(new Match("A", "B"));

        List<Match> actualMatches = new MatchSorter("2teams").generateAllMatches();

        assertArrayEquals(expectedMatches.toArray(), actualMatches.toArray());
    }

    @Test
    void shouldGenerateMatchesFor4Teams() throws IOException {
        List<Match> expectedMatches = Arrays.asList(
                new Match("TeamA", "TeamB"),
                new Match("TeamA", "TeamC"),
                new Match("TeamA", "TeamD"),
                new Match("TeamB", "TeamC"),
                new Match("TeamB", "TeamD"),
                new Match("TeamC", "TeamD")
        );

        List<Match> actualMatches = new MatchSorter("AT1").generateAllMatches();

        assertArrayEquals(expectedMatches.toArray(), actualMatches.toArray());
    }
}
