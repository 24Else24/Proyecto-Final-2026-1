import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExpAlquiler {
    public void exportarAlquileres(LinkedList<ObjAlquiler> la) {
        if (la.isEmpty()) {
            System.out.println("La lista esta vacia, no se puede exportar el archivo.");
            return;
        }

        try (FileWriter fw = new FileWriter("Alquileres.txt")) {
            for (ObjAlquiler a : la) {
                fw.write("IdContrato: " + a.getIdContrato() + "\n");
                fw.write("Cedula: " + a.getCedulaCliente() + "\n");
                fw.write("Placa: " + a.getPlacaVehiculo() + "\n");
                fw.write("FechaInicio: " + a.getFechaInicio() + "\n");
                fw.write("FechaFin: " + a.getFechaFin() + "\n");
                fw.write("Dias: " + a.getDiasAlquiler() + "\n");
                fw.write("TotalPagar: " + a.getTotalPagar() + "\n");
                fw.write("Estado: " + (a.isEstado() ? 1 : 0) + "\n");
                fw.write("------------------------------------------------------\n");
            }
            System.out.println("Archivo exportado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
