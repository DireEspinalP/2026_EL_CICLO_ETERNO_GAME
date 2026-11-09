public class Arma extends Item {
    private double bonusAtk;

    public Arma(String nombre, String descripcion, Rareza rareza, double valor, double bonusAtk) {
        super(nombre, descripcion, rareza, valor);
        this.bonusAtk = bonusAtk;
    }

    public double getBonusAtk() { return bonusAtk; }

    @Override 
    public void usar(Player jugador) {
        jugador.setAtk(jugador.getAtk() + bonusAtk);
        System.out.println(jugador.getName() + " equipa " + nombre + ": ataque +" + bonusAtk);
    }
}