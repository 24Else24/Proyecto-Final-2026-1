import java.util.LinkedList;
import java.util.Scanner;

public class Alquileres {
    public void MenuAlquileres(LinkedList<ObjAlquiler> la, LinkedList<ObjClientes> lc, LinkedList<ObjVehiculos> lv) {
        MetodoAlquiler m = new MetodoAlquiler();
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("=== GESTION DE ALQUILERES ===");
            System.out.println("1. Registrar alquiler");
            System.out.println("2. Modificar alquiler");
            System.out.println("3. Devolver vehiculo");
            System.out.println("4. Buscar contrato");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            switch (sc.nextInt()) {
                case 1: la = m.RegistrarAlquiler(la, lc, lv); break;
                case 2: la = m.ModificarAlquiler(la, lv);     break;
                case 3: la = m.DevolverAlquiler(la, lv);      break;
                case 4: m.BuscarAlquiler(la);                 break;
                case 5: menu = false;                         break;
                default: System.out.println("Ingrese una opcion valida");
            }
        }
    }
}