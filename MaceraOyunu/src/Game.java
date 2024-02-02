
import java.util.Scanner;


public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);
    
    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Enter Your Name Before Starting the Game: ");
        String playerName=scan.nextLine();
        player = new Player("a");
        player.selectCha();
        start();
    }
    
    public void start(){
        while(true){
            System.out.println();
        System.out.println("=====================================");
        System.out.println();
        System.out.println("Select the map you want to play: ");
        System.out.println("1. Safehouse --> A safe place of your own. No enemies. ");
        System.out.println("2. Cave --> Your enemies are zombies. ");
        System.out.println("3. Jungle --> Your enemies are bears. ");
        System.out.println("4. River --> Your enemies are alligators. ");
        System.out.println("5. ToolStore --> You can buy weapons or armor. ");
        System.out.print("Where do you want to go? ");
        int selLoc = scan.nextInt();
        while(selLoc < 0 ||selLoc > 5){
            System.out.print("Please select a valid location!");
            selLoc = scan.nextInt();
        }
        switch(selLoc){
            case 1:
                location = new SafeHouse(player);
                break;
            case 2:
                location = new Cave(player);
                break;
            case 3:
                location = new Jungle(player);
                break;
            case 4:
                location = new River(player);
                break;
            case 5:
                location = new ToolStore(player);
                break;
            default:
                location = new SafeHouse(player);
        }
            if(location.getClass().getName().equals("SafeHouse")){
                if(player.getInv().isFirewood()&&player.getInv().isFood()&&player.getInv().isWater()){
                    System.out.println("You Won!");
                    break;
                }
            }
            if(!location.getLocation()){
                System.out.println("Game Over!");
                break;
        }
      }
    }
    
    
    
}
