package model.blocks;

import model.Event;
import model.Player;

import java.util.Collections;
import java.util.List;

public class StartPoint extends Block {
    @Override
    public List<Event> doSomething(Player player) {
        // do nothing for now
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "起點";
    }
}
