package model;

import model.blocks.Land;

public class Player {
    private int cash = 1000;
    private int position = 0;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s [%d] {cash: %d}", name, position, cash);
    }

    public void move(GameMap gameMap, int steps) {
        position += steps;
        position = position % gameMap.length();
        gameMap.doSomething(this);
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public boolean buy(Land land) {
        if (land.price > this.cash) {
            return false;
        } else {
            this.cash -= land.price;
            return true;
        }
    }

    public void payTo(Player owner, int price) {
        this.cash -= price;
        owner.cash += price;
    }

    public boolean isBankrupt() {
        return cash < 0;
    }
}
