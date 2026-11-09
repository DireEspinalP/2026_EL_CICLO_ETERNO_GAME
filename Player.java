public class Player extends PJS implements Combate{
    // Atributos
    private double exp;
    private int lvl;
    private double maxhp;

    // Constructor
    public Player(String name ,double hp, double maxhp, double atk, double def, double exp, int lvl, boolean isAlive, double cash){  
        super(name,hp, atk, def, isAlive, cash); 
        this.exp = exp;
        this.maxhp = maxhp;
        this.lvl = lvl;
    }

    // Getters
    public double getMaxHp(){return maxhp;}
    public double getExp()  {return exp;}
    public int    getLvl()  {return lvl;}

    // Setters
    public void setMaxHp(double maxhp) {this.maxhp = maxhp;}
    public void setExp(double exp)     {this.exp = exp;}
    public void setLvl(int lvl)        {this.lvl = lvl;}

    // --- Métodos ---
    @Override     //Resta la vida(hp) con el daño recibido, si hp <= 0 entonces muere el jugador
    public void damage(double cant) {
        this.hp -= cant;
        if (this.hp <= 0) {
            this.hp = 0;
            this.isAlive = false; 
        }
        System.out.println("Recibistes " + cant + " de daño.");
        System.out.println("Vida restante: " + this.hp);
        if (this.isAlive == false) {
            System.out.println("El jugador " + this.name + " ha perecido");
        }
    }

    @Override     //Al atacar al enemigo, si muere, aparece el mensaje de entidad derrotada
    public void atack(Enemy objetivo) {
        if (!this.isAlive) {
            System.out.println("Entidad derrotada.");
            return;
        }
        atackEnemy(objetivo);
    }
        
    @Override //Muestra el nombre de quien lanza y recibe el ataque 
    public void atackEnemy(Enemy objetivo){
        System.out.println(this.name + " lanza un ataque a " + objetivo.getName());
        objetivo.damage(this.atk);  
    }

    @Override //probablemente no se use
    public void atackPlayer(Player objetivo){}

    @Override 
    public void stats(){
        System.out.println("--- Estadísticas ---");
        System.out.printf("Nombre: %15s\n", this.name);
        System.out.printf("Vida: %17.1f/%1.1f\n", this.hp, this.maxhp);
        System.out.printf("Ataque: %15.1f\n", this.atk);
        System.out.printf("Defensa: %14.1f\n", this.def);
        System.out.printf("Nivel: %16d\n", this.lvl);
    }
    
}
