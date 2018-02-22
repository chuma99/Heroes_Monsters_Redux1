public class PhoenixPotion extends Potion{
    private static int countPotion = 0;
    
    public PhoenixPotion(String potionName, int xPos, int yPos){
        super(potionName, xPos, yPos);
        countPotion++;
        //this.potionEffect = potionEffect;
    }
    
    public static void usePotion(Hero hiro){
        PhoenixPotion.countPotion--;
        hiro.setFullHealth(100);
    }
    
    public static int getCountPotion(){
        return countPotion;
    }
}