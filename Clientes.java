import java.util.LinkedList;
import java.util.Scanner;

public class Clientes {
    public void MenuClientes() {
        MetodoCLientes m = new MetodoCLientes();
        Scanner sc = new Scanner(System.in);
        LinkedList<ObjClientes> l = new LinkedList<ObjClientes>();
        boolean Menu = true;
        while (Menu) {
            System.out.println("Bienvenido al sistema de clientes");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            switch (sc.nextInt()) {
                case 1:
                    l = m.AgregarCliente(l);
                    break;

                case 2:
                    l = m.ModificarCliente(l);
                    break;

                case 3:
                    l = m.EliminarCliente(l);
                    break;

                case 4:
                    m.BuscarCliente(l);
                    break;

                case 5:
                    Menu = false;
                    break;

                default:
                    System.out.println("ingrese una opcion valida");
            }
        }
    }
}
