package model.blocks;

import model.Player;

public class Land extends Block {

    final public int price = 87;
    private Player owner;


    @Override
    public void doSomething(Player player) {
        if (owner == null && player.buy(this)) {
            this.owner = player;
            System.out.printf("%s 買下了空地\n", player);
        } else if (owner != null && owner != player) {
            // TODO 付過路費的英文術語是什麼？
            player.payTo(owner, price);
            System.out.printf("%s 應該付過路費\n", player);

        }
    }

    @Override
    public String toString() {
        if (owner == null) {
            return "空地";
        } else {
            return String.format("%s擁有的土地", owner.name());
        }
    }
}
