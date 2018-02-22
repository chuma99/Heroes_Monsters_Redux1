public class Sandal
{
    private String nameSandal;
    private int LeatherSandal;//0 = doesnt have leather sandal; 1 = has leather sandal
    
    public Sandal(String nameSandal, int hasLeatherSandal)
    {
        this.nameSandal = nameSandal;
        this.LeatherSandal = hasLeatherSandal;
    }
    
    public String getNameSandal(){
        return nameSandal;
    }
    
    public int getLeatherSandal(){
        return LeatherSandal;
    }
}