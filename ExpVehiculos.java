import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExpVehiculos {

    public void exportarVehiculos(LinkedList<ObjVehiculos> listaVehiculos) {
        if (listaVehiculos.isEmpty()) {
            System.out.println("La lista esta vacia, no se puede exportar el archivo.");
            return;
        }

        try (FileWriter fw = new FileWriter("Vehiculos.txt")) {
            for (ObjVehiculos obj : listaVehiculos) {

                if (obj instanceof ObjCarroSedan) {
                    ObjCarroSedan c = (ObjCarroSedan) obj;
                    fw.write("Tipo: CarroSedan\n");
                    fw.write("Placa: "            + c.getPlaca()                  + "\n");
                    fw.write("Marca: "            + c.getMarca()                  + "\n");
                    fw.write("Modelo: "           + c.getModelo()                 + "\n");
                    fw.write("PrecioDiario: "     + c.getPrecioDiario()           + "\n");
                    fw.write("Estado: "           + (c.getEstado() ? 1 : 0)       + "\n"); // ← corregido
                    fw.write("TipoCombustible: "  + c.getTipoCombustible()        + "\n");
                    fw.write("Transmision: "      + c.getTransmision()            + "\n");

                } else if (obj instanceof ObjCamionetaSUV) {
                    ObjCamionetaSUV s = (ObjCamionetaSUV) obj;
                    fw.write("Tipo: CamionetaSUV\n");
                    fw.write("Placa: "            + s.getPlaca()                  + "\n");
                    fw.write("Marca: "            + s.getMarca()                  + "\n");
                    fw.write("Modelo: "           + s.getModelo()                 + "\n");
                    fw.write("PrecioDiario: "     + s.getPrecioDiario()           + "\n");
                    fw.write("Estado: "           + (s.getEstado() ? 1 : 0)       + "\n"); // ← corregido
                    fw.write("Traccion: "         + s.getTraccion()               + "\n");
                    fw.write("CapacidadMaletero: "+ s.getCapacidadMaletero()      + "\n");
                }

                fw.write("------------------------------------------------------\n");
            }
            System.out.println("Archivo exportado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}