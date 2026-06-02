import java.util.LinkedList;
import java.util.Scanner;

public class MetodoVehiculos {
    Scanner sc = new Scanner(System.in);
    Validaciones va = new Validaciones();

    public LinkedList<ObjVehiculos> RegistrarVehiculo(LinkedList<ObjVehiculos> listaVehiculos) {
        System.out.println("Tipo de vehiculo: 1. Carro Sedan  2. Camioneta SUV");
        int tipo = va.leerOpcionMenu(sc); // <--- Ahora usa la validación recursiva y segura
        System.out.println("Ingrese la placa: ");
        String placa = va.leerPlaca(sc);

        for (ObjVehiculos v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Error: ya existe un vehiculo con esa placa.");
                return listaVehiculos;
            }
        }
        System.out.println("Ingrese la marca: ");
        String marca = sc.nextLine();
        System.out.println("Ingrese el modelo (año): ");
        int modelo = va.leerAnio(sc);
        System.out.println("Ingrese el precio diario: ");
        float precio = va.leerFloatPositivo(sc);
        System.out.println("Ingrese el estado (1=disponible/0=alquilado): ");
        Boolean estado = va.leerBooleano(sc);
        sc.nextLine();

        if (tipo == 1) {
            ObjCarroSedan o = new ObjCarroSedan();
            o.setPlaca(placa);
            o.setMarca(marca);
            o.setModelo(modelo);
            o.setPrecioDiario(precio);
            o.setEstado(estado);
            System.out.println("Ingrese el tipo de combustible (1.gasolina/2.diesel/3.electrico): ");
            o.setTipoCombustible(va.leerCombustible(sc));
            System.out.println("Ingrese la transmision (1.automatica/2.manual): ");
            o.setTransmision(va.leerTransmision(sc));
            listaVehiculos.add(o);
        } else if (tipo == 2) {
            ObjCamionetaSUV o = new ObjCamionetaSUV();
            o.setPlaca(placa);
            o.setMarca(marca);
            o.setModelo(modelo);
            o.setPrecioDiario(precio);
            o.setEstado(estado);
            System.out.println("Ingrese la traccion (4x2/4x4): ");
            o.setTraccion(va.leerTraccion(sc));
            System.out.println("Ingrese la capacidad del maletero (litros): ");
            o.setCapacidadMaletero(va.leerFloatPositivo(sc));
            sc.nextLine();
            listaVehiculos.add(o);
        } else {
            System.out.println("Tipo invalido.");
        }
        System.out.println("Vehiculo registrado exitosamente.");
        return listaVehiculos;
    }

    public LinkedList<ObjVehiculos> ModificarVehiculo(LinkedList<ObjVehiculos> l) {
        System.out.println("Ingrese la placa del vehiculo a modificar: ");
        String placa = va.leerPlaca(sc);
        boolean encontrado = false;

        for (ObjVehiculos v : l) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                System.out.println("Vehiculo encontrado.");
                System.out.println("Ingrese la nueva marca: ");
                v.setMarca(sc.nextLine());
                System.out.println("Ingrese el nuevo modelo (año): ");
                v.setModelo(va.leerAnio(sc));
                System.out.println("Ingrese el nuevo precio diario: ");
                v.setPrecioDiario(va.leerFloatPositivo(sc));
                System.out.println("Ingrese el nuevo estado (1=disponible/0=alquilado): ");
                v.setEstado(va.leerBooleano(sc));
                sc.nextLine();

                if (v instanceof ObjCarroSedan) {
                    ObjCarroSedan s = (ObjCarroSedan) v;
                    System.out.println("Ingrese el tipo de combustible (1.gasolina/2.diesel/3.electrico): ");
                    s.setTipoCombustible(sc.nextLine());
                    System.out.println("Ingrese la transmision (1.automatica/2.manual): ");
                    s.setTransmision(sc.nextLine());
                } else if (v instanceof ObjCamionetaSUV) {
                    ObjCamionetaSUV c = (ObjCamionetaSUV) v;
                    System.out.println("Ingrese la nueva traccion: ");
                    c.setTraccion(sc.nextLine());
                    System.out.println("Ingrese la nueva capacidad del maletero: ");
                    c.setCapacidadMaletero(va.leerFloatPositivo(sc));
                    sc.nextLine(); // Limpiar búfer
                }
                System.out.println("Vehiculo modificado exitosamente.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Vehiculo no encontrado.");
        }
        return l;
    }

    public LinkedList<ObjVehiculos> EliminarVehiculo(LinkedList<ObjVehiculos> l) {
        System.out.println("Ingrese la placa del vehiculo a eliminar: ");
        String placa = sc.nextLine();
        boolean encontrado = false;
        for (ObjVehiculos v : l) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                l.remove(v);
                encontrado = true;
                System.out.println("Vehiculo eliminado exitosamente.");
                break;
            }
        }
        if (!encontrado)
            System.out.println("Vehiculo no encontrado.");
        return l;
    }

    public void BuscarVehiculo(LinkedList<ObjVehiculos> l) {
        System.out.println("Ingrese la placa del vehiculo a buscar: ");
        String placa = sc.nextLine();
        boolean encontrado = false;
        for (ObjVehiculos v : l) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = true;
                System.out.println("Placa: " + v.getPlaca());
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Modelo: " + v.getModelo());
                System.out.println("Precio diario: " + v.getPrecioDiario());
                System.out.println("Estado: " + v.getEstado());
                if (v instanceof ObjCarroSedan) {
                    ObjCarroSedan s = (ObjCarroSedan) v;
                    System.out.println("Tipo combustible: " + s.getTipoCombustible());
                    System.out.println("Transmision: " + s.getTransmision());
                } else if (v instanceof ObjCamionetaSUV) {
                    ObjCamionetaSUV c = (ObjCamionetaSUV) v;
                    System.out.println("Traccion: " + c.getTraccion());
                    System.out.println("Capacidad maletero: " + c.getCapacidadMaletero() + " L");
                }
                break;
            }
        }
        if (!encontrado)
            System.out.println("Vehiculo no encontrado.");
    }
}
