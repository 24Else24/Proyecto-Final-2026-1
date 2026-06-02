import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ImpClientes {
    public LinkedList<ObjClientes> Importararchivo() {
        LinkedList<ObjClientes> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Clientes.txt"))) {
            String linea;
            ObjClientes obj = null;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Cedula: ")) {
                    obj = new ObjClientes();
                    obj.setCedula(linea.substring("Cedula: ".length()));

                } else if (linea.startsWith("Nombre: ") && obj != null) {
                    obj.setNombre(linea.substring("Nombre: ".length()));

                } else if (linea.startsWith("Apellido: ") && obj != null) {
                    obj.setApellido(linea.substring("Apellido: ".length()));

                } else if (linea.startsWith("telefono: ") && obj != null) {
                    obj.setTelefono(linea.substring("telefono: ".length()));

                } else if (linea.startsWith("Direccion: ") && obj != null) {
                    obj.setDireccion(linea.substring("Direccion: ".length()));

                } else if (linea.startsWith("Licencia de conduccion: ") && obj != null) {
                    obj.setLicenciaConduccion(linea.substring("Licencia de conduccion: ".length()));
                    lista.add(obj); // objeto completo → se agrega a la lista
                }
            }
            System.out.println("Archivo importado correctamente. Clientes cargados: " + lista.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}