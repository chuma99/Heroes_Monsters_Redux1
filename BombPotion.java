public class BombPotion extends Potion{
    private static int countPotion = 0;
    
    public BombPotion(String potionName, int xPos, int yPos){
        super(potionName, xPos, yPos);
        countPotion++;
        //this.potionEffect = potionEffect;
    }
    
    public static void usePotion(){
        BombPotion.countPotion--;
    }
}