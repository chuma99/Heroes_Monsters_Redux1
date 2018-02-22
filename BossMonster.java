import java.io.*;
import java.util.*; 
public class BossMonster{
    private int xPosMonster;
    private int yPosMonster;
    private int attack;
    private int health;
    private int speed;
    private String printedDirection;
    private int direction;//1=north, 2 = south, 3 = east, 4 = west
    public static int countBossKilled = 0;

    int escape;

    public BossMonster(int xPosMonster, int yPosMonster, int attack, int health, int speed){
        this.xPosMonster = xPosMonster;
        this.yPosMonster = yPosMonster;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
        escape = 0;
    }

    public void killBoss(Hero hiro){
        countBossKilled++;
        hiro.setTotalCurrency(2);
    }

    public void interact(Hero hiro){
        System.out.println("You have encountered a boss.");
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
            System.out.println("1. Attack \n" + "2. Run \n3. Use Energy Potion \n4. Use Half Energy Potion \n5. Use Bomb");
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
            if (choice.equals("1")){
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
                                        System.out.println("The boss is giving an error");
                                    }
                                }
                                //attack every other turn
                            }
                            System.out.println("You attack the monster twice and deal " + (hiroAttack * 2) + " damage to the boss.");
                            System.out.println("Boss's health: (" + health + "/" + preHealth + ")\n");

                            if(health <= 0){
                                System.out.println("You have killed the boss!");
                                killBoss(hiro);
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The boss attacks you and deals " + attack + " damage.");
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
                            System.out.println("You attack the boss and deal " + hiro.getAttack() + " damage to the boss.");
                            if(health <= 0){
                                System.out.println("You have killed the boss.");
                                killBoss(hiro);
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The boss attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            if(hiro.getHealth() <= 0){
                                System.out.println("You have died. Game over.");
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
                                        System.out.println("The boss is returning an error.");
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
                            System.out.println("You attack and deal " + hiroAttack + " damage to the boss.");
                            System.out.println("Boss's health: (" + health + "/" + preHealth + ")\n");

                            if(health <= 0){
                                System.out.println("You have killed the boss.");
                                killBoss(hiro);
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The boss attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            if(hiro.getHealth() <= 0){
                                System.out.println("You have died. Game over.");
                                isTrue = false;
                                isRunning = false;
                            }
                        }
                    }
                    else if(hiro.getArmor() == 1){
                        while(isTrue){
                            System.out.println("You attack and deal " + hiro.getAttack() + " damage to the boss.");
                            System.out.println("Boss's health: (" + health + "/" + preHealth + ")\n");

                            if(health <= 0){
                                System.out.println("You have killed the boss.");
                                killBoss(hiro);
                                isTrue = false;
                                isRunning = false;
                            }else{
                                System.out.println("The boss attacks you and deals " + attack + " damage.");
                                System.out.println("Hero's health: (" + hiro.getHealth() + "/100)\n");
                            }
                            if(hiro.getHealth() <= 0){
                                System.out.println("You have died. Game over.");
                                isTrue = false;
                                isRunning = false;
                            }
                        }
                    }
                }
            }else if(choice.equals("2")){
                
                System.out.println("Speed: " + speed);
                if( hiroDirection == 1){
                    if(direction == 1){
                        System.out.println("You have escaped the boss!");
                        escape = 1;
                        isRunning = false;
                    }
                    else if(direction == 2){
                        System.out.println("You CANNOT escape!");
                    }
                    else if(direction == 3){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                    else if(direction == 4){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                }
                else if(hiroDirection == 2){
                    if(direction == 1){
                        System.out.println("You CANNOT escape!");
                    }
                    else if(direction == 2){
                        System.out.println("You have escaped the boss!");
                        escape = 1;
                        isRunning = false;
                    }
                    else if(direction == 3){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                    else if(direction == 4){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                }
                else if(hiroDirection == 3){
                    if(direction == 1){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                    else if(direction == 2){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                    else if(direction == 3){
                        System.out.println("You have escaped the boss!");
                        escape = 1;
                        isRunning = false;
                    }
                    else if(direction == 4){
                        System.out.println("You CANNOT escape!");
                    }
                }
                else if(direction == 4){
                    if(direction == 1){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                    else if(direction == 2){
                        if((int) (Math.random() * 100) + 1 <= 50){
                            System.out.println("You have escaped the boss!");
                            escape = 1;
                            isRunning = false;
                        }
                        else{
                            System.out.println("You CANNOT escape!");
                        }
                    }
                    else if(direction == 3){
                        System.out.println("You CANNOT escape!");
                    }
                    else if(direction == 4){
                        System.out.println("You have escaped the boss!");
                        escape = 1;
                        isRunning = false;
                    }
                }
            }else if(choice.equals("3")){
                if(hiro.getEnergyPotion() != 0){
                    EnergyPotion.usePotion(); //Energy potion = 100 health
                    hiro.setEnergyPotion(-1);
                    System.out.println("Your health is now 100 hp");
                    hiro.setFullHealth(100);
                }
                else if(hiro.getEnergyPotion() == 0){
                    System.out.println("You don't have any full energy potions!");
                }
            }else if(choice.equals("4")){
                if(hiro.getHalfEnergyPotion() != 0){
                    EnergyPotion.usePotion();
                    hiro.setEnergyPotion(-1);
                    System.out.println("Your health has been increased by 50 hp");
                    hiro.useHalfPotion();
                }
                else if(hiro.getHalfEnergyPotion() == 0){
                    System.out.println("You don't have any half energy potions!");
                }
            }else if(choice.equals("5")){
                if(hiro.getBombPotion() != 0){
                    BombPotion.usePotion();
                    hiro.setBombPotion(-1);
                    System.out.println("You have killed the boss!");
                    killBoss(hiro);
                    isRunning = false;
                }
                else if(hiro.getHalfEnergyPotion() == 0){
                    System.out.println("You don't have any bombs!");
                }
            }else{
                System.out.println("Choose a valid choice");
            }

        }
    }

    public int getCountBossKilled(){
        return countBossKilled;
    }

    public int getEscape(){
        return escape;
    }

    public int getxPosMonster(){
        return xPosMonster;
    }

    public int getyPosMonster(){
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