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
        int monsterNumber = this.monsterNumber();
        System.out.println("You are come to: "+this.getName());
        System.out.println("There are  " + monsterNumber + " piece " + this.getMonster().getName());
        System.out.print("(W)War or (T)Turn Home: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            // War cases
        }
        return true;
    }
    public int monsterNumber(){
        Random r = new Random();
        // 0, 1 + 1 =! 1,2
        return r.nextInt(this.getMaxMonster())+1;
    }
}
