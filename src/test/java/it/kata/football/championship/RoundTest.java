package it.kata.football.championship;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundTest {
    @Test
    void shouldGenerateAStringFor3TurnFor4Teams() throws IOException {
        String expectedRoundText =
                "Turn 1:\n" +
                    "\tTeamA - TeamB\n" +
                    "\tTeamC - TeamD\n" +
                "Turn 2:\n" +
                    "\tTeamA - TeamC\n" +
                    "\tTeamB - TeamD\n" +
                "Turn 3:\n" +
                    "\tTeamA - TeamD\n" +
                    "\tTeamB - TeamC\n";

        Round round = new Round(new TurnSorter("AT1").generate());
        String actualRoundText = round.toString();

        assertEquals(expectedRoundText, actualRoundText);
    }

    @Test
    void shouldHaveAMethodPrint() {
        final Method[] roundMethods = Round.class.getMethods();
        final boolean hasMethodPrint = Arrays.stream(roundMethods)
                .anyMatch(method -> "print".equals(method.getName()));

        assertTrue(hasMethodPrint);
    }
}
