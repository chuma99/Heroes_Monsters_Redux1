public class Hero
{
    private int xPos;
    private int yPos;
    private int health;
    private Weapon heroWeapon;
    private Armor heroArmor;
    private int halfEnergyPotion;
    private int energyPotion;
    private int phoenixPotion;
    private boolean farmerHasMap;
    private int totalCurrency;
    private int countBossKilled;
    private Inventory heroInventory;
    private int heroDirection;
    private Sandal heroSandal;
    private int bomb;
    
    boolean farmerWithMap = false;
    boolean firstBoss = false;
    boolean firstBossDefeated = false;
    boolean secondBossDefeated = false;
    boolean thirdBossDefeated = false;
    public Hero(int xPos, int yPos, int health, Weapon heroWeapon, Armor heroArmor, boolean farmerHasMap, int bossKills, Inventory heroInventory, int heroDirection, Sandal heroSandal, int bomb)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = health;
        this.heroWeapon = heroWeapon; //new Weapon("dagger", 10, 30);
        this.heroArmor = heroArmor; //new Armor("no armor", 0);
        this.halfEnergyPotion = 0;
        this.energyPotion = 0;
        this.phoenixPotion = 0;
        this.farmerHasMap = farmerHasMap;
        this.totalCurrency = 0;
        this.countBossKilled = bossKills;
        this.heroInventory = heroInventory;
        this.heroDirection = heroDirection;
        this.heroSandal = heroSandal;
        this.bomb = bomb;
    } 
    
    public boolean validMove(String input){
        if(input.equals("a") && xPos == 0){
            return false;
        }
        else if(input.equals("d") && xPos == 14){
            return false;
        }
        else if(input.equals("w") && yPos == 0){
            return false;
        }
        else if(input.equals("s") && yPos == 14){
            return false;
        }
        else{
            return true;
        }
    }
    
    public int getHeroDirection(){
        return heroDirection;
    }
    
    public void setHeroDirection(int x){
        heroDirection = x;
    }
    
    public int getCountBossKilled(BossMonster boss){
        return boss.getCountBossKilled();
    }
    
    public void setFarmerHasMap(boolean map){
        farmerWithMap = map;
    }
    
    public boolean getFarmerHasMap(){
        return farmerWithMap;
    }
    
    public int getArmor(){
        return heroArmor.getDamageReduct();
    }
    
    public int getTotalCurrency(){
        return totalCurrency;
    }
    
    public void setTotalCurrency(int x){
        totalCurrency += x;
    }
    
    public int getAttack(){
        return heroWeapon.attackMonster();
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getHalfEnergyPotion()
    {
        return halfEnergyPotion;
    }
    
    public void setHalfEnergyPotion(int p){
        halfEnergyPotion = halfEnergyPotion + p;
    }
    
    public int getEnergyPotion()
    {
        return energyPotion;
    }
    
    public void setEnergyPotion(int p){
        energyPotion = energyPotion + p;
    }
    
    public int getBombPotion(){
        return bomb;
    }
    
    public void setBombPotion(int x){
        bomb = bomb + x;
    }
    
    public int getPhoenixPotion()
    {
        return phoenixPotion;
    }
    
    public void setPhoenixPotion(int p){
        phoenixPotion = phoenixPotion + p;
    }
    
    public int getxPos()
    {
        return xPos;
    }
    
    public int getyPos()
    {
        return yPos;
    } 
    
    public void setX(int xIncrement){
        xPos = xPos + xIncrement;
        if(xPos < 0){
            xPos = 0;
            System.out.println("you cannot move left");
        }
    }
    
    public void setY(int yIncrement){
        
        yPos = yPos + yIncrement;
        if(yPos < 0){
            yPos = 0;
            System.out.println("you cannot move down");
        }
    }
    
    public Inventory getInventory(){
        return heroInventory;
    }
    
    public void setInventory(Inventory x){
        heroInventory = x;
    }
    
    public void setWeapon(Weapon sword){
        heroWeapon = sword;
    }
    
    public String getWeaponName(){
        return heroWeapon.getNameWeapon();
    }
    
    public Weapon getWeapon(){
        return heroWeapon;
    }
    
    public void setHealth(int damage){
         health = health - damage;
    }
    
    public void setFullHealth(int restoreHealth){
        health = restoreHealth;
    }
    
    public void useHalfPotion(){
        if(health < 50){
            health += 50;
        }else{
            health = 100;
        }
    }
    
    public void setArmor(Armor armor){
         heroArmor = armor;
    }
    
    public Sandal getSandal(){
        return heroSandal;
    }
    
    public void setSandal(Sandal x){
        heroSandal = x;
    }
    
    public void setFirstBoss(boolean choice){
        firstBoss = choice;
    }
    
    public boolean getFirstBoss(){
        return firstBoss;
    }
    
    public void setFirstBossDefeated(boolean choice){
        firstBossDefeated = choice;
    }
    
    public boolean getFirstBossDefeated(){
        return firstBossDefeated;
    }
    
    public void setSecondBossDefeated(boolean choice){
        secondBossDefeated = choice;
    }
    
    public boolean getSecondBossDefeated(){
        return secondBossDefeated;
    }
    
    public void setThirdBossDefeated(boolean choice){
        thirdBossDefeated = choice;
    }
    
    public boolean getThirdBossDefeated(){
        return thirdBossDefeated;
    }
    
}