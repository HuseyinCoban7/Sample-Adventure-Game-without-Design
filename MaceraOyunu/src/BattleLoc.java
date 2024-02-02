
public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    protected String award;
    public BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;
    }
    
    public boolean getLocation(){
        int obscount = obstacle.count();
        System.out.println("You're here now.: "+this.getName());
        System.out.println("Be Careful! " + obscount +" " +obstacle.getName() +" living here!");
        System.out.print("<F>ight or <E>scape");
        String selCase = scan.nextLine();
        selCase = selCase.toUpperCase();
        if(selCase.equals("F")){
            if(combat(obscount)){
                System.out.println("You eliminated all enemies in"+" "+this.getName()+" area!");
                if(this.award.equals("Food")&& player.getInv().isFood()==false){
                    System.out.println("You earned "+this.award);
                    player.getInv().setFood(true);
                }
                else if(this.award.equals("Water")&& player.getInv().isWater()==false){
                    System.out.println("You earned "+this.award);
                    player.getInv().setWater(true);
                }
                else{
                    System.out.println("You earned "+this.award);
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if(player.getHealth()<=0){
                System.out.println("You are eliminated...");
                return false;
            }
            
        }
        return true;
    }
    
    public boolean combat(int obscount){
        for(int i = 0 ; i < obscount ; i++){
            int defObsHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while(player.getHealth()>0 && obstacle.getHealth()>0){
                System.out.print("<H>it or <E>scape");
                String selCase = scan.nextLine();
                selCase = selCase.toUpperCase();
                        if(selCase.equals("H")){
                            System.out.println("You Damaged!");
                            obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                            afterHit();
                            if(obstacle.getHealth()>=0){
                                System.out.println();
                                System.out.println("Enemy damaged to you!");
                                player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor()));
                                afterHit();    
                            }
                        }
                        else{
                            return false;
                        }
            }
            if(obstacle.getHealth()<player.getHealth()){
                System.out.println("You killed your enemy!");
                player.setMoney((player.getMoney()+obstacle.getAward()));
                System.out.println("Your Money: "+player.getMoney());
                obstacle.setHealth(defObsHealth);
            }
            else{
                return false;
            }
            System.out.println("-------------------------");
        }
        return true;
    }
    
    public void playerStats(){
        System.out.println("Player Values\n---------");
        System.out.println("Health: "+player.getHealth());
        System.out.println("Damage: "+player.getTotalDamage());
        System.out.println("Money: "+player.getMoney());
        if(player.getInv().getDamage() > 0){
            System.out.println("Weapon: "+player.getInv().getwName());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Armor: "+player.getInv().getaName());
        }
        System.out.println();
    }
    
    public void enemyStats(){
        System.out.println(obstacle.getName()+"Values\n---------");
        System.out.println("Health: "+obstacle.getHealth());
        System.out.println("Damage: "+obstacle.getDamage());
        System.out.println("Award: "+obstacle.getAward());
    }
    
    public void afterHit(){
        System.out.println("Your Health: "+player.getHealth());
        System.out.println("Enemy Health: "+obstacle.getHealth());
        System.out.println();
    }
    
    
    
    
    
    
}
