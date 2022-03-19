public class NormalLocation  extends Location{

    public NormalLocation(Player player, String name){
        super(player,name);
    }

    @Override
    boolean onLocation() {
        System.out.println("You come to Safe Zone. Your health Fully.!!!");
        return true;
    }
}
