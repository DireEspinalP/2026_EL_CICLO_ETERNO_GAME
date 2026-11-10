import java.util.Random;
import java.util.List;

public class Cofre {
    public Item abrir() {
        List<Items> catalogo = CatalogoItems.todos();
        Random aleatorio = new Random();
        int index = aleatorio.nextInt(catalogo.size());
        return catalogo.get(index);
    }
}
