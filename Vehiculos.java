import java.util.LinkedList;
import java.util.Scanner;

public class Vehiculos {
    public void MenuVehiculos() {
        MetodoVehiculos m = new MetodoVehiculos();
        Scanner sc = new Scanner(System.in);
        LinkedList<ObjVehiculos> l = new LinkedList<ObjVehiculos>();
        boolean Menu = true;
        while (Menu) {
            System.out.println("Bienvenido al sistema de vehiculos");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Buscar vehiculo");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            switch (sc.nextInt()) {
                case 1:
                    l = m.RegistrarVehiculo(l);
                    break;

                case 2:
                    l = m.ModificarVehiculo(l);
                    break;

                case 3:
                    l = m.EliminarVehiculo(l);
                    break;

                case 4:
                    m.BuscarVehiculo(l);
                    break;

                case 5:
                    Menu = false;
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }
    }
}