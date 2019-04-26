package it.kata.football.championship;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TurnSorterTest {
    Turn turn1 = new Turn(Arrays.asList(
            new Match("TeamA", "TeamB"),
            new Match("TeamC", "TeamD")
    ));
    Turn turn2 = new Turn(Arrays.asList(
            new Match("TeamA", "TeamC"),
            new Match("TeamB", "TeamD")
    ));
    Turn turn3 = new Turn(Arrays.asList(
            new Match("TeamA", "TeamD"),
            new Match("TeamB", "TeamC")
    ));
    List<Turn> expected3TurnsFor4Teams = Arrays.asList(turn1,turn2,turn3);

    @Test
    void shouldGenerate3TurnFor4Teams() throws IOException {
        List<Turn> expectedRound = expected3TurnsFor4Teams;

        List<Turn> actualRound = new TurnSorter("AT1").generate();

        assertArrayEquals(expectedRound.toArray(), actualRound.toArray());
    }
}
