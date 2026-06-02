import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ImpAlquiler {
    public LinkedList<ObjAlquiler> importarAlquileres() {
        LinkedList<ObjAlquiler> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Alquileres.txt"))) {
            String linea;

            String idContrato = null;
            String cedula = null;
            String placa = null;
            String fechaInicio = null;
            String fechaFin = null;
            int dias = 0;
            float totalPagar = 0;
            boolean estado = false;

            while ((linea = br.readLine()) != null) {

                if (linea.startsWith("------")) {
                    if (idContrato == null)
                        continue;

                    ObjAlquiler a = new ObjAlquiler();
                    a.setIdContrato(idContrato);
                    a.setCedulaCliente(cedula);
                    a.setPlacaVehiculo(placa);
                    a.setFechaInicio(fechaInicio);
                    a.setFechaFin(fechaFin);
                    a.setDiasAlquiler(dias);
                    a.setTotalPagar(totalPagar);
                    a.setEstado(estado);
                    lista.add(a);

                    idContrato = cedula = placa = fechaInicio = fechaFin = null;
                    dias = 0;
                    totalPagar = 0;
                    estado = false;
                    continue;
                }

                if (linea.startsWith("IdContrato: "))
                    idContrato = linea.substring("IdContrato: ".length());
                else if (linea.startsWith("Cedula: "))
                    cedula = linea.substring("Cedula: ".length());
                else if (linea.startsWith("Placa: "))
                    placa = linea.substring("Placa: ".length());
                else if (linea.startsWith("FechaInicio: "))
                    fechaInicio = linea.substring("FechaInicio: ".length());
                else if (linea.startsWith("FechaFin: "))
                    fechaFin = linea.substring("FechaFin: ".length());
                else if (linea.startsWith("Dias: "))
                    dias = Integer.parseInt(linea.substring("Dias: ".length()));
                else if (linea.startsWith("TotalPagar: "))
                    totalPagar = Float.parseFloat(linea.substring("TotalPagar: ".length()));
                else if (linea.startsWith("Estado: "))
                    estado = linea.substring("Estado: ".length()).equals("1");
            }

            System.out.println("Archivo importado correctamente. Contratos cargados: " + lista.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
