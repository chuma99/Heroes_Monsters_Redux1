public class HalfEnergyPotion extends Potion{
    private static int countPotion = 0;
    
    public HalfEnergyPotion(String potionName, int xPos, int yPos){
        super(potionName, xPos, yPos);
        countPotion++;
        //this.potionEffect = potionEffect;
    }
    
    public static void usePotion(){
        HalfEnergyPotion.countPotion--;
    }
}