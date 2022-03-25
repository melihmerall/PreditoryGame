package Monsters;
import java.util.Random;

public class Snake extends Monster{
    private Weapon weapon;
    private Shield shield;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public Snake() {
        super(4, "Snake" ,3 , 12, 0,12);

    }

    private class Weapon {
    }

    private class Shield {
    }
}
