import java.util.LinkedList;
import java.util.Scanner;

public class Clientes {
    public void MenuClientes(LinkedList<ObjClientes> l) {
        MetodoCLientes m = new MetodoCLientes();
        Validaciones va = new Validaciones();
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("=== GESTION DE CLIENTES ===");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");
            switch (va.leerOpcionMenu(sc)) {
                case 1: l = m.AgregarCliente(l);  break;
                case 2: l = m.ModificarCliente(l); break;
                case 3: l = m.EliminarCliente(l);  break;
                case 4: m.BuscarCliente(l);         break;
                case 5: menu = false;               break;
                default: System.out.println("Ingrese una opcion valida");
            }
        }
    }
}