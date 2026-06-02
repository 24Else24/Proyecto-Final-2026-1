import java.util.LinkedList;
import java.util.Scanner;

public class MetodoAlquiler {
    Scanner sc = new Scanner(System.in);
    Validaciones va = new Validaciones();

    public LinkedList<ObjAlquiler> RegistrarAlquiler(LinkedList<ObjAlquiler> la, LinkedList<ObjClientes> lc,
            LinkedList<ObjVehiculos> lv) {
        ObjAlquiler o = new ObjAlquiler();
        String idContrato = "CON-" + System.currentTimeMillis(); // genera ids unicos pa
        o.setIdContrato(idContrato);
        System.out.println("Ingrese la cedula del cliente: ");
        String cedula = va.leerCedula(sc);
        boolean clienteEncontrado = false;
        for (ObjClientes c : lc) {
            if (c.getCedula().equals(cedula)) {
                clienteEncontrado = true;
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Error: cliente no encontrado.");
            return la;
        }

        for (ObjAlquiler a : la) {
            if (a.getCedulaCliente().equals(cedula) && a.isEstado()) {
                System.out.println("Error: el cliente ya tiene un vehiculo alquilado actualmente.");
                return la;
            }
        }
        o.setCedulaCliente(cedula);

        System.out.println("Ingrese la placa del vehiculo: ");
        String placa = va.leerPlaca(sc);
        boolean vehiculoEncontrado = false;
        ObjVehiculos vehiculoAlquilado = null;
        for (ObjVehiculos v : lv) {
            if (v.getPlaca().equals(placa)) {
                vehiculoEncontrado = true;
                vehiculoAlquilado = v;
                break;
            }
        }
        if (!vehiculoEncontrado) {
            System.out.println("Error: vehiculo no encontrado.");
            return la;
        }

        if (!vehiculoAlquilado.getEstado()) {
            System.out.println("Error: el vehiculo no esta disponible para alquiler.");
            return la;
        }

        o.setPlacaVehiculo(placa);
        vehiculoAlquilado.setEstado(false);

        System.out.println("Ingrese la fecha de inicio (DD/MM/AAAA): ");
        o.setFechaInicio(va.leerFecha(sc));
        System.out.println("Ingrese la fecha de fin (DD/MM/AAAA): ");
        o.setFechaFin(va.leerFecha(sc));
        o.setDiasAlquiler(va.calcularDias(o.getFechaInicio(), o.getFechaFin()));
        o.setTotalPagar(o.getDiasAlquiler() * vehiculoAlquilado.getPrecioDiario());
        o.setEstado(true);
        la.add(o);
        System.out.println("Alquiler registrado exitosamente.");
        return la;
    }

    public LinkedList<ObjAlquiler> DevolverAlquiler(LinkedList<ObjAlquiler> la, LinkedList<ObjVehiculos> lv) {
        System.out.println("Ingrese la placa del vehiculo a devolver: ");
        String placa = va.leerPlaca(sc);
        boolean encontrado = false;

        for (ObjAlquiler a : la) {
            if (a.getPlacaVehiculo().equalsIgnoreCase(placa) && a.isEstado()) {
                a.setEstado(false);
                encontrado = true;

                for (ObjVehiculos v : lv) {
                    if (v.getPlaca().equalsIgnoreCase(placa)) {
                        v.setEstado(true);
                        break;
                    }
                }
                System.out.println("Vehiculo devuelto con éxito. Contrato finalizado.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Error: No se encontro un alquiler activo para la placa ingresada.");
        }
        return la;
    }

    public LinkedList<ObjAlquiler> ModificarAlquiler(LinkedList<ObjAlquiler> la, LinkedList<ObjVehiculos> lv) {
        System.out.println("Ingrese la placa del vehiculo del alquiler a modificar: ");
        String placa = va.leerPlaca(sc);
        boolean encontrado = false;

        for (ObjAlquiler a : la) {
            if (a.getPlacaVehiculo().equalsIgnoreCase(placa) && a.isEstado()) {
                encontrado = true;
                System.out.println("Alquiler encontrado.");
                System.out.println("1. Modificar fecha de inicio");
                System.out.println("2. Modificar fecha de fin");
                System.out.println("3. Modificar ambas fechas");
                System.out.println("Seleccione una opcion: ");
                int opcion = va.leerOpcionMenu(sc);

                String tempInicio = a.getFechaInicio();
                String tempFin = a.getFechaFin();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la nueva fecha de inicio (DD/MM/AAAA): ");
                        tempInicio = va.leerFecha(sc);
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva fecha de fin (DD/MM/AAAA): ");
                        tempFin = va.leerFecha(sc);
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva fecha de inicio (DD/MM/AAAA): ");
                        tempInicio = va.leerFecha(sc);
                        System.out.println("Ingrese la nueva fecha de fin (DD/MM/AAAA): ");
                        tempFin = va.leerFecha(sc);
                        break;
                    default:
                        System.out.println("Opcion invalida, no se realizo ninguna modificacion.");
                        return la;
                }

                int nuevosDias = va.calcularDias(tempInicio, tempFin);
                if (nuevosDias < 0) {
                    System.out.println("Error: fechas invalidas, no se guardo la modificacion.");
                    return la;
                }

                a.setFechaInicio(tempInicio);
                a.setFechaFin(tempFin);
                a.setDiasAlquiler(nuevosDias);

                for (ObjVehiculos v : lv) {
                    if (v.getPlaca().equalsIgnoreCase(placa)) {
                        a.setTotalPagar(nuevosDias * v.getPrecioDiario());
                        break;
                    }
                }

                System.out.println("Alquiler modificado exitosamente.");
                System.out.println("Nuevos dias: " + a.getDiasAlquiler());
                System.out.println("Nuevo total: " + a.getTotalPagar());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Error: alquiler no encontrado o no esta activo.");
        }
        return la;
    }

    public void BuscarAlquiler(LinkedList<ObjAlquiler> la) {
        System.out.println("Ingrese el numero del contrato a buscar (ej: 17112233 o CON-17112233): ");
        String numero = sc.nextLine().trim();

        if (numero.isEmpty()) {
            System.out.println("Error: El campo de busqueda no puede estar vacio.");
            return;
        }

        // ── Acepta con o sin "CON-"
        String idBuscado = numero.toUpperCase().startsWith("CON-")
                ? numero.toUpperCase()
                : "CON-" + numero.toUpperCase();

        boolean encontrado = false;
        for (ObjAlquiler a : la) {
            if (a.getIdContrato().equalsIgnoreCase(idBuscado)) {
                encontrado = true;
                System.out.println("\n========================================");
                System.out.println("ID Contrato:  " + a.getIdContrato());
                System.out.println("Cliente:      " + a.getCedulaCliente());
                System.out.println("Placa:        " + a.getPlacaVehiculo());
                System.out.println("Fecha inicio: " + a.getFechaInicio());
                System.out.println("Fecha fin:    " + a.getFechaFin());
                System.out.println("Dias:         " + a.getDiasAlquiler());
                System.out.println("Total:      $ " + a.getTotalPagar());
                System.out.println("Estado:       " + (a.isEstado() ? "Activo" : "Finalizado"));
                System.out.println("========================================");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Contrato no encontrado.");
        }
    }

    public void InformeGeneral(LinkedList<ObjAlquiler> la, LinkedList<ObjClientes> lc, LinkedList<ObjVehiculos> lv) {

        System.out.println("\n========================================");
        System.out.println("        INFORME GENERAL DEL NEGOCIO     ");
        System.out.println("========================================");

        System.out.println("\n--- CLIENTES REGISTRADOS (" + lc.size() + ") ---");
        if (lc.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (ObjClientes c : lc) {
                System.out.println("Cedula: " + c.getCedula()
                        + " | Nombre: " + c.getNombre()
                        + " " + c.getApellido()
                        + " | Tel: " + c.getTelefono());
            }
        }

        System.out.println("\n--- VEHICULOS REGISTRADOS (" + lv.size() + ") ---");
        if (lv.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            for (ObjVehiculos v : lv) {
                String estadoTexto = v.getEstado() ? "Disponible" : "Alquilado";
                System.out.println("Placa: " + v.getPlaca()
                        + " | Marca: " + v.getMarca()
                        + " | Modelo: " + v.getModelo()
                        + " | Estado: " + estadoTexto
                        + " | $/dia: " + v.getPrecioDiario());
            }
        }

        int activos = 0;
        float ingresoActivos = 0;
        System.out.println("\n--- CONTRATOS ACTIVOS ---");
        for (ObjAlquiler a : la) {
            if (a.isEstado()) {
                activos++;
                ingresoActivos += a.getTotalPagar();
                System.out.println("ID: " + a.getIdContrato()
                        + " | Cliente: " + a.getCedulaCliente()
                        + " | Placa: " + a.getPlacaVehiculo()
                        + " | Inicio: " + a.getFechaInicio()
                        + " | Fin: " + a.getFechaFin()
                        + " | Dias: " + a.getDiasAlquiler()
                        + " | Total: $" + a.getTotalPagar());
            }
        }
        if (activos == 0)
            System.out.println("No hay contratos activos.");

        int finalizados = 0;
        float ingresoFinalizados = 0;
        System.out.println("\n--- CONTRATOS FINALIZADOS ---");
        for (ObjAlquiler a : la) {
            if (!a.isEstado()) {
                finalizados++;
                ingresoFinalizados += a.getTotalPagar();
                System.out.println("ID: " + a.getIdContrato()
                        + " | Cliente: " + a.getCedulaCliente()
                        + " | Placa: " + a.getPlacaVehiculo()
                        + " | Inicio: " + a.getFechaInicio()
                        + " | Fin: " + a.getFechaFin()
                        + " | Dias: " + a.getDiasAlquiler()
                        + " | Total: $" + a.getTotalPagar());
            }
        }
        if (finalizados == 0)
            System.out.println("No hay contratos finalizados.");

        float ingresoTotal = ingresoActivos + ingresoFinalizados;
        System.out.println("\n========================================");
        System.out.println("           RESUMEN FINANCIERO           ");
        System.out.println("========================================");
        System.out.println("Contratos activos:       " + activos);
        System.out.println("Contratos finalizados:   " + finalizados);
        System.out.println("Total contratos:         " + la.size());
        System.out.println("Ingresos por activos:  $ " + ingresoActivos);
        System.out.println("Ingresos por cerrados: $ " + ingresoFinalizados);
        System.out.println("INGRESO TOTAL:         $ " + ingresoTotal);
        System.out.println("========================================\n");
    }
}