public abstract class Item {
    protected String nombre;
    protected String descripcion;
    private Rareza rareza;
    private double valor;

    public Item(String nombre, String descripcion, Rareza rareza, double valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rareza = rareza;
        this.valor = valor;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Rareza getRareza() { return rareza; }
    public double getValor() { return valor; }


    public abstract void usar(Player jugador);

    @Override
    public String toString() {
        return "[" + rareza + "] " + nombre + ": " + descripcion + " (valor: " + valor + ").";
    }
}