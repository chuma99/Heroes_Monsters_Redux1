import java.io.*;
import java.util.*; 
public abstract class Farmer
{
    private String name;
    private int xPosFarmer;
    private int yPosFarmer;
    private int quest;
    //private Weapon weapon;
    //private Armor armor;

    static boolean firstFarmer = true; 
    boolean firstBossAlive = false;
    boolean secondBossAlive = false;
    boolean thirdBossAlive = false;

    Sandal leatherSandal = new Sandal("Leather Sandal", 1);
    Inventory satchel = new Inventory("Satchel", 9, 2);
    Weapon shortSword = new Weapon("Short Sword", 40, 60, 1);
    Weapon longSword = new Weapon("Long Sword", 75, 100, 1);
    Weapon battleAxe = new Weapon("Battle Axe", 150, 175, 2);

    public Farmer(String name, int xPosFarmer, int yPosFarmer, int quest)
    {
        this.name = name;
        this.xPosFarmer = xPosFarmer;
        this.yPosFarmer = yPosFarmer;
        this.quest = quest;
    }

    public void interact(Hero hiro){
        BossMonster boss = new BossMonster(-6, -7, 10, 10, 1);
        int BossMonstersKilled = hiro.getCountBossKilled(boss);
        Scanner kbReader = new Scanner(System.in);
        boolean map = true;
        if(quest == 0){
            if(firstFarmer){
                System.out.println("Hello hero. I am a tradesperson and I am selling a Trader Location Map.");
                System.out.println("In order to save the land from all of the dangerous monsters hiding within it,");
                System.out.println("you must find and communicate with all of the townspeople.");
                System.out.println("The map will cost one hide to purchase. Would you like to purchase it?");
                while(map){
                    System.out.println("\n1. Yes\n2. No");
                    String choice = kbReader.nextLine();

                    if(choice.equals("1")){
                        if(hiro.getTotalCurrency() >= 1){
                            System.out.println("You have purchased the 'Trader Location Map'");
                            System.out.println("You can now see the location of the other traders.");
                            System.out.println("Visit each of the traders, as they will each help you on your journey.");
                            System.out.println("In the store, you can find many items that will make fighting and traveling much easier,");
                            System.out.println("and from the different townspeople, you can find the locations of the boss monsters who have taken over.");
                            System.out.println("Only you can save us, hero!");
                            hiro.setTotalCurrency(-1);//currency -1 cuz u bought the map and makes traders visible
                            hiro.setFarmerHasMap(true);
                            firstFarmer = false;
                            map = false;
                        }else{
                            System.out.println("You can not afford the map at this time. Please kill a monster and return.");
                            map = false;
                        }
                    }else if(choice.equals("2")){
                        System.out.println("Farewell Hero.");
                        map = false;
                    }else{
                        System.out.println("This is not a valid option.");
                    }
                }
            }else{
                System.out.println("Hello hero. I am a firm believer in your abilities, and I am rooting for you on your ascent to victory!");
            }
        }else if(quest == 1){
            if(BossMonstersKilled == 0){
                System.out.println("My children haven't left the house in three days because of this tyrant who watches our movements.");
                System.out.println("Please, hero, help free us from his control!\n");
                System.out.println("You can now see the first boss on the map.");
                firstBossAlive = true;
                hiro.setFirstBoss(true);
            }else if(BossMonstersKilled == 1){
                System.out.println("Good job! Your help is much appreciated, but other townspeople need you!\n");
                System.out.println("Go to the second trader for the location of the 2nd boss.");
                firstBossAlive = false;
            }else if(BossMonstersKilled == 2){
                System.out.println("Good job! Your help is much appreciated, but one more townsperson needs your help!\n");
                System.out.println("Go to the third trader for the location of the 3nd boss.");
            }else if(BossMonstersKilled >= 3){
                System.out.println("You have killed all of the bosses! I appreciate your bravery.");
                thirdBossAlive = false;
                hiro.setThirdBossDefeated(true);
            }
            //bossMonster.reveal();first boss
        }
        else if(quest == 2){
            if(BossMonstersKilled == 0){
                System.out.println("Come back when you've killed the first boss.");
            }else if(BossMonstersKilled == 1){
                System.out.println("Congrats on killing the first boss! You might be the perfect person to help me.");
                System.out.println("A boss monster has been running around the land and it refuses to stop destroying property!");
                System.out.println("If you can, please use your strength and fighting ability to solve this problem!\n");
                System.out.println("You can now see the second boss on the map."); //reveal location of second boss
                secondBossAlive = true;
                hiro.setFirstBossDefeated(true);
            }else if(BossMonstersKilled == 2){
                System.out.println("Good job! Your help is much appreciated, but one more townsperson needs your help!\n");
                System.out.println("Go to the third trader for the location of the 3nd boss.");
                secondBossAlive = false;
                //allows u to interact with third trader
            }else if(BossMonstersKilled >= 3){
                System.out.println("You have killed all of the bosses! I appreciate your bravery.");
                thirdBossAlive = false;
                hiro.setThirdBossDefeated(true);
            }
        }
        else if(quest == 3){
            if(BossMonstersKilled < 2){
                System.out.println("Come back when you've killed the second boss.");
            }
            else if(BossMonstersKilled == 2){
                System.out.println("Congrats on killing the second boss! You may be ready to save the land of Fiona!");
                System.out.println("A final boss monster has dethrowned all of our royalty, and beats us with no remorse.");
                System.out.println("You are the only one who can save us from his terror, and I trust that you will do so.\n");
                System.out.println("You can now see the third boss on the map."); //reveal location of third boss
                thirdBossAlive = true;
                hiro.setSecondBossDefeated(true);
            }else if(BossMonstersKilled >= 3){
                System.out.println("Good job! You have killed all of the bosses! I appreciate your bravery.");
                thirdBossAlive = false;
                hiro.setThirdBossDefeated(true);
            }
        }
        else if(quest == 4){
            int hiroCurrency = hiro.getTotalCurrency();
            boolean menu = true;
            System.out.println("Welcome to the store!");
            while(menu){
                System.out.println("Please select the number of the product that interests you.");
                System.out.println("1. Satchel \n2. Energy Potion \n3. Half Energy Potion \n4. Phoenix Down");
                System.out.println("5. Battle Axe \n6. Long Sword \n7. Short Sword \n8. Leather Sandals \n9. Bomb \n10. Exit");
                int choice = kbReader.nextInt(); 
                if(choice == 1){
                    System.out.println("The Satchel can hold up to 9 items, and will cost two hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt(); 
                    if(pick == 1){
                        if(hiroCurrency >= 2){
                            System.out.println("You've purchased the satchel.");
                            System.out.println("You can now hold 7 extra items.");
                            hiro.setInventory(satchel);
                            hiro.setTotalCurrency(-2);
                            System.out.println("You have been returned to the menu. \n");
                        }
                        else{
                            System.out.println("You don't have enough hide for the satchel.");
                            System.out.println("Hide: " + hiro.getTotalCurrency());
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 2){
                    System.out.println("An energy potion can return up to 100 health points, and will cost two hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt(); 
                    if(pick == 1){
                        if(hiro.getInventory().getInventoryName() == "Pants"){
                            if(hiro.getInventory().getCurrentInventorySize() < 2){
                                if(hiroCurrency >= 2){
                                    System.out.println("You bought an Energy Potion");
                                    System.out.println("With it, you can reset your health to 100 by pressing the \"p\" key.");
                                    hiro.setEnergyPotion(1);
                                    hiro.getInventory().setCurrentInventorySize(1);
                                    hiro.setTotalCurrency(-2);
                                    System.out.println("You have been returned to the menu. \n");
                                }
                                else{
                                    System.out.println("You dont have enough hide to purchase an Energy Potion.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 2){
                                System.out.println("Your inventory is currently full.");
                                menu = false;
                            }
                        }
                        else if(hiro.getInventory().getInventoryName() == "Satchel"){
                            if(hiro.getInventory().getCurrentInventorySize() < 9){
                                if(hiroCurrency >= 2){
                                    System.out.println("You've purchased an Energy Potion.");
                                    System.out.println("With it, you can reset your health to 100 by pressing the \"p\" key.");
                                    hiro.setEnergyPotion(1);
                                    hiro.getInventory().setCurrentInventorySize(1);
                                    hiro.setTotalCurrency(-2);
                                }
                                else{
                                    System.out.println("You don't have enough hide for an Energy Potion.");
                                    System.out.println("Currency: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 9){
                                System.out.println("Your inventory is full.");
                                menu = false;
                            }
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 3){
                    System.out.println("A half energy potion can return up to 50 health points, and will cost one hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt(); 
                    if(pick == 1){
                        if(hiro.getInventory().getInventoryName() == "Pants"){
                            if(hiro.getInventory().getCurrentInventorySize() < 2){
                                if(hiroCurrency >= 1){
                                    System.out.println("You've purchased a Half Energy Potion.");
                                    System.out.println("With it, you can reset your health to 100 by pressing the \"p\" key.");
                                    hiro.setHalfEnergyPotion(1);
                                    hiro.getInventory().setCurrentInventorySize(1);
                                    hiro.setTotalCurrency(-1);
                                }
                                else{
                                    System.out.println("You don't have enough hide for the Half Energy Potion.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 2){
                                System.out.println("Your inventory is currently full.");
                                menu = false;
                            }
                        }
                        else if(hiro.getInventory().getInventoryName() == "Satchel"){
                            if(hiro.getInventory().getCurrentInventorySize() < 9){
                                if(hiroCurrency >= 1){
                                    System.out.println("You've purchased a Half Energy Potion.");
                                    System.out.println("With it, you can reset your health to 100 by pressing the \"p\" key.");
                                    hiro.setHalfEnergyPotion(1);
                                    hiro.getInventory().setCurrentInventorySize(1);
                                    hiro.setTotalCurrency(-1);
                                }
                                else{
                                    System.out.println("You don't have enough hide for the Half Energy Potion.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 9){
                                System.out.println("Your inventory is full");
                                menu = false;
                            }
                        }
                        else if(pick == 2){
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                }
                else if(choice == 4){
                    System.out.println("A Phoenix Potion automatically revives a hero from death, and costs three hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt();
                    if(pick == 1){
                        if(hiro.getInventory().getInventoryName() == "Pants"){
                            if(hiro.getInventory().getCurrentInventorySize() < 2){
                                if(hiroCurrency >= 3){
                                    System.out.println("You've purchased a Phoenix Potion.");
                                    System.out.println("You will now be revived when you die.");
                                    hiro.setPhoenixPotion(1);
                                    hiro.setTotalCurrency(-3);
                                }
                                else{
                                    System.out.println("You don't have enough hide for the Phoenix Potion.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 2){
                                System.out.println("Your inventory is full.");
                                menu = false;
                            }
                        }
                        else if(hiro.getInventory().getInventoryName() == "Satchel"){
                            if(hiro.getInventory().getCurrentInventorySize() < 9){
                                if(hiroCurrency >= 3){
                                    System.out.println("You've purchased a Phoenix Potion.");
                                    System.out.println("You will now be revived when you die.");
                                    hiro.setPhoenixPotion(1);
                                    hiro.setTotalCurrency(-3);
                                }
                                else{
                                    System.out.println("You don't have enough hide for the Phoenix Potion.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 9){
                                System.out.println("Your inventory is full.");
                                menu = false;
                            }
                        }
                        else if(pick == 2){
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                }
                else if(choice == 5){
                    System.out.println("The Battle Axe deals alot of damage, but can only attack once every other turn.");
                    System.out.println("It is expensive and hard to find, but I'll give it to you for only five hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt();
                    if(pick == 1){
                        if(hiroCurrency >= 5){
                            System.out.println("You've purchased the Battle Axe.");
                            System.out.println("Your weapon has been replaced with the Battle Axe!");
                            hiro.setWeapon(battleAxe);
                            hiro.setTotalCurrency(-5);
                        }
                        else{
                            System.out.println("You don't have enough hide for the Battle Axe.");
                            System.out.println("Hide: " + hiro.getTotalCurrency());
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 6){
                    System.out.println("The Long Sword deals a great amount of damage and is guaranteed to attack each round."); 
                    System.out.println("It's forging process was long, but it would only cost six hide to purchase.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt(); 
                    if(pick == 1){
                        if(hiroCurrency >= 6){
                            System.out.println("You've purchased the Long Sword.");
                            System.out.println("Your previous weapon has been replaced by the Long Sword");
                            hiro.setWeapon(longSword);
                            hiro.setTotalCurrency(-6);
                        }
                        else{
                            System.out.println("You don't have enough hide for the Long Sword.");
                            System.out.println("Hide: " + hiro.getTotalCurrency());
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 7){
                    System.out.println("The Short Sword deals a good amount of damage and is guaranteed to attack each round."); 
                    System.out.println("It's forging process was decent in length, so it would only cost four hide to purchase.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt();  
                    if(pick == 1){
                        if(hiroCurrency >= 4){
                            System.out.println("You've purchased the Short Sword.");
                            System.out.println("Your previous weapon has been replaced by the Short Sword.");
                            hiro.setWeapon(shortSword);
                            hiro.setTotalCurrency(-4);
                        }
                        else{
                            System.out.println("You don't have enough hide for the Short Sword.");
                            System.out.println("Hide: " + hiro.getTotalCurrency());
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 8){
                    System.out.println("Leather sandals increase your speed, and give you the ability to attack twice in one turn.");
                    System.out.println("Due to how long and harsh the building process is, these sandals will cost 6 hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt();
                    if(pick == 1){
                        if(hiroCurrency >= 6){
                            System.out.println("You've purchased the Leather Sandals.");
                            System.out.println("The leather Sandals have now been equipt.");
                            hiro.setSandal(leatherSandal);
                            hiro.setTotalCurrency(-6);
                        }
                        else{
                            System.out.println("You don't have enough hide for the Leather Sandals.");
                            System.out.println("Hide: " + hiro.getTotalCurrency());
                            System.out.println("You have been returned to the menu. \n");
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 9){
                    System.out.println("A bomb can instantly kill any enemy. Due to it's extreme power, it has been priced at 4 hide.");
                    System.out.println("Would you like to purchase it?\n1. Yes\n2. No");
                    int pick = kbReader.nextInt();
                    if(pick == 1){
                        if(hiro.getInventory().getInventoryName() == "Pants"){
                            if(hiro.getInventory().getCurrentInventorySize() < 2){
                                if(hiroCurrency >= 4){
                                    System.out.println("You've purchased a bomb.");
                                    System.out.println("It is now being stored in your inventory.");
                                    hiro.setBombPotion(1);
                                    hiro.getInventory().setCurrentInventorySize(1);
                                    hiro.setTotalCurrency(-4);
                                }
                                else{
                                    System.out.println("You don't have enough hide for a bomb.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 2){
                                System.out.println("Your inventory is full.");
                                menu = false;
                            }
                        }
                        else if(hiro.getInventory().getInventoryName() == "Satchel"){
                            if(hiro.getInventory().getCurrentInventorySize() < 9){
                                if(hiroCurrency >= 4){
                                    System.out.println("You've purchased a bomb.");
                                    System.out.println("It is now being stored in your inventory.");
                                    hiro.setBombPotion(1);
                                    hiro.getInventory().setCurrentInventorySize(1);
                                    hiro.setTotalCurrency(-4);
                                }
                                else{
                                    System.out.println("You don't have enough hide for a bomb.");
                                    System.out.println("Hide: " + hiro.getTotalCurrency());
                                    System.out.println("You have been returned to the menu. \n");
                                }
                            }
                            else if(hiro.getInventory().getCurrentInventorySize() >= 9){
                                System.out.println("Your inventory is full.");
                                menu = false;
                            }
                        }
                    }
                    else if(pick == 2){
                        System.out.println("You have been returned to the menu. \n");
                    }
                }
                else if(choice == 10){
                    System.out.println("You have exited the menu.");
                    menu = false;
                }
                else{
                    System.out.println("Incorrect input. Please select a number from one to ten.");
                }
            }
        }
    }

    public boolean getFirstFarmer(){
        return firstFarmer;
    }

    public String getFarmerName(){
        return name;
    }

    public void setFarmerName(String newName){
        name = newName;
    }

    public int getQuest(){
        return quest;
    }

    public int getyPosFarmer(){
        return yPosFarmer;
    }

    public void setyPosFarmer(int newYPos){
        yPosFarmer = newYPos;
    }

    public int getxPosFarmer(){
        return xPosFarmer;
    }

    public void setxPosFarmer(int newXPos){
        xPosFarmer = newXPos;
    }

    public boolean getFirstBossAlive(){
        return firstBossAlive;
    }

    public boolean getSecondBossAlive(){
        return secondBossAlive;
    }

    public boolean getThirdBossAlive(){
        return thirdBossAlive;
    }
}