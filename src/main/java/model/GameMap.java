package model;

import model.blocks.Block;
import model.blocks.Land;
import model.blocks.StartPoint;

public class GameMap {

    private Block[] blocks = new Block[]{new StartPoint(), new Land(), new Land(), new Land(), new Land()};

    public int length() {
        return blocks.length;
    }

    public void doSomething(Player player) {
        Block block = getBlockType(player);
        block.doSomething(player);
    }

    private Block getBlockType(Player player) {
        return this.blocks[player.position()];
    }

    public void show() {
        System.out.println("地圖：");
        for (Block block : this.blocks) {
            System.out.printf("%s ", block);
        }
        System.out.println();
        System.out.println();
    }
}
