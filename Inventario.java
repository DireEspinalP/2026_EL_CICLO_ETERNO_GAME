import java.util.Map ;
import java.util.List ;
import java.util.HashMap ;

public class Inventario {

    private Map<String, Item> items ;
    //Carga el inventario con 0 para todos los objetos
    public Inventario(List<Item> catalogo) {
        items = new HashMap<>() ;
        for (Item item : catalogo) {
            item.setCantidad(0) ;
            items.put(item.getNombre(), item) ;
        }
    }
    // Agrega items respetando el limite de stacks, si solo se puede agregar 7 y tu quieres poner 10. Solo agregara 7 y los otros 3 desaparecen
    public void agregarItem(String nombre, int cantidad) {
        Item item = items.get(nombre) ;
        if (item == null) {
            System.out.println("Error: '" + nombre + "' no existe.") ;
            return ;
        }
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser positiva.") ;
            return ;
        }
        int espacioDisponible = item.getMaxStack() - item.getCantidad() ;
        if (espacioDisponible <= 0) {
            System.out.println("Stack lleno para el ítem " + nombre + ".") ;
            return ;
        }
        int agregar = Math.min(espacioDisponible, cantidad) ;
        item.sumarCantidad(agregar) ;
        if (agregar < cantidad) {
            System.out.println("Solo se agregaron " + agregar + " de " + cantidad + " (stack lleno).") ;
        }
    }

    public int getCantidad(String nombre) {
        Item item = items.get(nombre) ;
        return (item == null) ? 0 : item.getCantidad() ;
    }

    public boolean tieneItem(String nombre) {
        return getCantidad(nombre) > 0 ;
    }

    public boolean usarItem(String nombre, Player jugador) {
        Item item = items.get(nombre) ;
        if (item == null || item.getCantidad() <= 0) {
            System.out.println("No tienes " + nombre + ".") ;
            return false ;
        }
        // En armas, primero se quita la que estemo usando para usar la nueva
        if (item instanceof Arma) {
            Arma nueva = (Arma) item ;

            if (nueva.isEquipada()) {
                System.out.println(nueva.getNombre() + " ya está equipada.") ;
                return false ;
            }

            for (Item i : items.values()) {
                if (i instanceof Arma) {
                    Arma otra = (Arma) i ;
                    if (otra.isEquipada()) {
                        jugador.setAtk(jugador.getAtk() - otra.getBonusAtk()) ;
                        otra.setEquipada(false) ;
                        System.out.println("Desequipaste " + otra.getNombre()) ;
                    }
                }
            }

            nueva.usar(jugador) ;
            return true ;
        }

        // Para comsumibles
        item.usar(jugador) ;
        item.setCantidad(item.getCantidad() - 1) ;
        if (item.getCantidad() == 0) {
            System.out.println(nombre + " se agotó.") ;
        }
        return true ;
    }
    // "debug" se muestran todos los objetos del inventario y su cantidad
    public void mostrar() {
        System.out.println("=== INVENTARIO ===") ;
        boolean vacio = true ;
        for (Item item : items.values()) {
            if (item.getCantidad() > 0) {
                String marca = (item instanceof Arma && ((Arma) item).isEquipada()) ? " [equipada]" : "" ;
                System.out.println("- " + item.getNombre() + " x" + item.getCantidad() + marca) ;
                vacio = false ;
            }
        }
        if (vacio) {
            System.out.println("(vacío)") ;
        }
    }

    public boolean estaVacio() {
        for (Item item : items.values()) {
            if (item.getCantidad() > 0) return false ;
        }
        return true ;
    }

    public void eliminarItem(String nombre) {
        Item item = items.get(nombre) ;
        if (item != null) {
            item.setCantidad(0) ;
            System.out.println(nombre + " eliminado del inventario.") ;
        }
    }
}