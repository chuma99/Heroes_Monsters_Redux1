import java.io.*;
import java.util.*; 
public class LowMonster{
    private int xPosMonster;
    private int yPosMonster;
    private int attack;
    private int health;
    private int speed;
    private int direction;//1=north, 2 = south, 3 = east, 4 = west
    private String printedDirection;
    public static int countBoss = 0;
    public static int countMonstersKilled = 0;

    int escape;

    public LowMonster(int xPosMonster, int yPosMonster, int attack, int health, int speed, int direction){
        this.xPosMonster = xPosMonster;
        this.yPosMonster = yPosMonster;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
        this.direction = direction;
        countBoss++;
        escape = 0;
    }

    /*public void killBoss(Hero hiro){
    Monster.countBoss--;
    hiro.setTotalCurrency(2);
    }*/

    public void killMonster(Hero hiro){
        countMonstersKilled++;
        hiro.setTotalCurrency(1);
    }

    public void interact(Hero hiro){
        //if(hiro != null && hiro.equals(xPosMonster) && hiro.equals(yPosMonster)){
        System.out.println("You have encountered a monster.");
        Scanner kbReader = new Scanner(System.in);
        int preHealth = health;
        int hiroAttack = hiro.getAttack();
        int hiroHealth = hiro.getHealth();
        boolean isTrue = true;
        boolean isRunning = true;
        int hiroDirection = hiro.getHeroDirection();
        while(isRunning){
            /*if(direction == 1){
                printedDirection.equals("North");
            }
            else if(direction == 2){
                printedDirection.equals("South");
            }
            else if(direction == 3){
                printedDirection.equals("East");
            }
            else if(direction == 4){
                printedDirection.equals("West");
            }*/
            isTrue = true;
            System.out.println("Attack: " + attack + " / Health: " + health + " / Speed: " + speed);
            System.out.println("1. Attack \n2. Run \n3. Use Energy Potion \n4. Half Energy Potion \n5. Bomb");
            String choice = kbReader.nextLine( ); 
            
            /*
            if(speed == 0){
            if((int) (Math.random() * 100) + 1 <= 75){
            System.out.println("You have escaped the monster!");
            escape = 1;
            isTrue = false;
            }
            else{
            System.out.println("You CANNOT escape!");

            }
            }
            else if(speed == 1){
            if((int) (Math.random() * 100) + 1 <= 50){
            System.out.println("You have escaped the monster!");
            escape = 1;
            isTrue = false;
            }
            else{
            System.out.println("You CANNOT escape!");
            }
            }
            else if(speed == 2){
            if((int) (Math.random() * 100) + 1 <= 25){
            System.out.println("You have escaped the monster!");
            escape = 1;
            isTrue = false;
            }
            else{
            System.out.println("You CANNOT escape!");

            }
            }
            else if(speed == 3){
            System.out.println("You CANNOT escape!");
            }*/
            if(choice.equals("1")){
                if(hiro.getSandal().getLeatherSandal() == 1){
                    if(hiro.getArmor() == 0){
                        while(isTrue){
                            if(hiro.getWeapon().getNameWeapon() == "Battle Axe"){
                                int count = 0;
                                count ++;
                                if(count == 1){
                                    System.out.println("Your turn was skipped.");
                                    if(health > 0){
                                         hiro.setHealth(attack);
                                    }
                                    System.out.println("The monster attacks you and deals " + attack + " damage.");
                                    System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                                    if(hiro.getHealth() <= 0){
                                        System.out.println("You have died.");
                                        isTrue = false;
                                        isRunning = false;
                                    }
                                }else if(count == 2){
                                    if(speed == 0){
                                        if((int) (Math.random() * 100) + 1 <= 85){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            hiro.setHealth(attack);
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 1){
                                        if((int) (Math.random() * 100) + 1 <= 75){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            hiro.setHealth(attack);
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 2){
                                        if((int) (Math.random() * 100) + 1 <= 65){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            hiro.setHealth(attack);
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 3){
                                        if((int) (Math.random() * 100) + 1 <= 55){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            hiro.setHealth(attack);
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else{
                                        System.out.println("error");
                                    }
                                }
                                //attack every other turn
                            }
                            else if(hiro.getWeapon().getNameWeapon() == "Long Sword" || hiro.getWeapon().getNameWeapon() == "Short Sword" || hiro.getWeapon().getNameWeapon() == "Dagger" ){
                                int count = 0;
                                count ++;
                                if(count == 1){
                                    if(speed == 0){
                                        if((int) (Math.random() * 100) + 1 <= 85){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 1){
                                        if((int) (Math.random() * 100) + 1 <= 75){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 2){
                                        if((int) (Math.random() * 100) + 1 <= 65){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 3){
                                        if((int) (Math.random() * 100) + 1 <= 55){
                                            health = health - hiroAttack;
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else{
                                        System.out.println("error");
                                    }
                                }
                                //attack every other turn
                            }
                            System.out.println("You attack the monster twice and deal " + (hiroAttack * 2) + " damage to the monster.");
                            System.out.println("Monster's health: (" + health + "/" + preHealth + ")\n");

                            if(health <= 0){
                                System.out.println("You have killed the monster.");
                                killMonster(hiro);
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The monster attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            
                            if(hiro.getHealth() <= 0){
                                System.out.println("You have died.");
                                isTrue = false;
                                isRunning = false;
                            }
                        }
                    }
                    else if(hiro.getArmor() == 1){
                        while(isTrue){
                            System.out.println("You attack the monster and deal " + hiro.getAttack() + " damage to the monster.");
                            if(health <= 0){
                                System.out.println("You have killed the monster.");
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The monster attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            if(hiro.getHealth() <= 0){
                                System.out.println("you have died");
                                isTrue = false;
                                isRunning = false;
                            }
                        }
                    }
                }
                else if(hiro.getSandal().getLeatherSandal() == 0){
                    if(hiro.getArmor() == 0){
                        while(isTrue){
                            if(hiro.getWeapon().getNameWeapon() == "Battle Axe"){
                                int count = 0;
                                count ++;
                                if(count == 1){
                                    System.out.println("Your turn was skipped.");
                                    if(health > 0){
                                         hiro.setHealth(attack);
                                    }
                                    System.out.println("The monster attacks you and deals " + attack + " damage.");
                                    System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                                    if(hiro.getHealth() <= 0){
                                        System.out.println("You have died.");
                                        isTrue = false;
                                        isRunning = false;
                                    }
                                }else if(count == 2){
                                    if(speed == 0){
                                        if((int) (Math.random() * 100) + 1 <= 85){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 1){
                                        if((int) (Math.random() * 100) + 1 <= 75){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 2){
                                        if((int) (Math.random() * 100) + 1 <= 65){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 3){
                                        if((int) (Math.random() * 100) + 1 <= 55){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else{
                                        System.out.println("error");
                                        isTrue = false;
                                    }
                                }
                                //attack every other turn
                            }
                            else if(hiro.getWeapon().getNameWeapon() == "Long Sword" || hiro.getWeapon().getNameWeapon() == "Short Sword" || hiro.getWeapon().getNameWeapon() == "Dagger" ){
                                int count = 0;
                                count ++;
                                if(count == 1){
                                    if(speed == 0){
                                        if((int) (Math.random() * 100) + 1 <= 85){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 1){
                                        if((int) (Math.random() * 100) + 1 <= 75){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 2){
                                        if((int) (Math.random() * 100) + 1 <= 65){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else if(speed == 3){
                                        if((int) (Math.random() * 100) + 1 <= 55){
                                            health = health - hiroAttack;
                                            if(health > 0){
                                                hiro.setHealth(attack);
                                            }
                                            count = 0;
                                            isTrue = false;
                                        }
                                    }
                                    else{
                                        System.out.println("error");
                                        isTrue = false;
                                    }
                                }
                                //attack every other turn
                            }
                            System.out.println("You attack the monster and deal " + hiroAttack + " damage to the monster");
                            System.out.println("Monster's health: (" + health + "/" + preHealth + ")\n");

                            if(health <= 0){
                                System.out.println("You have killed the monster.");
                                killMonster(hiro);
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The monster attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            if(hiro.getHealth() <= 0){
                                System.out.println("You have died.");
                                isTrue = false;
                                isRunning = false;
                            }
                        }
                    }
                    else if(hiro.getArmor() == 1){
                        while(isTrue){
                            System.out.println("You attack and deal " + hiro.getAttack() + " damage to the monster.");
                            System.out.println("Monster's health: (" + health + "/" + preHealth + ")\n");

                            if(health <= 0){
                                System.out.println("You have killed the monster.");
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The monster attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            if(hiro.getHealth() <= 0){
                                System.out.println("You have died.");
                                isTrue = false;
                                isRunning = false;
                            }
                        }
                    }
                }
            }
            else if(choice.equals("2")){
                System.out.println("Monster Speed: " + speed);
                while(isTrue){
                    
                    if(hiroDirection == 1){
                        if(direction == 1){
                            System.out.println("You have escaped the monster!");
                            escape = 1;
                            isTrue = false;
                            isRunning = false;
                        }
                        else if(direction == 2){
                            System.out.println("You CANNOT escape!");
                            isTrue = false;
                        }
                        else if(direction == 3){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                        else if(direction == 4){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                    }
                    else if(hiroDirection == 2){
                        if(direction == 1){
                            System.out.println("You CANNOT escape!");
                            isTrue = false;
                        }
                        else if(direction == 2){
                            System.out.println("You have escaped the monster!");
                            escape = 1;
                            isTrue = false;
                            isRunning = false;
                        }
                        else if(direction == 3){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                        else if(direction == 4){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                    }
                    else if(hiroDirection == 3){
                        if(direction == 1){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                        else if(direction == 2){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                        else if(direction == 3){
                            System.out.println("You have escaped the monster!");
                            escape = 1;
                            isTrue = false;
                            isRunning = false;
                        }
                        else if(direction == 4){
                            System.out.println("You CANNOT escape!");
                            isTrue = false;
                        }
                    }
                    else if(direction == 4){
                        if(direction == 1){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                        else if(direction == 2){
                            if((int) (Math.random() * 100) + 1 <= 50){
                                System.out.println("You have escaped the monster!");
                                escape = 1;
                                isTrue = false;
                                isRunning = false;
                            }
                            else{
                                System.out.println("You CANNOT escape!");
                                isTrue = false;
                            }
                        }
                        else if(direction == 3){
                            System.out.println("You CANNOT escape!");
                            isTrue = false;
                        }
                        else if(direction == 4){
                            System.out.println("You have escaped the monster!");
                            escape = 1;
                            isTrue = false;
                            isRunning = false;
                        }
                    }
                }
            }
            else if(choice.equals("3")){
                if(hiro.getEnergyPotion() != 0){
                    EnergyPotion.usePotion(); //Energy potion = 100 health
                    hiro.setEnergyPotion(-1);
                    System.out.println("You now have 100 hp");
                    hiro.setFullHealth(100);
                }
                else if(hiro.getEnergyPotion() == 0){
                    System.out.println("You dont have any full energy potions!");
                }
            }
            else if(choice.equals("4")){
                if(hiro.getHalfEnergyPotion() != 0){
                    HalfEnergyPotion.usePotion();
                    hiro.setHalfEnergyPotion(-1);
                    System.out.println("Your health has been increased by 50 hp");
                    hiro.useHalfPotion();
                }
                else if(hiro.getHalfEnergyPotion() == 0){
                    System.out.println("You dont have any half energy potions!");
                }
            }
            else if(choice.equals("5")){
                if(hiro.getBombPotion() != 0){
                    BombPotion.usePotion();
                    hiro.setBombPotion(-1);
                    System.out.println("You have killed the monster");
                    killMonster(hiro);
                    isRunning = false;
                }
                else if(hiro.getHalfEnergyPotion() == 0){
                    System.out.println("You dont have any bombs!");
                }
            }
            else{
                System.out.println("Choose a valid choice");
            }
        }
    }

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
    /*public int stats(){
    int attackRange = (30 - 1) + 1;
    int attackRandom = (int)(Math.random() * attackRange) + 1;
    int healthRange = (100 - 1) + 1;
    int healthRandom = (int)(Math.random() * healthRange) + 1;
    int speedRange = (100 - 1) + 1;
    int speedRandom = (int)(Math.random() * speedRange) + 1;
    return 0;
    }*/

}