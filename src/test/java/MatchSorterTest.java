import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchSorterTest {

    @Test
    void shouldGenerateMatchesFor2Teams() throws IOException {
        List<Match> expectedMatches = new ArrayList<>();
        expectedMatches.add(new Match("A", "B"));

        List<Match> actualMatches = new MatchSorter("teams.txt").generate();

        assertArrayEquals(expectedMatches.toArray(), actualMatches.toArray());
    }
}
