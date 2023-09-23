public class GameMap {

    private String[] blocks = new String[]{"起點", "空地", "空地", "空地", "空地"};

    public int length() {
        return blocks.length;
    }

    public void doSomething(Player player) {
        String blockType = getBlockType(player);
        if ("空地".equals(blockType)) {
            blocks[player.position()] = String.format("%s的地", player.name());
        }


        System.out.printf("%s located %d is %s%n",
                player.name(),
                player.position(),
                getBlockType(player)
        );
    }

    private String getBlockType(Player player) {
        return this.blocks[player.position()];
    }

    public void show() {
        System.out.println("地圖：");
        for (String block : this.blocks) {
            System.out.printf("%s ", block);
        }
        System.out.println();
        System.out.println();
    }
}
