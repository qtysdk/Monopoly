package model.blocks;

import model.Event;
import model.Player;

import java.util.List;

public abstract class Block {
    public abstract List<Event> doSomething(Player player);

    public abstract String toString();
}
