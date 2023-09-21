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

    public void move(int steps) {
        System.out.println(name + " move " + steps + " steps.");
        // where am I?
        // how to move myself
        position += steps;
    }
}
