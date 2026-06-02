import java.util.LinkedList;
import java.util.Scanner;

public class Vehiculos {
    public void MenuVehiculos(LinkedList<ObjVehiculos> l) {
        MetodoVehiculos m = new MetodoVehiculos();
        Validaciones va = new Validaciones();
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("=== GESTION DE VEHICULOS ===");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Buscar vehiculo");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            switch (va.leerOpcionMenu(sc)) {
                case 1: l = m.RegistrarVehiculo(l);  break;
                case 2: l = m.ModificarVehiculo(l);  break;
                case 3: l = m.EliminarVehiculo(l);   break;
                case 4: m.BuscarVehiculo(l);          break;
                case 5: menu = false;                 break;
                default: System.out.println("Ingrese una opcion valida");
            }
        }
    }
}