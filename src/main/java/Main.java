import model.GameMap;
import model.Monopoly;
import model.Player;

public class Main {
    public static void main(String[] args) {
        Monopoly monopoly = new Monopoly(new Player[]{
                new Player("阿土伯"), new Player("孫小美")
        }, new GameMap());

        while (!monopoly.isEnded()) {
            // TODO 判斷剩下唯一一人沒有破產才結束
            monopoly.waitForPlayerAction();
        }

    }
}
