public class Inventory
{
    private String inventoryName;
    private int currentInventorySize;
    private int price;
    
    public Inventory(String inventoryName, int inventorySize, int price)
    {
        this.inventoryName = inventoryName;
        this.currentInventorySize = inventorySize;
        this.price = price;
    }
    
    public String getInventoryName(){
        return inventoryName;
    }
    
    public int getCurrentInventorySize(){
        return currentInventorySize;
    }
    
    public void setCurrentInventorySize(int x){
        currentInventorySize += x;
    }
}