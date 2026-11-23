import java.util.Random;
import java.util.List;

public class Cofre {
    public static Item abrir() {
        List<Item> catalogo = Catalogo.getCatalogo();
        Random aleatorio = new Random();
        int index = aleatorio.nextInt(catalogo.size());
        return catalogo.get(index);
    }
}
