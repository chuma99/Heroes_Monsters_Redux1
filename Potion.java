public abstract class Potion{
    private String potionName;
    private int xPos;
    private int yPos;
    
    public Potion(String n, int x, int y){
        potionName = n;
        xPos = x;
        yPos = y;
    }
    
    public String getpotionName(){
        return potionName;
    }
    
    public int getxPosPotion()
    {
        return xPos;
    }
    
    public int getyPosPotion()
    {
        return yPos;
    }
}