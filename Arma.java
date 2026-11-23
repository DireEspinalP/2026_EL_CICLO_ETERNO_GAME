public class Arma extends Item {
    private double bonusAtk;
    private boolean equipada;

    public Arma(String nombre, String descripcion, int cantidad, Rareza rareza, double valor, double bonusAtk) {
        super(nombre, descripcion, cantidad, 3, rareza, valor);
        this.bonusAtk = bonusAtk;
        this.equipada = false;
    }

    public double getBonusAtk() { return bonusAtk; }
    public boolean isEquipada() { return equipada; }
    public void setEquipada(boolean equipada) { this.equipada = equipada; }

    @Override 
    public void usar(Player jugador) {
        if (equipada) {
            System.out.println(nombre + " ya está equipada.");
            return;
        }
        jugador.setAtk(jugador.getAtk() + bonusAtk);
        equipada = true;
        System.out.println(jugador.getName() + " equipa " + nombre + ": ataque +" + bonusAtk);
    }
}