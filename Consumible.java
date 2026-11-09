public class Consumible extends Item {
    private double curacion;

    public Consumible(String nombre, String descripcion, Rareza rareza, double valor, double curacion) {
        super(nombre, descripcion, rareza, valor);
        this.curacion = curacion;
    }

    public double getCuracion() { return curacion; }

    @Override 
    public void usar(Player jugador) {
        if (!jugador.getIsAlive()) {
            System.out.println(jugador.getName() + " está derrotado y no puede usar " + nombre);
            return;
        }
        jugador.setHp(jugador.getHp() + curacion);
        System.out.println(jugador.getName() + " usa " + nombre + ": recupera " + curacion
                + " de vida. Vida actual: " + jugador.getHp());
    }
}