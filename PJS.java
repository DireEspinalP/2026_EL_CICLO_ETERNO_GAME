public abstract class PJS{
    // Atributos
    protected String name;
    protected double hp;
    protected double atk;
    protected double def;
    protected boolean isAlive;
    protected double cash;
    
    // Constructor
    public PJS(String name,double hp, double atk, double def,  boolean isAlive, double cash){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.isAlive = isAlive;
        this.cash = cash;
    }

    // Getters
    public String getName()    {return name;}
    public double getHp()      {return hp;}
    public double getAtk()     {return atk;}
    public double getDef()     {return def;}
    public boolean getIsAlive(){return isAlive;}
    public double getCash()    {return cash;}

    // Setters
    public void setName(String name)       {this.name = name;}
    public void setHp(double hp)           {this.hp = hp;}
    public void setAtk(double atk)         {this.atk = atk;}        
    public void setDef(double def)         {this.def = def;}
    public void setIsAlive(boolean isAlive){this.isAlive = isAlive;}
    public void setCash(double cash)       {this.cash = cash;}

}

interface Combate{ // Interfaz de combate
    public void damage(double cant);
    default void atack(Enemy objetivo){};
    default void atack(Player objetivo){};
    default void stats(){};
}
