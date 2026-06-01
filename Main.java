import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean Seguir = true;
        Scanner sc = new Scanner(System.in);
        while (Seguir) {
            System.out.println("Bienvenido al sistema de alquiler de carros");
            System.out.println("1. Clientes");
            System.out.println("2. Carros");
            System.out.println("3. Alquileres");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");
            switch (sc.nextInt()) {
                case 1:
                    Clientes c = new Clientes();
                    c.MenuClientes();
                    break;

                case 2:
                    // Llamar al menú de carros
                    break;

                case 3:
                    // Llamar al menú de alquileres
                    break;

                case 4:
                    Seguir = false;
                    break;
            
                default:
                    break;
            }
        }
    }
}
