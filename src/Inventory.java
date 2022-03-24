public class Inventory {
    private Weapon weapon;
    private Shield shield;
    private boolean food;
    private boolean water;
    private boolean punc;

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isPunc() {
        return punc;
    }

    public void setPunc(boolean punc) {
        this.punc = punc;
    }

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
