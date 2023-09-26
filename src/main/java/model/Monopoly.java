package model;

import java.util.*;

public class Monopoly {

    private int turns = 0;

    private Player[] players;
    private GameMap gameMap;

    private Queue<Event> history = new LinkedList<>();

    public Monopoly(Player[] players, GameMap gameMap) {
        // TODO make sure have 2 or more players
        this.players = players;
        this.gameMap = gameMap;


    }

    public boolean isEnded() {
        return Arrays.stream(players).filter(Player::isBankrupt).count() == 1;
    }

    public void waitForPlayerAction() {
        // player take the turn and do something -> roll dice
        Player player = currentPlayer();

        System.out.println("這是 " + player + " 的回合，請按 enter 擲骰子");
        new Scanner(System.in).nextLine();

        int steps = rollDice();
        history.addAll(player.move(gameMap, steps));

        System.out.println();

    }


    private int rollDice() {
        // dice between 1 and 3
        return 1 + (int) ((Math.random() * 100) % 3);
    }

    private Player currentPlayer() {
        return players[turns++ % players.length];
    }

    public void display() {
        gameMap.show(players);

        int limit = 5;
        while (history.size() > limit) {
            history.poll();
        }
        if (!history.isEmpty()) {
            System.out.printf("最近發生的 %d 件事：\n", limit);
            history.forEach(System.out::println);
            System.out.println();
        }

        System.out.println();
    }
}
