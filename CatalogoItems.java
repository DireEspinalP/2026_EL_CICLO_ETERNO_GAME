import java.util.List;
import java.util.ArrayList;

public class CatalogoItems {
    public static List<Item> todos() {
        List<Item> lista = new ArrayList<>();
        lista.add(new Arma("carnet", "pase para la universidad", Rareza.COMUN, 5, 0));
        lista.add(new Consumible("volt", "energizante", Rareza.EPICO, 7, 10));
        lista.add(new Arma("Regla", "Metálica", Rareza.COMUN, 5,3));
        return lista;
    }
}
