import Monsters.AlphaWolf;

public class ForestMap extends BattleLocation {

    public ForestMap(Player player) {
        super(player, "Forest",new AlphaWolf(),"Water",3);
    }
}
