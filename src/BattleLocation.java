import Heroes.GameHeroes;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Locale;
import java.util.Random;

public class BattleLocation extends Location {
    private Monster monster;
    private String gift;
    private int maxMonster;
    private Player player;


    public BattleLocation(Player player, String name, Monster monster, String gift, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.gift = gift;
        this.maxMonster = maxMonster;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public Location mainPage(Player player){
        Location location = new SafeLocation(player);
        return location;
    }
    @Override
    boolean onLocation() {

        if (this.getName() == "Cave" && this.getPlayer().getInventory().isFood() == true) {
            System.out.println("You Take a Gift !  Don't Enter !! " + this.getName());
        } else if (this.getName() == "River" && this.getPlayer().getInventory().isPunc() == true) {
            System.out.println("You Take a Gift !  Don't Enter !! " + this.getName());
        } else if (this.getName() == "Forest" && this.getPlayer().getInventory().isWater() == true) {
            System.out.println("You Take a Gift !  Don't Enter !! " + this.getName());
        } else {
            int monsterNumber = this.monsterNumber();
            System.out.println("You are come to: " + this.getName());
            System.out.println("There are  " + monsterNumber + " piece " + this.getMonster().getName());
            System.out.print("(W)War or (T)Turn Home: ");
            String selectCase = input.nextLine();
            selectCase = selectCase.toUpperCase();
            if (selectCase.equals("W") && combat(monsterNumber)) {
                if (combat(monsterNumber)) {
                    System.out.println(this.getName() + "You win !!");
                }else{
                    mainPage(player);
                }
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You die.");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            System.out.println(monsterNumber + "mosnter number");
            Random random = new Random();
            int randomDamageSnake = random.nextInt(4) + 3;
            int randomWarChoose = (int) (Math.random() * 2); // %50 ihtimalle ilk saldırı canavardan gelecek.
            this.getMonster().setHealth(this.getMonster().getDefHealth()); // Canavarın canını her defasında default hale getirdik.
            playerStats();
            monsterStats();
            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getShield().getBlockRate();
            if (randomWarChoose == 0) {
                System.out.println("---------------------------------------------");
                System.out.println("First attack come to MONSTER be carefull !!");
                System.out.println("---------------------------------------------");
                if (this.getMonster().getName() == "Snake") {
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - randomDamageSnake);
                } else {
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                }
                afterDamage();
            }
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<A>Attack or <R>Run: ");
                String selectCombat = input.nextLine();
                if (selectCombat.equals("A")) {
                    System.out.println("Your done a Attack!!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterDamage();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("---------------------");
                        System.out.println("Monster Attack You!");
                        System.out.println("----------------------");
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        if (this.getMonster().getName() == "Snake") {
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - randomDamageSnake);
                        } else {
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        }
                        afterDamage();
                    }
                } else if (selectCombat.equals("R")) { // if hero escape , we take back to gift from hero.
                    if (selectCombat.equals("R") && this.getName().equals("Cave")) {
                        this.getPlayer().getInventory().setFood(false);
                    }
                    if (selectCombat.equals("R") && this.getName().equals("Forest")) {
                        this.getPlayer().getInventory().setWater(false);
                    }
                    if (selectCombat.equals("R") && this.getName().equals("River")) {
                        this.getPlayer().getInventory().setPunc(false);
                    }
                    return false;
                }
            }
            if (this.getMonster().getName() == "Snake" && this.getMonster().getHealth() < this.getPlayer().getHealth() && i == monsterNumber) {// If you kill all snake, You can earn item. This function says that, What is your chance ?
                int stabilRandomChance = randomDropChance(); // Chance of earn somethings,|
                int stabilWeaponChance = randomWeaponChance(); // Chance of earn weapons |  /* We have grouped the item to be won. We generated special-
                int stabilShieldChance = randomShieldChance(); // Chance of earn Shield |      random numbers according to the groups. We used this number on the conditions below.
                int stabilCoinChance = randomCoinChance(); // Chance of earn Coin       |      As a result, we added a percentage probability. *\
                System.out.println("You won !!! Maybe will you win Some Weapons, Shields or Coins... :" + stabilRandomChance);
                if (stabilRandomChance > 44) {  // Earn something chance %55
                    System.out.println("Hmm maybe you got somethings.... Look at that..");
                    if (stabilRandomChance >= 85) { // Chance of earn weapons %15 / ################
                        if (stabilWeaponChance <= 50) {// Chance of earn gun %50
                            System.out.println("You Earn a Gun !! Do you Take it? Y/N");
                            String selectCase = input.nextLine();
                            selectCase = selectCase.toUpperCase();
                            if (selectCase.equals("Y")) {
                                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));// Earned item added to player.
                                System.out.println(this.getPlayer().getInventory().getWeapon().getName());
                            } else {
                                return false;
                            }
                        }
                        if (stabilWeaponChance > 50 || stabilWeaponChance < 79) { // Chance of earn Sword %30
                            System.out.println("You Earn a Sword !! Do you Take it? Y/N");
                            String selectCase = input.nextLine();
                            if (selectCase.equals("Y")) {
                                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));// Sword added player.
                                System.out.println(this.getPlayer().getInventory().getWeapon().getName());
                            } else {
                                return false;
                            }
                        }
                        if (stabilWeaponChance >= 80) { // ShotGun kazanma ihtimali %20
                            System.out.println("You Earn a Shotgun !! Do You Take it? Y/N");
                            String selectCase = input.nextLine();
                            if (selectCase.equals("Y")) {
                                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));// ShotGun added player.
                                System.out.println(this.getPlayer().getInventory()
                                        .getWeapon().getName());
                            } else {
                                return false;
                            }
                        }
                        return false;
                    }
                    if (stabilRandomChance > 69 && stabilRandomChance < 85) { // Chance of earn Shields
                        System.out.println("You Earn a Shield But Which one ? Let's look at that... ");
                        if (stabilShieldChance <= 50) { // chance of earn basic Shield
                            System.out.println("You earn a Basic Shield !! Do you Take it ? Y/N");
                            String selectCase = input.nextLine();
                            if (selectCase.equals("Y")) {
                                this.getPlayer().getInventory().setShield(Shield.getShieldObjByID(1));
                                System.out.println(this.getPlayer().getInventory()
                                        .getShield().getName());
                            } else {
                                return false;
                            }
                        }
                        if (stabilShieldChance > 50 && stabilShieldChance < 79) {
                            System.out.println("You earn a Middle Shield !! Do you Take it ? Y/N");
                            String selectCase = input.nextLine();
                            if (selectCase.equals("Y")) {
                                this.getPlayer().getInventory().setShield(Shield.getShieldObjByID(2));
                                System.out.println(this.getPlayer().getInventory()
                                        .getShield().getName());
                            } else {
                                return false;
                            }
                        }
                        if (stabilShieldChance >= 80) {
                            System.out.println("You earn a High Shield !! Do you Take it ? Y/N");
                            String selectCase = input.nextLine();
                            if (selectCase.equals("Y")) {
                                this.getPlayer().getInventory().setShield(Shield.getShieldObjByID(3));
                                System.out.println(this.getPlayer().getInventory()
                                        .getShield().getName());
                            } else {
                                return false;
                            }
                        }
                    }
                    if (stabilRandomChance > 45 && stabilRandomChance < 70) { // Coin kazanma ihtimali.
                        System.out.println("You Earn a Coin But How much  ? Let's look at that... ");
                        if (stabilCoinChance <= 50) { // 1 coin kazanma ihtimali
                            System.out.println("You Earn 1 Coin.");
                            System.out.println("Old Coin: " + this.getPlayer().getCoin());
                            this.getPlayer().setCoin(this.getPlayer().getCoin() + 1);
                            System.out.println("New Coin: " + this.getPlayer().getCoin());
                        } else {
                            return false;
                        }
                        if (stabilCoinChance > 50 && stabilCoinChance < 79) {
                            System.out.println("You Earn 5 Coin.");
                            System.out.println("Old Coin: " + this.getPlayer().getCoin());
                            this.getPlayer().setCoin(this.getPlayer().getCoin() + 5);
                            System.out.println("New Coin: " + this.getPlayer().getCoin());
                        } else {
                            return false;
                        }
                        if (stabilCoinChance > 80) {
                            System.out.println("You Earn 10 Coin.");
                            System.out.println("Old Coin: " + this.getPlayer().getCoin());
                            this.getPlayer().setCoin(this.getPlayer().getCoin() + 10);
                            System.out.println("New Coin: " + this.getPlayer().getCoin());
                        } else {
                            return false;
                        }
                    }
                }
                if (stabilRandomChance <= 45) { //birşey kazanmama ihtimali %45
                    System.out.println("Sorry You dont earn anything. Try Again.");
                }
            }
            //else{return false;}
            if (this.getMonster().getHealth() < this.getPlayer().getHealth() && this.getMonster().getName() != "Snake") {
                System.out.println("You Won !");
                System.out.println("You earn Money!");
                System.out.println("Drop coin: " + this.getMonster().getDropCoin());

                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getDropCoin());
                System.out.println("Current Coin: " + this.getPlayer().getCoin());

            }
        }
        System.out.println("You complate this map and earn: " + this.getGift());
        if (this.getGift() == "Food") {
            this.getPlayer().getInventory().setFood(true);
            this.getPlayer().getInventory().setFoodDrop("Food");
        }
        if (this.getGift() == "Punc") {
            this.getPlayer().getInventory().setPunc(true);
            this.getPlayer().getInventory().setPuncDrop("Punc");
        }
        if (this.getGift() == "Water") {
            this.getPlayer().getInventory().setWater(true);
            this.getPlayer().getInventory().setWaterDrop("Water");
        }

        return true;
    }

    public void afterDamage() {
        System.out.println("Your Health: " + this.getPlayer().getHealth());
        System.out.println("Monster Health: " + this.getMonster().getHealth());
    }

    public void monsterStats() {
        System.out.println("-------------------------------------");
        System.out.println(this.getMonster().getName() + "Stats: ");
        System.out.println("-----------------------------");
        System.out.println("Health: " + this.getMonster().getHealth());
        System.out.println("Damage: " + this.getMonster().getDamage());
        System.out.println("Drop Coin: " + this.getMonster().getDropCoin());
    }

    public void playerStats() {
        System.out.println("-----------------------------");
        System.out.println("Player Stats");
        System.out.println("-----------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Coin: " + this.getPlayer().getCoin());
        System.out.println("Weapon" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Shield: " + this.getPlayer().getInventory().getShield().getName());

    }

    public int monsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public int randomDropChance() {
        Random random = new Random();
        int randomChance = random.nextInt(100) + 1;
        return randomChance;
    }

    public int randomWeaponChance() {
        Random random = new Random();
        int randomChance = random.nextInt(100) + 1;
        return randomChance;
    }

    public int randomShieldChance() {
        Random random = new Random();
        int randomChance = random.nextInt(100) + 1;
        return randomChance;
    }

    public int randomCoinChance() {
        Random random = new Random();
        int randomChance = random.nextInt(100) + 1;
        return randomChance;
    }
}
