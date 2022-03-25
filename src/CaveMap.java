import Monsters.Golem;

public class CaveMap extends BattleLocation {
    public CaveMap(Player player) {
        super(player, "Cave", new Golem(), "Food",4);
    }
}
