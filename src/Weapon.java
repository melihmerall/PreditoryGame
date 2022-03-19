public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int coin;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon(String name, int id, int damage, int coin) {
        this.name=name;
        this.id = id;
        this.damage = damage;
        this.coin = coin;
    }
    public static Weapon[] weapons(){
        Weapon[] weaponsList = new Weapon[3];
        weaponsList[0] = new Weapon(" Gun - ",1,2,5);
        weaponsList[1] = new Weapon(" Sword - ",2,3,35);
        weaponsList[2] = new Weapon(" ShotGun - ",3,7,45);
        return weaponsList;
    }
    public static Weapon getWeaponObjByID(int id) {
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return coin;
    }

    public void setHealth(int health) {
        this.coin = health;
    }
}
