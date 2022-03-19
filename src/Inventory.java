public class Inventory {
    private Weapon weapon;
    private Shield shield;
    private boolean water;
    private boolean food;

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Inventory() {
        this.weapon = new Weapon(" Hand ",-1,0,0);
        this.shield = new Shield(" Hand ",-1,0,0);

    }
}
