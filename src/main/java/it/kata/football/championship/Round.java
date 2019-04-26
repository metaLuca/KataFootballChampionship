package it.kata.football.championship;

import java.util.List;

public class Round {
    private final List<Turn> turns;

    public Round(List<Turn> turns) {
        this.turns = turns;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < turns.size(); i++) {
            text
                    .append("Turn ").append(i+1).append(":\n")
                    .append(turns.get(i).toString());
        }
        return text.toString();
    }

    public void print() {
        System.out.println(toString());
    }
}
