public class Armadura extends Item{
    private double bonusDef;
    
    public Armadura(String nombre, String descripcion, int cantidad, Rareza rareza, double valor, double bonusDef) {
        super(nombre, descripcion, cantidad, 1, rareza, valor);
        this.bonusDef = bonusDef;
    }

    public double getBonusDef() { return bonusDef; }

    @Override 
    public void usar(Player jugador) {
        jugador.setDef(jugador.getDef() + bonusDef);
        System.out.println(jugador.getName() + " equipa " + nombre + ": defensa +" + bonusDef);
    }
}
