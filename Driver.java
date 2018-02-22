import java.io.*;
import java.util.*; 
public class Driver{
    public static void moveHero(Hero hiro, int xPosIncrement, int yPosIncrement){
        hiro.setX(xPosIncrement);//left or right
        hiro.setY(yPosIncrement);//up or down
    }

    public static void main(String args[]){
        Weapon dagger = new Weapon("Dagger", 10 ,30, 1);
        Weapon shortSword = new Weapon("Short Sword", 40, 60, 1);
        Weapon longSword = new Weapon("Long Sword", 75, 100, 1);
        Weapon battleAxe = new Weapon("Battle Axe", 150, 175, 2);
        Armor skin = new Armor("No Armor", 0);
        Armor bronzeArmor = new Armor("Bronze Armor", 1);
        Sandal noSandal = new Sandal("No Sandal", 0);
        EnergyPotion energyPotion = new EnergyPotion("Energy Potion", -4, -4);
        HalfEnergyPotion halfEnergyPotion = new HalfEnergyPotion("Half Energy Potion", -4, -5);

        Sandal leatherSandal = new Sandal("Leather Sandal", 1);
        Inventory defaultInv = new Inventory("Pants", 2, 0);
        Inventory satchel = new Inventory("Satchel", 9, 2);
        boolean firstFarmerFound = false;
        boolean runGame = true;

        Hero hiro = new Hero(0, 14, 100, dagger, skin, false, 0, defaultInv, (int) (Math.random() * 5), noSandal, 0);
        Object[][] map = new Object[15][15];
        map[hiro.getyPos()][hiro.getxPos()] = hiro;

        int xPosEnergyPotion1 = (int) (Math.random() * 15);
        int yPosEnergyPotion1 = (int) (Math.random() * 15);

        while(map[yPosEnergyPotion1][xPosEnergyPotion1] != null){
            xPosEnergyPotion1 = ((int) (Math.random() * 15));
            yPosEnergyPotion1 = ((int) (Math.random() * 15));
        }
        EnergyPotion EnergyPotion1 = new EnergyPotion("Energy Potion", xPosEnergyPotion1, yPosEnergyPotion1);

        map[EnergyPotion1.getyPosPotion()][EnergyPotion1.getxPosPotion()] = EnergyPotion1;

        MapFarmer mapFarmer = new MapFarmer("X", -1, -1, 0);

        int xPosEnergyPotion2 = (int) (Math.random() * 15);
        int yPosEnergyPotion2 = (int) (Math.random() * 15);

        while(map[yPosEnergyPotion2][xPosEnergyPotion2] != null){
            xPosEnergyPotion2 = ((int) (Math.random() * 15));
            yPosEnergyPotion2 = ((int) (Math.random() * 15));
        }
        EnergyPotion EnergyPotion2 = new EnergyPotion("Energy Potion", xPosEnergyPotion2, yPosEnergyPotion2);

        map[EnergyPotion2.getyPosPotion()][EnergyPotion2.getxPosPotion()] = EnergyPotion2;

        int xPosHalfEnergyPotion1 = (int) (Math.random() * 15);
        int yPosHalfEnergyPotion1 = (int) (Math.random() * 15);

        while(map[yPosHalfEnergyPotion1][xPosHalfEnergyPotion1] != null){
            xPosHalfEnergyPotion1 = ((int) (Math.random() * 15));
            yPosHalfEnergyPotion1 = ((int) (Math.random() * 15));
        }
        HalfEnergyPotion HalfEnergyPotion1 = new HalfEnergyPotion("Half Energy Potion", xPosHalfEnergyPotion1, yPosHalfEnergyPotion1);

        map[HalfEnergyPotion1.getyPosPotion()][HalfEnergyPotion1.getxPosPotion()] = HalfEnergyPotion1;

        int xPosHalfEnergyPotion2 = (int) (Math.random() * 15);
        int yPosHalfEnergyPotion2 = (int) (Math.random() * 15);

        while(map[yPosHalfEnergyPotion2][xPosHalfEnergyPotion2] != null){
            xPosHalfEnergyPotion2 = ((int) (Math.random() * 15));
            yPosHalfEnergyPotion2 = ((int) (Math.random() * 15));
        }
        HalfEnergyPotion HalfEnergyPotion2 = new HalfEnergyPotion("Half Energy Potion", xPosHalfEnergyPotion2, yPosHalfEnergyPotion2);

        map[HalfEnergyPotion2.getyPosPotion()][HalfEnergyPotion2.getxPosPotion()] = HalfEnergyPotion2;

        /*int xPosMapFarmer1 = (int) (Math.random() * 15);
        int yPosMapFarmer1 = (int) (Math.random() * 15);*/

        /* while(map[yPosfarmer1][xPosfarmer1] != null){
        xPosfarmer1 = ((int) (Math.random() * 15));
        yPosfarmer1 = ((int) (Math.random() * 15));
        }
        Farmer farmer1 = new Farmer("Farmer 1", xPosfarmer1, yPosfarmer1, 2, sword, null);

        map[farmer1.getyPosFarmer()][farmer1.getxPosFarmer()] = farmer1;
         */

        /*
        int xPosMonster2 = ((int) (Math.random() * 15));
        int yPosMonster2 = ((int) (Math.random() * 15));

        while(map[yPosMonster2][xPosMonster2] != null){
        xPosMonster2 = ((int) (Math.random() * 15));
        yPosMonster2 = ((int) (Math.random() * 15));
        }
        Monster m2 = new Monster(xPosMonster2, yPosMonster2,
        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0);

        map[m2.getyPosMonster()][m2.getxPosMonster()] = m2;

        int xPosMonster3 = ((int) (Math.random() * 15));
        int yPosMonster3 = ((int) (Math.random() * 15));

        while(map[yPosMonster3][xPosMonster3] != null){
        xPosMonster3 = ((int) (Math.random() * 15));
        yPosMonster3 = ((int) (Math.random() * 15));
        }
        Monster m3 = new Monster(xPosMonster3, yPosMonster3,
        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0);

        map[m3.getyPosMonster()][m3.getxPosMonster()] = m3;

        int xPosMonster4 = ((int) (Math.random() * 15));
        int yPosMonster4 = ((int) (Math.random() * 15));

        while(map[yPosMonster4][xPosMonster4] != null){
        xPosMonster4 = ((int) (Math.random() * 15));
        yPosMonster4 = ((int) (Math.random() * 15));
        }
        Monster m4 = new Monster(xPosMonster4, yPosMonster4,
        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0, 3);

        map[m4.getyPosMonster()][m4.getxPosMonster()] = m4;

        int xPosMonster5 = ((int) (Math.random() * 15));
        int yPosMonster5 = ((int) (Math.random() * 15));

        while(map[yPosMonster5][xPosMonster5] != null){
        xPosMonster5 = ((int) (Math.random() * 15));
        yPosMonster5 = ((int) (Math.random() * 15));
        }
        Monster m5 = new Monster(xPosMonster5, yPosMonster5,
        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0);

        map[m5.getyPosMonster()][m5.getxPosMonster()] = m5;

        int xPosMonster6 = ((int) (Math.random() * 15));
        int yPosMonster6 = ((int) (Math.random() * 15));

        while(map[yPosMonster6][xPosMonster6] != null){
        xPosMonster6 = ((int) (Math.random() * 15));
        yPosMonster6 = ((int) (Math.random() * 15));
        }
        Monster m6 = new Monster(xPosMonster6, yPosMonster6,
        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0);

        map[m6.getyPosMonster()][m6.getxPosMonster()] = m6;
         */

        System.out.println("** Hero & Monsters **\n");
        System.out.println("* The map has been generated *");
        System.out.println("* The enemies have been placed *");
        System.out.println("* The items have been placed *\n");
        System.out.println("Hero begins his journey in the Southwest corner of the monster-ridden city of Fiona.");
        System.out.println("It is your job to free the land of these tyrannical infectious villains!");
        System.out.println("Start by fending off monsters, and then looking for the farmer whom you need to interact with.");

        while(runGame)
        {
            if(hiro.getFarmerHasMap() == true){
                int xPosBossFarmer1 = (int) (Math.random() * 15);
                int yPosBossFarmer1 = (int) (Math.random() * 15);

                while(map[yPosBossFarmer1][xPosBossFarmer1] != null){
                    xPosBossFarmer1 = ((int) (Math.random() * 15));
                    yPosBossFarmer1 = ((int) (Math.random() * 15));
                }
                BossFarmer bossFarmer1 = new BossFarmer("BF1", xPosBossFarmer1, yPosBossFarmer1, 1);

                map[bossFarmer1.getyPosFarmer()][bossFarmer1.getxPosFarmer()] = bossFarmer1;

                int xPosBossFarmer2 = (int) (Math.random() * 15);
                int yPosBossFarmer2 = (int) (Math.random() * 15);

                while(map[yPosBossFarmer2][xPosBossFarmer2] != null){
                    xPosBossFarmer2 = ((int) (Math.random() * 15));
                    yPosBossFarmer2 = ((int) (Math.random() * 15));
                }
                BossFarmer bossFarmer2 = new BossFarmer("BF2", xPosBossFarmer2, yPosBossFarmer2, 2);

                map[bossFarmer2.getyPosFarmer()][bossFarmer2.getxPosFarmer()] = bossFarmer2;

                int xPosBossFarmer3= (int) (Math.random() * 15);
                int yPosBossFarmer3= (int) (Math.random() * 15);

                while(map[yPosBossFarmer3][xPosBossFarmer3] != null){
                    xPosBossFarmer3 = ((int) (Math.random() * 15));
                    yPosBossFarmer3 = ((int) (Math.random() * 15));
                }
                BossFarmer bossFarmer3 = new BossFarmer("BF3", xPosBossFarmer3, yPosBossFarmer3, 3);

                map[bossFarmer3.getyPosFarmer()][bossFarmer3.getxPosFarmer()] = bossFarmer3;

                int xPosStoreFarmer = (int) (Math.random() * 15);
                int yPosStoreFarmer = (int) (Math.random() * 15);

                while(map[yPosStoreFarmer][xPosStoreFarmer] != null){
                    xPosStoreFarmer = ((int) (Math.random() * 15));
                    yPosStoreFarmer = ((int) (Math.random() * 15));
                }
                StoreFarmer storeFarmer = new StoreFarmer("SF", xPosStoreFarmer, yPosStoreFarmer, 4, battleAxe, shortSword, longSword, energyPotion, halfEnergyPotion, satchel, leatherSandal);

                map[storeFarmer.getyPosFarmer()][storeFarmer.getxPosFarmer()] = storeFarmer;
                hiro.setFarmerHasMap(false);
            }

            if(hiro.getFirstBoss() == true){
                int xPosBoss1 = (int) (Math.random() * 15);
                int yPosBoss1 = (int) (Math.random() * 15);

                while(map[yPosBoss1][xPosBoss1] != null){
                    xPosBoss1 = ((int) (Math.random() * 15));
                    yPosBoss1 = ((int) (Math.random() * 15));
                }
                BossMonster b1 = new BossMonster(xPosBoss1, yPosBoss1,
                        ((int) (Math.random() * 30) + 1), ((int) (Math.random() * 100) + 1), 1);

                map[b1.getyPosMonster()][b1.getxPosMonster()] = b1;
                hiro.setFirstBoss(false);
            }

            if(hiro.getFirstBossDefeated() == true){
                int xPosBoss2 = (int) (Math.random() * 15);
                int yPosBoss2 = (int) (Math.random() * 15);

                while(map[yPosBoss2][xPosBoss2] != null){
                    xPosBoss2 = ((int) (Math.random() * 15));
                    yPosBoss2 = ((int) (Math.random() * 15));
                }
                BossMonster b2 = new BossMonster(xPosBoss2, yPosBoss2,
                        ((int) (Math.random() * 30) + 1), ((int) (Math.random() * 100) + 1), 2);

                map[b2.getyPosMonster()][b2.getxPosMonster()] = b2;
                hiro.setFirstBossDefeated(false);
            }

            if(hiro.getSecondBossDefeated() == true){
                int xPosBoss3 = (int) (Math.random() * 15);
                int yPosBoss3 = (int) (Math.random() * 15);

                while(map[yPosBoss3][xPosBoss3] != null){
                    xPosBoss3 = ((int) (Math.random() * 15));
                    yPosBoss3 = ((int) (Math.random() * 15));
                }
                BossMonster b3 = new BossMonster(xPosBoss3, yPosBoss3,
                        ((int) (Math.random() * 30) + 1), ((int) (Math.random() * 100) + 1), 3);

                map[b3.getyPosMonster()][b3.getxPosMonster()] = b3;
                hiro.setSecondBossDefeated(false);
            }

            int heroDirection;//1 = north, 2 = south, 3 = east, 4 = west
            printMap(map, hiro);
            System.out.println("Health: " + hiro.getHealth() + "\nWeapon: " + hiro.getWeaponName() + "\nEnergy Potions: " + hiro.getEnergyPotion() + "\nHalf Energy Potion: " + hiro.getHalfEnergyPotion() + "\nPhoenix Down: " + hiro.getPhoenixPotion() + "\nBombs: " + hiro.getBombPotion() + "\nHide: " + hiro.getTotalCurrency());
            System.out.print("Enter a direction/Use potion (w,a,s,d,p): ");
            //System.out.println(hiro.getxPos() + ", " + hiro.getyPos());
            Scanner kbReader = new Scanner(System.in);
            String direction = kbReader.next( ); 
            System.out.println();
            if(hiro.validMove(direction)){
                if(direction.equals("p"))
                {
                    System.out.println("Which potion do you want to use?");
                    System.out.println("1. Energy Potion");
                    System.out.println("2. Half Energy Potion");
                    //phoenix potion is when hero dies
                    int potionChoice = kbReader.nextInt( ); 
                    if(potionChoice == 1){
                        if(hiro.getEnergyPotion() > 0){
                            EnergyPotion.usePotion(); //Energy potion = 100 health
                            hiro.setEnergyPotion(-1);
                            System.out.println("Your health is now 100 hp");
                            hiro.setFullHealth(100);
                        }
                        else if(hiro.getEnergyPotion() <= 0){
                            System.out.println("You dont have any full energy potions!");
                        }
                    }
                    else if(potionChoice == 2){
                        if(hiro.getHalfEnergyPotion() > 0){
                            HalfEnergyPotion.usePotion();
                            hiro.setHalfEnergyPotion(-1);
                            System.out.println("You have added 50 hp to your health.");
                            hiro.useHalfPotion();
                        }
                        else if(hiro.getHalfEnergyPotion() <= 0){
                            System.out.println("You dont have any half energy potions!");
                        }
                    }
                    else{
                        System.out.println("Please choose between the numbers 1 and 2.");
                    }
                }
                else if(direction.equals("a"))
                {
                    Object o = map[hiro.getyPos()][hiro.getxPos() - 1];// pull object from map right hiro
                    hiro.setHeroDirection(4);//west

                    if(o == null){ 
                        moveHero(hiro, -1, 0); 
                        map[hiro.getyPos()][hiro.getxPos() + 1] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;

                        if(Math.random() < .2){//20% chance of finding a monster

                            while(map[hiro.getyPos()][hiro.getxPos() - 1] == null)
                            {
                                LowMonster lowMonster = new LowMonster((hiro.getxPos() - 1), hiro.getyPos(),
                                        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0, (int) (Math.random() * 5));

                                map[hiro.getyPos()][hiro.getxPos() - 1] = lowMonster;
                                break;
                            }
                        }
                        else if(Math.random() >= .2 && Math.random() <= .4 && firstFarmerFound == false){//20% chance of finding a monster

                            while(map[hiro.getyPos()][hiro.getxPos() - 1] == null)
                            {
                                mapFarmer.setFarmerName("F");
                                mapFarmer.setxPosFarmer((hiro.getxPos() - 1));
                                mapFarmer.setyPosFarmer(hiro.getyPos());

                                //new MapFarmer("F1", (hiro.getxPos() - 1), hiro.getyPos(), 0);

                                map[hiro.getyPos()][hiro.getxPos() - 1] = mapFarmer;
                                firstFarmerFound = true;
                                break;
                            }
                        }
                    }
                    else if(o instanceof EnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setEnergyPotion(1);
                        System.out.println("Full energy potions: " + hiro.getEnergyPotion());
                        moveHero(hiro, -1, 0); 
                        map[hiro.getyPos()][hiro.getxPos() + 1] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof HalfEnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setHalfEnergyPotion(1);
                        System.out.println("Half energy potions: " + hiro.getHalfEnergyPotion());
                        moveHero(hiro, -1, 0); 
                        map[hiro.getyPos()][hiro.getxPos() + 1] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof Farmer)
                    {
                        Farmer f = (Farmer) o;

                        f.interact(hiro);
                        if(f.getQuest() == 0){
                            moveHero(hiro, -1, 0); 
                            map[hiro.getyPos()][hiro.getxPos() + 1] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof LowMonster)
                    {
                        LowMonster m = (LowMonster) o;

                        m.interact(hiro);
                        if(m.getEscape() != 1){
                            moveHero(hiro, -1, 0); 
                            map[hiro.getyPos()][hiro.getxPos() + 1] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof BossMonster)
                    {
                        BossMonster m = (BossMonster) o;

                        m.interact(hiro);
                        if(m.getEscape() != 1){
                            moveHero(hiro, -1, 0); 
                            map[hiro.getyPos()][hiro.getxPos() + 1] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                }
                else if(direction.equals("w"))
                {
                    Object o = map[hiro.getyPos() - 1][hiro.getxPos()];// pull object from map above hiro  
                    hiro.setHeroDirection(1);//north
                    if(o == null){ 
                        moveHero(hiro, 0, -1); 
                        map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;

                        if(Math.random() < .2){//20% chance of finding a monster

                            while(map[hiro.getyPos() - 1][hiro.getxPos()] == null)
                            {
                                LowMonster lowMonster = new LowMonster((hiro.getxPos()), hiro.getyPos() - 1,
                                        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0, (int) (Math.random() * 5));

                                map[hiro.getyPos() - 1][hiro.getxPos()] = lowMonster;
                                break;
                            }
                        }else if(Math.random() >= .2 && Math.random() <= .4 && firstFarmerFound == false){//20% chance of finding a monster

                            while(map[hiro.getyPos() - 1][hiro.getxPos()] == null)
                            {
                                mapFarmer.setFarmerName("F");
                                mapFarmer.setxPosFarmer((hiro.getxPos()));
                                mapFarmer.setyPosFarmer(hiro.getyPos() - 1);

                                //new MapFarmer("F1", (hiro.getxPos() - 1), hiro.getyPos(), 0);

                                map[hiro.getyPos() - 1][hiro.getxPos()] = mapFarmer;
                                firstFarmerFound = true;
                                break;
                            }
                        }
                    }
                    else if(o instanceof EnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setEnergyPotion(1);
                        System.out.println("Full energy potions: " + hiro.getEnergyPotion());
                        moveHero(hiro, 0, -1); 
                        map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof HalfEnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setHalfEnergyPotion(1);
                        System.out.println("half energy potions: " + hiro.getHalfEnergyPotion());
                        moveHero(hiro, 0, -1); 
                        map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof Farmer)
                    {
                        Farmer f = (Farmer) o;

                        f.interact(hiro);
                        if(f.getQuest() == 0){
                            moveHero(hiro, 0, -1); 
                            map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof LowMonster)
                    {
                        LowMonster m = (LowMonster) o;
                        m.interact(hiro);

                        if(m.getEscape() != 1){
                            moveHero(hiro, 0, -1); 
                            map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof BossMonster)
                    {
                        BossMonster m = (BossMonster) o;
                        m.interact(hiro);

                        if(m.getEscape() != 1){
                            moveHero(hiro, 0, -1); 
                            map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                }
                else if(direction.equals("d"))
                {
                    Object o = map[hiro.getyPos()][hiro.getxPos() + 1];// pull object from map right hiro
                    hiro.setHeroDirection(3);//east
                    if(o == null){ 

                        moveHero(hiro, 1, 0); 
                        map[hiro.getyPos() ][hiro.getxPos()- 1] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;

                        if(Math.random() < .2){//20% chance of finding a monster

                            while(map[hiro.getyPos()][hiro.getxPos() + 1] == null)
                            {
                                LowMonster lowMonster = new LowMonster((hiro.getxPos() + 1), hiro.getyPos(),
                                        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0, (int) (Math.random() * 5));

                                map[hiro.getyPos()][hiro.getxPos() + 1] = lowMonster;
                                break;
                            }
                        }else if(Math.random() >= .2 && Math.random() <= .4 && firstFarmerFound == false){//20% chance of finding a monster

                            while(map[hiro.getyPos()][hiro.getxPos() + 1] == null)
                            {
                                mapFarmer.setFarmerName("F");
                                mapFarmer.setxPosFarmer((hiro.getxPos() + 1));
                                mapFarmer.setyPosFarmer(hiro.getyPos());

                                //new MapFarmer("F1", (hiro.getxPos() - 1), hiro.getyPos(), 0);

                                map[hiro.getyPos()][hiro.getxPos() + 1] = mapFarmer;
                                firstFarmerFound = true;
                                break;
                            }
                        }
                    }
                    else if(o instanceof EnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setEnergyPotion(1);
                        System.out.println("Full Energy Potions: " + hiro.getEnergyPotion());
                        moveHero(hiro, 1, 0); 
                        map[hiro.getyPos()][hiro.getxPos() - 1] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof HalfEnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setHalfEnergyPotion(1);
                        System.out.println("Half Energy Potions: " + hiro.getHalfEnergyPotion());
                        moveHero(hiro, 1, 0); 
                        map[hiro.getyPos()][hiro.getxPos() - 1] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof Farmer)
                    {
                        Farmer f = (Farmer) o;

                        f.interact(hiro);
                        if(f.getQuest() == 0){
                            moveHero(hiro, 0, -1); 
                            map[hiro.getyPos() + 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof LowMonster)
                    {
                        LowMonster m = (LowMonster) o;
                        m.interact(hiro);

                        if(m.getEscape() != 1){
                            moveHero(hiro, 1, 0); 
                            map[hiro.getyPos()][hiro.getxPos() - 1] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof BossMonster)
                    {
                        BossMonster m = (BossMonster) o;
                        m.interact(hiro);

                        if(m.getEscape() != 1){
                            moveHero(hiro, 1, 0); 
                            map[hiro.getyPos()][hiro.getxPos() - 1] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                }
                else if(direction.equals("s"))
                {
                    Object o = map[hiro.getyPos()+1][hiro.getxPos()];// pull object from map below hiro
                    hiro.setHeroDirection(2);//south
                    if(o == null){ 
                        moveHero(hiro, 0, 1); 
                        map[hiro.getyPos() - 1][hiro.getxPos()] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;

                        if(Math.random() < .2){//20% chance of finding a monster

                            while(map[hiro.getyPos() + 1][hiro.getxPos()] == null)
                            {
                                LowMonster lowMonster = new LowMonster((hiro.getxPos()), hiro.getyPos() + 1,
                                        ((int) (Math.random() * 30) + 1), (int) (Math.random() * 100) + 1, (int) (Math.random() * 3) + 0, (int) (Math.random() * 5));

                                map[hiro.getyPos() + 1][hiro.getxPos()] = lowMonster;
                                break;
                            }
                        }else if(Math.random() >= .2 && Math.random() <= .4 && firstFarmerFound == false){//20% chance of finding a monster

                            while(map[hiro.getyPos() + 1][hiro.getxPos()] == null)
                            {
                                mapFarmer.setFarmerName("F");
                                mapFarmer.setxPosFarmer((hiro.getxPos()));
                                mapFarmer.setyPosFarmer(hiro.getyPos() + 1);

                                //new MapFarmer("F1", (hiro.getxPos() - 1), hiro.getyPos(), 0);

                                map[hiro.getyPos() + 1][hiro.getxPos()] = mapFarmer;
                                firstFarmerFound = true;
                                break;
                            }
                        }
                    }
                    else if(o instanceof EnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setEnergyPotion(1);
                        System.out.println("Full energy potions: " + hiro.getEnergyPotion());
                        moveHero(hiro, 0, 1); 
                        map[hiro.getyPos() - 1][hiro.getxPos()] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof HalfEnergyPotion)
                    {
                        /*Potion p = (Potion) o;
                        p.interact(hiro);*/
                        hiro.setHalfEnergyPotion(1);
                        System.out.println("half energy potions: " + hiro.getHalfEnergyPotion());
                        moveHero(hiro, 0, 1); 
                        map[hiro.getyPos() - 1][hiro.getxPos()] = null;
                        map[hiro.getyPos()][hiro.getxPos()] = hiro;
                    }
                    else if(o instanceof Farmer)
                    {
                        Farmer f = (Farmer) o;

                        f.interact(hiro);
                        if(f.getQuest() == 0){
                            moveHero(hiro, 0, 1); 
                            map[hiro.getyPos() - 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof LowMonster)
                    {
                        LowMonster m = (LowMonster) o;
                        m.interact(hiro);

                        if(m.getEscape() != 1){
                            moveHero(hiro, 0, 1); 
                            map[hiro.getyPos() - 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                    else if(o instanceof BossMonster)
                    {
                        BossMonster m = (BossMonster) o;
                        m.interact(hiro);

                        if(m.getEscape() != 1){
                            moveHero(hiro, 0, 1); 
                            map[hiro.getyPos() - 1][hiro.getxPos()] = null;
                            map[hiro.getyPos()][hiro.getxPos()] = hiro;
                        }
                    }
                }
            }
            else{
                System.out.println("error");
            }

            if(hiro.getThirdBossDefeated() == true){
                int counter = 0;
                counter++;
                if(counter == 1){
                    System.out.println("By killing all of the bosses, you have forced all of the monsters to surrender and flee!");
                    counter++;
                }else if(counter == 2){
                    System.out.println("Congratulations on completeing the game!!");
                    runGame = false;
                    counter = 0;
                }
            }

            if(hiro.getHealth() <= 0 && PhoenixPotion.getCountPotion() == 0){
                runGame = false;
            }else if(hiro.getHealth() <= 0 && PhoenixPotion.getCountPotion() >= 1){
                System.out.println("Your hero died, but was instantly revived by your Phoenix Down. \nYour health has been restored to full.");
                PhoenixPotion.usePotion(hiro);

            }
        }
    }

    public static void printMap(Object[][] map, Hero hiro){
        for(int i = 0; i < map.length; ++i)
        {
            for(int j = 0; j < map[0].length; ++j)
            {
                String s = new String();
                if(map[i][j] instanceof LowMonster){
                    if(hiro.getThirdBossDefeated() == true){
                        map[i][j] = null;
                    }else{
                        s = "  M";
                    }
                }
                else if(map[i][j] instanceof MapFarmer){
                    s = "  F";
                }
                else if(map[i][j] instanceof BossFarmer){
                    s = ((BossFarmer) map[i][j]).getFarmerName();
                }
                else if(map[i][j] instanceof BossMonster){
                    s = "  B";
                }
                else if(map[i][j] instanceof StoreFarmer){
                    s = " SF";
                }
                else if(map[i][j] instanceof EnergyPotion){
                    s = "  E";
                } 
                else if(map[i][j] instanceof HalfEnergyPotion){
                    s = "  e";
                } 
                else if(map[i][j] instanceof Hero){
                    s = "  H";
                }
                else if(map[i][j] == null){
                    s = "  _";
                }
                else{
                    s = "  a";
                }

                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
