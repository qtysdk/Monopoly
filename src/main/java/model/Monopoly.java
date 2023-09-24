package model;

import java.util.Scanner;

public class Monopoly {

    private int turns = 0;

    private Player[] players;
    private GameMap gameMap;

    public Monopoly(Player[] players, GameMap gameMap) {
        // TODO make sure have 2 or more players
        this.players = players;
        this.gameMap = gameMap;


    }

    public boolean isEnded() {
        return false;
    }

    public void waitForPlayerAction() {
        gameMap.show();


        // player take the turn and do something -> roll dice
        Player player = currentPlayer();

        System.out.println("這是 " + player + " 的回合，請按 enter 擲骰子");
        new Scanner(System.in).nextLine();

        int steps = rollDice();
        player.move(gameMap, steps);
        System.out.println(player);
        System.out.println();

    }

    private int rollDice() {
        // dice between 1 and 3
        return 1 + (int) ((Math.random() * 100) % 3);
    }

    private Player currentPlayer() {
        return players[turns++ % players.length];
    }
}
