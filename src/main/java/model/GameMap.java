package model;

import model.blocks.Block;
import model.blocks.Land;
import model.blocks.StartPoint;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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

    public void show(Player[] players) {
        System.out.println("小富翁");
        System.out.println("------------------------------------------");


        for (int i = 0; i < blocks.length; i++) {
            String blockDisplay = wrapSpace(blocks[i].toString());
            String playList = makePlayList(players, i);

            String out = String.format("%s%s", blockDisplay, playList);
            System.out.println(out);


        }

        System.out.println("------------------------------------------");
        System.out.println();


    }

    private String wrapSpace(String blockDisplay) {
        StringBuilder sb = new StringBuilder(blockDisplay);
        int width = 12;
        if (blockDisplay.length() < width) {
            int diff = width - blockDisplay.length();
            for (int i = 0; i < diff; i++) {
                sb.append("　");
            }
        }
        return sb.toString();
    }

    private String makePlayList(Player[] players, int position) {
        return Arrays.stream(players).filter(p -> p.position() == position).map(Player::name).collect(Collectors.joining(", "));
    }
}
