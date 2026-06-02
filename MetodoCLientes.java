import java.util.LinkedList;
import java.util.Scanner;

public class MetodoCLientes {
  Validaciones va = new Validaciones();
  Scanner sc = new Scanner(System.in);

  public LinkedList<ObjClientes> AgregarCliente(LinkedList<ObjClientes> listaClientes) {
    ObjClientes o = new ObjClientes();
    System.out.println("Ingrese la cedula del cliente: ");
    String cedula = va.leerCedula(sc);
    for (ObjClientes c : listaClientes) {
      if (c.getCedula().equals(cedula)) {
        System.out.println("Error: ya existe un cliente con esa cedula.");
        return listaClientes;
      }
    }
    o.setCedula(cedula);
    System.out.println("Ingrese el nombre del cliente: ");
    o.setNombre(va.leerNombre(sc));
    System.out.println("Ingrese el apellido del cliente: ");
    o.setApellido(va.leerNombre(sc));
    o.setTelefono(va.leerTelefono(sc));
    o.setDireccion(va.leerDireccion(sc));
    o.setLicenciaConduccion(va.leerLicencia(sc));
    listaClientes.add(o);
    return listaClientes;
  }

  public LinkedList<ObjClientes> ModificarCliente(LinkedList<ObjClientes> l) {
    System.out.println("Ingrese la cedula del cliente a modificar: ");
    String cedula = va.leerCedula(sc);
    boolean encontrado = false;

    for (ObjClientes o : l) {
      if (o.getCedula().equalsIgnoreCase(cedula)) {
        encontrado = true;
        System.out.println("Cliente encontrado. Ingrese los nuevos datos:");
        System.out.println("Ingrese el nombre del cliente: ");
        o.setNombre(va.leerNombre(sc));
        System.out.println("Ingrese el apellido del cliente: ");
        o.setApellido(va.leerNombre(sc));
        System.out.println("Ingrese el telefono del cliente: ");
        o.setTelefono(va.leerTelefono(sc));
        System.out.println("Ingrese la direccion del cliente: ");
        o.setDireccion(va.leerDireccion(sc));
        System.out.println("Ingrese la licencia de conduccion del cliente: ");
        o.setLicenciaConduccion(va.leerLicencia(sc));
        System.out.println("Cliente modificado exitosamente.");
        break;
      }
    }

    if (!encontrado) {
      System.out.println("Cliente no encontrado.");
    }
    return l;
  }

  public LinkedList<ObjClientes> EliminarCliente(LinkedList<ObjClientes> l) {
    System.out.println("Ingrese la cedula del cliente a eliminar: ");
    String cedula = va.leerCedula(sc);
    boolean encontrado = false;

    for (ObjClientes o : l) {
      if (o.getCedula().equalsIgnoreCase(cedula)) {
        l.remove(o);
        encontrado = true;
        System.out.println("Cliente eliminado exitosamente.");
        break;
      }
    }

    if (!encontrado) {
      System.out.println("Cliente no encontrado.");
    }
    return l;
  }

  public void BuscarCliente(LinkedList<ObjClientes> l) {
    System.out.println("Ingrese la cedula del cliente a buscar: ");
    String cedula = va.leerCedula(sc);
    boolean encontrado = false;

    for (ObjClientes o : l) {
      if (o.getCedula().equalsIgnoreCase(cedula)) {
        encontrado = true;
        System.out.println("\n========================================");
        System.out.println("Cliente encontrado: ");
        System.out.println("Cedula: " + o.getCedula());
        System.out.println("Nombre: " + o.getNombre());
        System.out.println("Apellido: " + o.getApellido());
        System.out.println("Telefono: " + o.getTelefono());
        System.out.println("Direccion: " + o.getDireccion());
        System.out.println("Licencia de conduccion: " + o.getLicenciaConduccion());
        System.out.println("========================================");
        break;
      }
    }

    if (!encontrado) {
      System.out.println("Cliente no encontrado.");
    }
  }

}
