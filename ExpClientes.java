import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExpClientes {
    public void exportarArchivo(LinkedList<ObjClientes> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia no se puede exportar el archivo");
            return;
        } else {
            try (FileWriter e = new FileWriter("Clientes.txt")) {
                for (ObjClientes obj : lista) {
                    e.write("Cedula: " + obj.getCedula() + "\n");
                    e.write("Nombre: " + obj.getNombre() + "\n");
                    e.write("Apellido: " + obj.getApellido() + "\n");
                    e.write("telefono: " + obj.getTelefono() + "\n");
                    e.write("Direccion: " + obj.getDireccion() + "\n");
                    e.write("Licencia de conduccion: " + obj.getLicenciaConduccion() + "\n");
                    e.write("------------------------------------------------------ \n");

                }
                System.out.println("Archivo exportado correctamente ");

            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}