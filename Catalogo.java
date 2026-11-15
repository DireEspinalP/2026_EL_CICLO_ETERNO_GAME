import java.util.List;
import java.util.ArrayList;

public class Catalogo{
    private static List<Item> catalogo = null ;
    public static List<Item> getCatalogo(){
        if(catalogo == null){
            catalogo = new ArrayList<>() ;
            cargarItems() ;
        }
        return catalogo ;
    }
    private static void cargarItems() {
        // ===== ARMAS =====
        // Comunes
        catalogo.add(new Arma("Hoja bond", "Corta como un papel... y duele igual", Rareza.COMUN, 2, 3));
        catalogo.add(new Arma("Lápiz", "Mina 2B, punta de guerra", Rareza.COMUN, 2, 5));
        catalogo.add(new Arma("Regla", "Metálica y sin piedad", Rareza.COMUN, 5, 7));
        catalogo.add(new Arma("Plumón de pizarra", "Deja marca, literalmente", Rareza.COMUN, 4, 6));

        // Raras
        catalogo.add(new Arma("Calculadora", "Potencia exámenes y golpes", Rareza.RARO, 35, 22));
        catalogo.add(new Arma("Mochila FC", "Pesa más que tus problemas", Rareza.RARO, 40, 28));

        // Épicas
        catalogo.add(new Arma("Hacha", "El arma definitiva del ciclo eterno", Rareza.EPICO, 120, 55));
        catalogo.add(new Arma("Planchita", "Intimida a cualquier enemigo", Rareza.EPICO, 100, 65));

        // Legendarias
        catalogo.add(new Arma("Laptop", "Compila y aplasta", Rareza.LEGENDARIO, 300, 110));

        // ===== CONSUMIBLES =====
        // Comunes
        catalogo.add(new Consumible("Agua", "Hidratante, lo básico", Rareza.COMUN, 3, 15));
        catalogo.add(new Consumible("Pan de jarritas", "Almuerzo misio", Rareza.COMUN, 3, 20));
        catalogo.add(new Consumible("Vasito de café", "Amargo pero despierta", Rareza.COMUN, 4, 18));
        catalogo.add(new Consumible("Maracuyá de jarritas", "Dulce y ácido, como el ciclo", Rareza.COMUN, 3, 12));
        
        // Raros
        catalogo.add(new Consumible("Menú de FC", "Entrada, segundo y bebida", Rareza.RARO, 30, 45));
        catalogo.add(new Consumible("Siesta en el pasto de FC", "Como 50 horas bien dormidas", Rareza.RARO, 35, 60));

        // Épicos
        catalogo.add(new Consumible("Volt", "Energizante para continuar sin dormir", Rareza.EPICO, 80, 90));

        // Legendarios
        catalogo.add(new Consumible("Comida de skipper", "Revitalizador total", Rareza.LEGENDARIO, 250, 180));

    }

    public static Item buscar(String nombre) {
        for (Item i : getCatalogo()) {
            if (i.getNombre().equals(nombre)) {
                return i;
            }
        }
        return null;
    }
}
