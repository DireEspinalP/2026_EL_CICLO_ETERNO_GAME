import java.util.Scanner;

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



    }
}
