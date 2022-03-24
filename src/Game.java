import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start (){
        System.out.println("Welcome to Battle Monsters !");
        System.out.println("Input a Nickname : ");
        //String playerNickname = input.nextLine();
        Player player = new Player("melih");
        System.out.println(player.getName() + " Welcome !!");
        System.out.println("Choose a Hero !!");
        player.selectChar();
        Location location = null;
        while(true){
            player.printInfo();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("----------Areas------------");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("1- Safe House");
            System.out.println("2- Store");
            System.out.println("3- Enter The Cave - Battle Map");

            System.out.println("4- Enter The Forest - Battle Map");
            System.out.println("5- Enter The River - Battle Map");
            System.out.println("0- Stop the game");
            System.out.println("Choose your want to go area: ");
            int selectArea = input.nextInt();
            switch (selectArea){
                case 0:
                    location =null;
                    break;
                case 1:
                    System.out.println("Your choose Safe House - Teleporting...");
                    location = new SafeLocation(player);
                    break;
                case 2:
                    System.out.println("Your choose Store - teleportings...");
                    location = new ItemStore(player);
                    break;
                case 3:
                    location = new CaveMap(player);
                    break;
                case 4:
                    location = new ForestMap(player);
                    break;
                case 5:
                    location = new RiverMap(player);
                    break;
                default:
                    System.out.println("default area is safe house");
                    location = new SafeLocation(player);
                    break;
            }
            System.out.println(location.getName());
            if(location ==null){
                System.out.println("Game is over.");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
        }


    }
}
