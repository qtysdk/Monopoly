public class Player {

    private int position = 0;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s [%d]", name, position);
    }

    public void move(GameMap gameMap, int steps) {

        // where am I?
        // how to move myself
        position += steps;
        position = position % gameMap.length();
        gameMap.doSomething(this);


        System.out.println(name + " move " + steps + " steps.");
    }

    public String name() {
        return this.name;
    }

    public int position() {
        return this.position;
    }
}
