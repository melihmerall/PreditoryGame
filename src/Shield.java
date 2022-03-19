public class Shield {

    private String name;
    private int id;
    private int blockRate;
    private int coin;

    public Shield(String name,int id,int blockRate,int coin){

        this.name = name;
        this.id = id;
        this.blockRate =  blockRate;
        this.coin = coin;
    }
    public Shield(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlockRate() {
        return blockRate;
    }

    public void setBlockRate(int blockRate) {
        this.blockRate = blockRate;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public static Shield[] shields(){
        Shield[] shieldList = new Shield[3];
        shieldList[0] = new Shield(" Basic Shield ",1,1,15);
        shieldList[1] = new Shield(" Middle Shield ",2,3,25);
        shieldList[2] = new Shield(" Prof Shield ",3,5,40);
        return shieldList;
    }

    public static Shield getShieldObjByID(int id){
        for (Shield s : Shield.shields()) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
