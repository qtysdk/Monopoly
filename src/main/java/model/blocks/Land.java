package model.blocks;

import model.Event;
import model.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Land extends Block {

    final public int price = 87;
    private Player owner;


    @Override
    public List<Event> doSomething(Player player) {
        if (owner == null && player.buy(this)) {
            this.owner = player;
            return Event.fromString(String.format("%s 買下了空地", player.name()));
        } else if (owner != null && owner != player) {
            player.payTo(owner, price);
            return Event.fromString(String.format("%s 付過了路費 %d 元給 %s", player.name(), price, owner.name()));
        }
        return Collections.emptyList();
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
