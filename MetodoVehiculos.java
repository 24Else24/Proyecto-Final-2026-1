import java.util.LinkedList;
    import java.util.Scanner;
    
    public class MetodoVehiculos {
        Scanner sc = new Scanner(System.in);
    
        public LinkedList<ObjVehiculos> RegistrarVehiculo(LinkedList<ObjVehiculos> listaVehiculos) {   
            System.out.println("Tipo de vehiculo: 1. Carro Sedan  2. Camioneta SUV");
            int tipo = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingrese la placa: ");
            String placa = sc.nextLine();
            System.out.println("Ingrese la marca: ");
            String marca = sc.nextLine();
            System.out.println("Ingrese el modelo (año): ");
            int modelo = sc.nextInt();
            System.out.println("Ingrese el precio diario: ");
            float precio = sc.nextFloat();
            sc.nextLine();
            System.out.println("Ingrese el estado (disponible/alquilado): ");
            String estado = sc.nextLine();
    
            if (tipo == 1) {
                ObjCarroSedan o = new ObjCarroSedan();
                o.setPlaca(placa); 
                o.setMarca(marca); 
                o.setModelo(modelo);
                o.setPrecioDiario(precio); 
                o.setEstado(estado);
                System.out.println("Ingrese el tipo de combustible (gasolina/diesel/electrico): ");
                o.setTipoCombustible(sc.nextLine());
                System.out.println("Ingrese la transmision (automatica/manual): ");
                o.setTransmision(sc.nextLine());
                listaVehiculos.add(o);
            } else if (tipo == 2) {
                ObjCamionetaSUV o = new ObjCamionetaSUV();
                o.setPlaca(placa); 
                o.setMarca(marca); 
                o.setModelo(modelo);
                o.setPrecioDiario(precio); 
                o.setEstado(estado);
                System.out.println("Ingrese la traccion (4x2/4x4): ");
                o.setTraccion(sc.nextLine());
                System.out.println("Ingrese la capacidad del maletero (litros): ");
                o.setCapacidadMaletero(sc.nextFloat());
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
            String placa = sc.nextLine();
            boolean encontrado = false;
            for (ObjVehiculos v : l) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    encontrado = true;
                    System.out.println("Ingrese la nueva marca: ");
                    v.setMarca(sc.nextLine());
                    System.out.println("Ingrese el nuevo modelo: ");
                    v.setModelo(sc.nextInt());
                    System.out.println("Ingrese el nuevo precio diario: ");
                    v.setPrecioDiario(sc.nextFloat());
                    sc.nextLine();
                    System.out.println("Ingrese el nuevo estado (disponible/alquilado): ");
                    v.setEstado(sc.nextLine());
    
                    if (v instanceof ObjCarroSedan) {
                        ObjCarroSedan s = (ObjCarroSedan) v;
                        System.out.println("Ingrese el tipo de combustible: ");
                        s.setTipoCombustible(sc.nextLine());
                        System.out.println("Ingrese la transmision: ");
                        s.setTransmision(sc.nextLine());
                    } else if (v instanceof ObjCamionetaSUV) {
                        ObjCamionetaSUV c = (ObjCamionetaSUV) v;
                        System.out.println("Ingrese la traccion: ");
                        c.setTraccion(sc.nextLine());
                        System.out.println("Ingrese la capacidad del maletero: ");
                        c.setCapacidadMaletero(sc.nextFloat());
                        sc.nextLine();
                    }
                    System.out.println("Vehiculo modificado exitosamente.");
                    break;
                }
            }
            if (!encontrado) System.out.println("Vehiculo no encontrado.");
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
            if (!encontrado) System.out.println("Vehiculo no encontrado.");
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
            if (!encontrado) System.out.println("Vehiculo no encontrado.");
        }
}
