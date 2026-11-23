public abstract class Item {
    protected String nombre;
    protected String descripcion;
    protected int cantidad;
    protected int maxStack;
    private Rareza rareza;
    private double valor;

    public Item(String nombre, String descripcion, int cantidad, int maxStack, Rareza rareza, double valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.maxStack = maxStack;
        this.rareza = rareza;
        this.valor = valor;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getCantidad() { return cantidad; }
    public int getMaxStack() { return maxStack; }
    public Rareza getRareza() { return rareza; }
    public double getValor() { return valor; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad;}

    public void sumarCantidad(int n) { this.cantidad += n; }


    public abstract void usar(Player jugador);

    @Override
    public String toString() {
        return "[" + rareza + "] " + nombre + ": " + descripcion + " (valor: " + valor + ").";
    }
}