import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Cofre {
    
    public static Item abrir() {
        Rareza rarezaElegida = elegirRareza();
        List<Item> filtrados = itemsDeRareza(rarezaElegida);
        Random aleatorio = new Random();
        int index = aleatorio.nextInt(filtrados.size());
        return filtrados.get(index);
    }

    public static Rareza elegirRareza() {
        Random ran = new Random();
        int proba = ran.nextInt(100);
        if (proba < 60) {
            return Rareza.COMUN;
        } else if (proba < 85) {
            return Rareza.RARO;
        } else if (proba < 95) {
            return Rareza.EPICO;
        } else { return Rareza.LEGENDARIO; }
    }

    public static List<Item> itemsDeRareza(Rareza equis) {
        List<Item> itemsFiltrados = new ArrayList<>();
        for (Item cat : Catalogo.getCatalogo()) {
            if (cat.getRareza() == equis) itemsFiltrados.add(cat);
        }
        return itemsFiltrados;
    }
}
