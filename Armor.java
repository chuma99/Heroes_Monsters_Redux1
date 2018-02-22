public class Armor
{
    private String armorName;
    private int damageReduct;
    
    //damageReduct = 0 means no armor
    //damageReduct = 1 means monster gives hero 2/3 damage of its original damage
    public Armor(String armorName, int damageReduct)
    {
        this.armorName = armorName;
        this.damageReduct = damageReduct;
    }
    
    /*public void interact(Hero hiro){
        System.out.println("he gives you Bronze Armor");
        damageReduct = 1;
    }*/
    
    public void setdamageReduct(int damage){
        damageReduct = damage;
    }
    
    public String getArmorName(){
        return armorName;
    }
    
    public int getDamageReduct(){
        return damageReduct;
    }
}