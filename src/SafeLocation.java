public class SafeLocation extends NormalLocation{
    public SafeLocation(Player player) {
        super(player,"Safe House");
    }
    @Override
    boolean onLocation() {
        System.out.println("You come to Safe Zone. Your health Fully.!!!");
        this.getPlayer().setHealth(this.getPlayer().getOrginHealth());
        return true;
    }
}
