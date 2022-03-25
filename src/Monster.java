public class Monster {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int dropCoin;
    private int defHealth;

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getDropCoin() {
        return dropCoin;
    }

    public void setDropCoin(int dropCoin) {
        this.dropCoin = dropCoin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monster(int id, String name, int damage, int health,int dropCoin,int defHealth) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.dropCoin = dropCoin;
        this.defHealth=defHealth;

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
        return health;
    }

    public void setHealth(int health) {
        if(health<0){
            health=0;

        }
        this.health = health;
    }
}
