import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean seguir = true;
        Scanner sc = new Scanner(System.in);

        // ── Listas globales cargadas una sola vez al iniciar ──────────────
        ImpClientes ic = new ImpClientes();
        ImpVehiculos iv = new ImpVehiculos();
        ImpAlquiler  ia = new ImpAlquiler();

        LinkedList<ObjClientes>  lc = ic.Importararchivo();
        LinkedList<ObjVehiculos> lv = iv.importarVehiculos();
        LinkedList<ObjAlquiler>  la = ia.importarAlquileres();

        while (seguir) {
            System.out.println("Bienvenido al sistema de alquiler de carros");
            System.out.println("1. Clientes");
            System.out.println("2. Carros");
            System.out.println("3. Alquileres");
            System.out.println("4. Informe general");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            switch (sc.nextInt()) {
                case 1:
                    Clientes c = new Clientes();
                    c.MenuClientes(lc);
                    break;
                case 2:
                    Vehiculos v = new Vehiculos();
                    v.MenuVehiculos(lv);
                    break;
                case 3:
                    Alquileres a = new Alquileres();
                    a.MenuAlquileres(la, lc, lv);
                    break;
                case 4:
                    MetodoAlquiler ma = new MetodoAlquiler();
                    ma.InformeGeneral(la, lc, lv);
                    break;
                case 5:
                    // ── Guardar todo al salir ─────────────────────────────
                    new ExpClientes().exportarArchivo(lc);
                    new ExpVehiculos().exportarVehiculos(lv);
                    new ExpAlquiler().exportarAlquileres(la);
                    seguir = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }
    }
}