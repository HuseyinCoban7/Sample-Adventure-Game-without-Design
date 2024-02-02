
public class SafeHouse extends NormalLoc{
    
    public SafeHouse(Player player) {
        super(player, "SafeHouse");
    }
    
    public boolean getLocation(){
        player.setHealth(player.getrHealth());
        System.out.println("Your health is fulled!");
        System.out.println("You are in SafeHouse now.");
        return true;
    }
    
    
}
