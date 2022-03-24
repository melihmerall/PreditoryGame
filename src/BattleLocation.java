import jdk.swing.interop.SwingInterOpUtils;

import java.util.Locale;
import java.util.Random;

public class BattleLocation extends Location{
    private Monster monster;
    private String gift;
    private int maxMonster;


    public BattleLocation(Player player, String name,Monster monster,String gift,int maxMonster) {
        super(player, name);
        this.monster=monster;
        this.gift=gift;
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

    @Override
    boolean onLocation() {

        if (this.getName() =="Cave" && this.getPlayer().getInventory().isFood() == true ) {
            System.out.println("You Take a Gift !  Don't Enter !! " + this.getName());
        }else if(this.getName() == "River" && this.getPlayer().getInventory().isPunc() == true){
            System.out.println("You Take a Gift !  Don't Enter !! " + this.getName());
        }else if(this.getName() == "Forest" && this.getPlayer().getInventory().isWater() == true){
            System.out.println("You Take a Gift !  Don't Enter !! " + this.getName());
        }
        else {
            int monsterNumber = this.monsterNumber();
            System.out.println("You are come to: " + this.getName());
            System.out.println("There are  " + monsterNumber + " piece " + this.getMonster().getName());
            System.out.print("(W)War or (T)Turn Home: ");
            String selectCase = input.nextLine();
            selectCase = selectCase.toUpperCase();
            if (selectCase.equals("W") && combat(monsterNumber)) {
                if (combat(monsterNumber)) {
                    System.out.println(this.getName() + "You win !!");
                    return true;
                }
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("You die.");
                return false;
            }
            return true;
        }
        return true;
    }
    public boolean combat(int monsterNumber){
        for(int i=0;i<monsterNumber;i++){
            int randomWarChoose = (int)(Math.random()*2);
            this.getMonster().setHealth(this.getMonster().getDefHealth()); // Canavarın canını her defasında default hale getirdik.
            playerStats();
            monsterStats();
            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getShield().getBlockRate();
            if(randomWarChoose == 0){
                System.out.println("---------------------------------------------");
                System.out.println("First attack come to MONSTER be carefull !!");
                System.out.println("---------------------------------------------");
                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                afterDamage();
            }
            while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("<A>Attack or <R>Run: ");
                String selectCombat= input.nextLine();
                if(selectCombat.equals("A")){
                    System.out.println("Your done a Attack!!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterDamage();
                    if(this.getMonster().getHealth()>0){
                        System.out.println();
                        System.out.println("Monster Attack You!");
                        if(monsterDamage<0){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterDamage();
                    }
                }else{
                    return false;
                }

            }
            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You Won !");
                System.out.println("You earn Money!");
                System.out.println("Drop coin: "+this.getMonster().getDropCoin());

                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getDropCoin());
                System.out.println("Current Coin: " + this.getPlayer().getCoin());


            }else{
                return false;
            }
            System.out.println("You complate this map and earn: "+ this.getGift());
            if(this.getGift() == "Food"){
                this.getPlayer().getInventory().setFood(true);
            }if(this.getGift()== "Punc"){
                this.getPlayer().getInventory().setPunc(true);
            }if(this.getGift()=="Water"){
                this.getPlayer().getInventory().setWater(true);
            }
        }
        return false;
    }

    public void afterDamage() {
        System.out.println("Your Health: "+this.getPlayer().getHealth());
        System.out.println("Monster Health: "+ this.getMonster().getHealth());

    }

    public void monsterStats() {
        System.out.println(this.getMonster().getName() + "Stats: ");
        System.out.println("-----------------------------");
        System.out.println("Health: "+ this.getMonster().getHealth());
        System.out.println("Damage: "+ this.getMonster().getDamage());
        System.out.println("Drop Coin: "+ this.getMonster().getDropCoin());
    }

    public void playerStats(){
        System.out.println("-----------------------------");
        System.out.println("Player Stats");
        System.out.println("-----------------------------");
        System.out.println("Health: "+ this.getPlayer().getHealth());
        System.out.println("Damage: "+ this.getPlayer().getTotalDamage());
        System.out.println("Coin: "+ this.getPlayer().getCoin());
        System.out.println("Weapon" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Shield: "+ this.getPlayer().getInventory().getShield().getName());


    }
    public int monsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster())+1;
    }
}
