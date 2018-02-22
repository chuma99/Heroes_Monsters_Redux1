public class EnergyPotion extends Potion{
    private static int countPotion = 0;
    
    public EnergyPotion(String potionName, int xPos, int yPos){
        super(potionName, xPos, yPos);
        countPotion++;
        //this.potionEffect = potionEffect;
    }
    
    public static void usePotion(){
        EnergyPotion.countPotion--;
    }
}