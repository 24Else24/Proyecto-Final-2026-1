import java.util.LinkedList;
import java.util.Scanner;

public class MetodoCLientes {
  Scanner sc = new Scanner(System.in);

  public LinkedList<ObjClientes> AgregarCliente (LinkedList<ObjClientes> listaClientes) {
    ObjClientes o = new ObjClientes();
    System.out.println("Ingrese la cedula del cliente: ");
    o.setCedula(sc.nextLine());
    System.out.println("Ingrese el nombre del cliente: ");
    o.setNombre(sc.nextLine());
    System.out.println("Ingrese el apellido del cliente: ");
    o.setApellido(sc.nextLine());
    System.out.println("Ingrese el telefono del cliente: ");
    o.setTelefono(sc.nextLine());
    System.out.println("Ingrese la direccion del cliente: ");
    o.setDireccion(sc.nextLine());
    System.out.println("Ingrese la licencia de conduccion del cliente: ");
    o.setLicenciaConduccion(sc.nextLine());
    listaClientes.add(o);
    return listaClientes;
  }

  public LinkedList<ObjClientes> ModificarCliente (LinkedList<ObjClientes> l) {
    System.out.println("Ingrese la cedula del cliente a modificar: ");
    String cedula = sc.nextLine();
    for (ObjClientes o : l) {
      if (o.getCedula().equals(cedula)) {
        System.out.println("Ingrese el nombre del cliente: ");
        o.setNombre(sc.nextLine());
        System.out.println("Ingrese el apellido del cliente: ");
        o.setApellido(sc.nextLine());
        System.out.println("Ingrese el telefono del cliente: ");
        o.setTelefono(sc.nextLine());
        System.out.println("Ingrese la direccion del cliente: ");
        o.setDireccion(sc.nextLine());
        System.out.println("Ingrese la licencia de conduccion del cliente: ");
        o.setLicenciaConduccion(sc.nextLine());
      }else {
        System.out.println("Cliente no encontrado");
      }
    }
    return l;
  }

  public LinkedList<ObjClientes> EliminarCliente (LinkedList<ObjClientes> l) {
    System.out.println("Ingrese la cedula del cliente a eliminar: ");
    String cedula = sc.nextLine();
    for (ObjClientes o : l) {
      if (o.getCedula().equals(cedula)) {
        l.remove(o);
        break;
      }else {
        System.out.println("Cliente no encontrado");
      }
    }
    return l;
  }

  public void BuscarCliente (LinkedList<ObjClientes> l) {
    System.out.println("Ingrese la cedula del cliente a buscar: ");
    String cedula = sc.nextLine();
    for (ObjClientes o : l) {
      if (o.getCedula().equals(cedula)) {
        System.out.println("Cedula: " + o.getCedula());
        System.out.println("Nombre: " + o.getNombre());
        System.out.println("Apellido: " + o.getApellido());
        System.out.println("Telefono: " + o.getTelefono());
        System.out.println("Direccion: " + o.getDireccion());
        System.out.println("Licencia de conduccion: " + o.getLicenciaConduccion());
      }else {
        System.out.println("Cliente no encontrado");
      }
    }
  }
}

