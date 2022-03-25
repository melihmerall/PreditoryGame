import Monsters.Snake;

public class MineMap extends BattleLocation {

    public MineMap(Player player) {
        super(player, "Mine", new Snake(),"", 5);
    }
}
