import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchSorterTest {

    @Test
    void shouldGenerateMatchesFor2Teams() throws IOException {
        List<Pair<String,String>> expectedMatches = new ArrayList<>();
        expectedMatches.add(new Pair<>("A", "B"));

        List<Pair<String,String>> actualMatches = new MatchSorter("teams.txt").generate();

        assertArrayEquals(expectedMatches.toArray(), actualMatches.toArray());
    }
}
