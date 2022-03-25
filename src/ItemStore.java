public class ItemStore extends NormalLocation {

    public ItemStore(Player player) {
        super(player, "Store");
    }
    @Override
    public boolean onLocation(){
        System.out.println("----- Welcome to Item Store -------");
        System.out.println("1- Weapons");
        System.out.println("2- Shields");
        System.out.println("3- Exit");
        System.out.print("Seçiminiz: ");
        int selectItem = input.nextInt();
        while(selectItem < 1 || selectItem >3){
            System.out.println("Not use value. Try Again: ");
            selectItem = input.nextInt();
        }
        switch (selectItem){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printShield();
                buyShield();
                break;
            case 3:
                System.out.println("Your Welcome.");
                return true;
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("-----------Weapons------------");
        System.out.println();

        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + "-" + w.getName() + "<Para :"
                    + w.getCoin()+ " , Damage: "+w.getDamage()+">");
        }
        System.out.println("0- Exit");
    }
    public void printShield(){
        System.out.println("-----------Shields------------");

        System.out.println();

        for(Shield w : Shield.shields()){
            System.out.println(w.getId()  + w.getName() + "<Para :"
                    + w.getCoin()+ " , Block Rate: "+w.getBlockRate()+">");
        }
        System.out.println("0- Exit");
    }
    public void buyWeapon(){
        System.out.println("Select a weapon : ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Try again. Range out: ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if( selectedWeapon != null){
                if(selectedWeapon.getCoin() > this.getPlayer().getCoin()){
                    System.out.println("You havent enough money.");
                }else{
                    // Satın alma gerçekleşiyor.
                    System.out.println(selectedWeapon.getName()+"Successful Taken.");
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getCoin();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Remaining Money --> "+ this.getPlayer().getCoin());
                    System.out.println("Old weapon: "+ this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon: "+ this.getPlayer().getInventory().getWeapon().getName());
                    // Satın alma bitti.
                }
            }
        }
    }
    public void buyShield(){
        System.out.println("Select a Shield: ");
        int selectShieldID = input.nextInt();
        while(selectShieldID<1||selectShieldID>Shield.shields().length){
            System.out.println("Try Again. Range out.");

            selectShieldID= input.nextInt();
        }
        if (selectShieldID !=0){
            Shield selectedShield = Shield.getShieldObjByID(selectShieldID);
            if(selectedShield!=null){
                if(selectedShield.getCoin() > this.getPlayer().getCoin()){
                    System.out.println("You haven't enough money !");
                }else{
                    // Satın alma başlıyor.
                    System.out.println(selectedShield.getName()+"Successful Taken.");
                    int balance = this.getPlayer().getCoin() - selectedShield.getCoin();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Remainin Money --> "+ this.getPlayer().getCoin());
                    System.out.println("Old Weapon: "+ this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setShield(selectedShield);
                    System.out.println("New weapon: "+ this.getPlayer().getInventory().getShield().getName());
                    // Satın alma bitti.
                }
            }
        }
    }
}
