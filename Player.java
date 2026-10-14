public class Player extends PJS {
    // Atributos
    private double exp;
    private int lvl;

    // Constructor
    public Player(String name ,double hp, double atk, double def, double exp, int lvl, boolean isAlive, double cash){  
        super(name,hp, atk, def, isAlive, cash); 
        this.exp = exp;
        this.lvl = lvl;
    }
    
    // getters
    public double getHp()  {return hp;}
    public double getAtk() {return atk;}
    public double getExp() {return exp;}
    public int    getLvl() {return lvl;}    
    public double getDef() {return def;}

    // setters
    public void setHp(double hp)   {this.hp = hp;}
    public void setAtk(double atk) {this.atk = atk;}
    public void setExp(double exp) {this.exp = exp;}
    public void setLvl(int lvl)    {this.lvl = lvl;}
    public void getDef(double def) {this.def = def;}

    // --- Métodos ---
    @Override     //Resta la vida(hp) con el daño recibido, si hp <= 0 entonces muere el objetivo 
    public void damage(double cant) {
        this.hp -= cant;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false; 
        }

        System.out.println("Recibistes " + cant + " de daño.");
        System.out.println("Vida restante: " + this.hp);
    }

    @Override     //Al atacar al enemigo, si muere, aparece el mensaje de entidad derrotada
    public void atack(Enemy objetivo) {
        if (!this.isAlive) {
            System.out.println("Entidad derrotada.");
            return;
        }

        //Muestra el nombre de quien lanza y recibe el ataque 
        System.out.println(this.name + " lanza un ataque a " + objetivo.getName());
        objetivo.damage(this.atk);

    }
    

    


}
