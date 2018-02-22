public abstract class Monster{
    private int xPosMonster;
    private int yPosMonster;
    private int attack;
    private int health;
    private int speed;
    int escape;
    
    public Monster(int xPosMonster, int yPosMonster, int attack, int health, int speed){
        this.xPosMonster = xPosMonster;
        this.yPosMonster = yPosMonster;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
        escape = 0;
    }
    
    public abstract void interact(Hero hiro);
    
    public int getEscape(){
        return escape;
    }
    
    public int getxPosMonster()
    {
        return xPosMonster;
    }
    
    public int getyPosMonster()
    {
        return yPosMonster;
    }
}