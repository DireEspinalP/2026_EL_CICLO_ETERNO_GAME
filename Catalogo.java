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
        catalogo.add(new Arma("Hoja bond", "Corta como un papel... y duele igual", 0, Rareza.COMUN, 2.0 , 3.0 ));
        catalogo.add(new Arma("Lápiz", "Mina 2B, punta de guerra", 0, Rareza.COMUN, 2.0, 5.0));
        catalogo.add(new Arma("Regla", "Metálica y sin piedad", 0, Rareza.COMUN, 5.0, 7.0));
        catalogo.add(new Arma("Plumón de pizarra", "Deja marca, literalmente", 0, Rareza.COMUN, 4.0, 6.0));

        // Raras
        catalogo.add(new Arma("Calculadora", "Potencia exámenes y golpes", 0, Rareza.RARO, 35.0, 22.0));
        catalogo.add(new Arma("Mochila FC", "Pesa más que tus problemas", 0, Rareza.RARO, 40.0, 28.0));

        // Épicas
        catalogo.add(new Arma("Hacha", "El arma definitiva del ciclo eterno", 0, Rareza.EPICO, 120.0, 55.0));
        catalogo.add(new Arma("Planchita", "Intimida a cualquier enemigo", 0, Rareza.EPICO, 100.0, 65.0));

        // Legendarias
        catalogo.add(new Arma("Laptop", "Compila y aplasta", 0, Rareza.LEGENDARIO, 300.0, 110.0));

        // ===== CONSUMIBLES =====
        // Comunes
        catalogo.add(new Consumible("Agua", "Hidratante, lo básico", 0, Rareza.COMUN, 3.0, 15.0));
        catalogo.add(new Consumible("Pan de jarritas", "Almuerzo misio", 0, Rareza.COMUN, 3.0, 20.0));
        catalogo.add(new Consumible("Vasito de café", "Amargo pero despierta", 0, Rareza.COMUN, 4.0, 18.0));
        catalogo.add(new Consumible("Maracuyá de jarritas", "Dulce y ácido, como el ciclo", 0, Rareza.COMUN, 3.0, 12.0));
        
        // Raros
        catalogo.add(new Consumible("Menú de FC", "Entrada, segundo y bebida", 0, Rareza.RARO, 30.0, 45.0));
        catalogo.add(new Consumible("Siesta en el pasto de FC", "Como 50 horas bien dormidas", 0, Rareza.RARO, 35.0, 60.0));

        // Épicos
        catalogo.add(new Consumible("Volt", "Energizante para continuar sin dormir", 0, Rareza.EPICO, 80.0, 90.0));

        // Legendarios
        catalogo.add(new Consumible("Comida de skipper", "Revitalizador total", 0, Rareza.LEGENDARIO, 250.0, 180.0));

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
