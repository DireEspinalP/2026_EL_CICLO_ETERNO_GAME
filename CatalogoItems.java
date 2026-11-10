import java.util.List;
import java.util.ArrayList;

public class CatalogoItems {
    public static List<Item> todos() {
        List<Item> lista = new ArrayList<>();

        // ===== ARMAS =====
        // Comunes
        lista.add(new Arma("Hoja bond", "Corta como un papel... y duele igual", Rareza.COMUN, 2, 3));
        lista.add(new Arma("Lápiz", "Mina 2B, punta de guerra", Rareza.COMUN, 2, 5));
        lista.add(new Arma("Regla", "Metálica y sin piedad", Rareza.COMUN, 5, 7));
        lista.add(new Arma("Plumón de pizarra", "Deja marca, literalmente", Rareza.COMUN, 4, 6));

        // Raras
        lista.add(new Arma("Calculadora", "Potencia exámenes y golpes", Rareza.RARO, 35, 22));
        lista.add(new Arma("Mochila FC", "Pesa más que tus problemas", Rareza.RARO, 40, 28));

        // Épicas
        lista.add(new Arma("Hacha", "El arma definitiva del ciclo eterno", Rareza.EPICO, 120, 55));
        lista.add(new Arma("Planchita", "Intimida a cualquier enemigo", Rareza.EPICO, 100, 65));

        // Legendarias
        lista.add(new Arma("Laptop", "Compila y aplasta", Rareza.LEGENDARIO, 300, 110));

        // ===== CONSUMIBLES =====
        // Comunes
        lista.add(new Consumible("Agua", "Hidratante, lo básico", Rareza.COMUN, 3, 15));
        lista.add(new Consumible("Pan de jarritas", "Almuerzo misio", Rareza.COMUN, 3, 20));
        lista.add(new Consumible("Vasito de café", "Amargo pero despierta", Rareza.COMUN, 4, 18));
        lista.add(new Consumible("Maracuyá de jarritas", "Dulce y ácido, como el ciclo", Rareza.COMUN, 3, 12));
        
        // Raros
        lista.add(new Consumible("Menú de FC", "Entrada, segundo y bebida", Rareza.RARO, 30, 45));
        lista.add(new Consumible("Siesta en el pasto de FC", "Como 50 horas bien dormidas", Rareza.RARO, 35, 60));

        // Épicos
        lista.add(new Consumible("Volt", "Energizante para continuar sin dormir", Rareza.EPICO, 80, 90));

        // Legendarios
        lista.add(new Consumible("Comida de skipper", "Revitalizador total", Rareza.LEGENDARIO, 250, 180));

        return lista;
    }
}
