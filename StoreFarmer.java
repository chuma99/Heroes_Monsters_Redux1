import java.io.*;
import java.util.*; 
public class StoreFarmer extends Farmer{
    Weapon battleAxe;
    Weapon shortSword;
    Weapon longSword;
    //Armor armors;
    EnergyPotion energyPotion;
    HalfEnergyPotion halfEnergyPotion;
    Inventory satchel;
    Sandal leatherSandal;
    public StoreFarmer(String farmerName, int xPos, int yPos, int quest, Weapon battleAxe, Weapon shortSword, Weapon longSword, EnergyPotion energyPotion, HalfEnergyPotion halfEnergyPotion, Inventory satchel, Sandal leatherSandal){
        super(farmerName, xPos, yPos, quest);
        this.battleAxe = battleAxe;
        this.shortSword = shortSword;
        this.longSword = longSword;
        this.energyPotion = energyPotion;
        this.halfEnergyPotion = halfEnergyPotion;
        this.satchel = satchel;
        this.leatherSandal = leatherSandal;
    }
}