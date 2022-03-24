import Heroes.Archer;
import Heroes.GameHeroes;
import Heroes.Samurai;
import Heroes.Wizard;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orginHealth;
    private int coin;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public int getOrginHealth() {
        return orginHealth;
    }

    public void setOrginHealth(int orginHealth) {
        this.orginHealth = orginHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player (String name){
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar(){
        GameHeroes[] heroList = {new Samurai(),new Archer(),new Wizard()};
        System.out.println("Chars:");
        System.out.println("----------------------------");
        for(GameHeroes gameHeroes : heroList){

            System.out.println("ID: "+ gameHeroes.getId()+
                    "\t Heroes: "+gameHeroes.getName()+
                    "\t Damage: "+gameHeroes.getDamage()+
                    "\t Health: "+gameHeroes.getHealth()+
                    "\t Coin: "+gameHeroes.getMoney());
        }
        System.out.println("----------------------------");
        System.out.println("Choose Your Hero ID:  ");
        int selectChar= input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Wizard());
                break;
            default:
                initPlayer(new Samurai());
        }
//        System.out.println("Chosen Hero is ---> "+this.getCharName()+
//                ",\t Damage: "+this.getDamage()+
//                ",\t Health: "+this.getHealth()+
//                ",\t Coin: "+this.getCoin());


    }
    public void initPlayer(GameHeroes gameHeroes){
        this.setDamage(gameHeroes.getDamage());
        this.setHealth(gameHeroes.getHealth());
        this.setOrginHealth(gameHeroes.getHealth());
        this.setCoin(gameHeroes.getMoney());
        this.setCharName(gameHeroes.getName());
    }
    public void printInfo(){
        System.out.println("Your Weapon: "+  this.getInventory().getWeapon().getName()+
                ",\t Your Shield: "+this.getInventory().getShield().getName()+
                ",\t Shield Defence: "+this.getInventory().getShield().getBlockRate()+
                ",\t Your Damage: "+this.getDamage()+
                ",\t Your Health: "+this.getHealth()+
                ",\t Your Coin: "+this.getCoin());
    }
    public int getTotalDamage(){
       return damage + this.getInventory().getWeapon().getDamage();
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
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
