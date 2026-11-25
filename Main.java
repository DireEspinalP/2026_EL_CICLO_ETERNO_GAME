import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Escribe el nombre de tu personaje");
        name = sc.nextLine();
        sc.close();
        //String name, double hp, double atk, double def, double exp, int lvl, boolean isAlive, double cash
        Player player = new Player(name,200.0, 10.0, 0.0, 0.0, 1, true, 0.0);
        Enemy enemigo = new Enemy("Royer", 250.0, 15.0, 20.5, 15.0,1, true, 30.0);

        
        player.atack(enemigo);
        enemigo.atack(player);

        System.out.println(player.hp);
        System.out.println(enemigo.hp);

        Item item = Cofre.abrir();
        player.getInventario().agregarItem(item.getNombre(), 1);
        System.out.println("Has obtenido: " + item.getNombre() + " x" + 1);
        player.getInventario().mostrar();


        Map<Rareza, Integer> rarezaCount = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Rareza rareza = Cofre.elegirRareza();
            rarezaCount.put(rareza, rarezaCount.getOrDefault(rareza, 0) + 1);
        }
        System.out.println(rarezaCount);

        List<Item> itemsFiltrados = Cofre.itemsDeRareza(Rareza.LEGENDARIO);
        for (Item itemsRaros : itemsFiltrados) {
            System.out.println(itemsRaros);
        }

        

    }
}
