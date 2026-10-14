public class PJS{
    // Atributos
    protected double hp;
    protected double atk;
    protected String name;
    protected boolean isAlive;
    protected double cash;
    protected double def;
    
    // Constructor
    public PJS(String name,double hp, double atk, double def,  boolean isAlive, double cash){
        this.hp = hp;
        this.atk = atk;
        this.name = name;
        this.isAlive = isAlive;
        this.cash = cash;
        this.def = def;
    }

    // Getters
    public double getHp()      {return hp;}
    public double getAtk()     {return atk;}
    public String getName()    {return name;}
    public boolean getIsAlive(){return isAlive;}
    public double getCash()    {return cash;}

    // Setters
    public void setHp(double hp)           {this.hp = hp;}
    public void setAtk(double atk)         {this.atk = atk;}        
    public void setName(String name)       {this.name = name;}
    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}
    public void setCash(double cash)       {this.cash = cash;}

    public void damage(double cant){}
    public void atack(Enemy objetivo){}
    public void atack(Player objetivo){}
}
