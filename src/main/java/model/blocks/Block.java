package model.blocks;

import model.Player;

public abstract class Block {
    public abstract void doSomething(Player player);

    public abstract String toString();
}
