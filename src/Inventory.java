public class Inventory {
    private Weapon weapon;
    private Shield shield;
    private boolean food;
    private String foodDrop;
    private boolean water;
    private String waterDrop;
    private boolean punc;
    private String puncDrop;

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

    public String getFoodDrop() {
        if(foodDrop == null)
        {
            foodDrop = "Empty Slot";
        }
        return foodDrop;
    }

    public void setFoodDrop(String foodDrop) {
        this.foodDrop = foodDrop;
    }

    public String getWaterDrop() {
        if(waterDrop == null)
        {
            waterDrop = "Empty Slot";
        }
        return waterDrop;
    }

    public void setWaterDrop(String waterDrop) {
        this.waterDrop = waterDrop;
    }

    public String getPuncDrop() {
        if(puncDrop == null)
        {
            puncDrop = "Empty Slot";
        }
        return puncDrop;
    }

    public void setPuncDrop(String puncDrop) {
        this.puncDrop = puncDrop;
    }

    public Inventory() {
        this.weapon = new Weapon(" Hand ",-1,0,0);
        this.shield = new Shield(" Hand ",-1,0,0);


    }
}
