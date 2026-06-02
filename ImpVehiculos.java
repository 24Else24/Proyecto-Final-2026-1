import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ImpVehiculos {

    // ─── IMPORTAR ───────────────────────────────────────────────────────────────
    public LinkedList<ObjVehiculos> importarVehiculos() {
        LinkedList<ObjVehiculos> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Vehiculos.txt"))) {
            String linea;
            String tipoActual = null;

            String placa = null, marca = null;
            int modelo = 0;
            float precio = 0;
            boolean estado = false;

            String tipoCombustible = null, transmision = null;
            String traccion = null;
            float capacidadMaletero = 0;

            while ((linea = br.readLine()) != null) {

                // ── Separador: construir y guardar el objeto completo ──────────
                if (linea.startsWith("------")) {
                    if (tipoActual == null)
                        continue;

                    if (tipoActual.equals("CarroSedan")) {
                        ObjCarroSedan c = new ObjCarroSedan();
                        c.setPlaca(placa);
                        c.setMarca(marca);
                        c.setModelo(modelo);
                        c.setPrecioDiario(precio);
                        c.setEstado(estado);
                        c.setTipoCombustible(tipoCombustible);
                        c.setTransmision(transmision);
                        lista.add(c);

                    } else if (tipoActual.equals("CamionetaSUV")) {
                        ObjCamionetaSUV s = new ObjCamionetaSUV();
                        s.setPlaca(placa);
                        s.setMarca(marca);
                        s.setModelo(modelo);
                        s.setPrecioDiario(precio);
                        s.setEstado(estado);
                        s.setTraccion(traccion);
                        s.setCapacidadMaletero(capacidadMaletero);
                        lista.add(s);
                    }

                    // Resetear para el siguiente vehículo
                    tipoActual = null;
                    placa = marca = tipoCombustible = transmision = traccion = null;
                    modelo = 0;
                    precio = 0;
                    capacidadMaletero = 0;
                    estado = false;
                    continue;
                }

                // ── Leer cada campo ───────────────────────────────────────────
                if (linea.startsWith("Tipo: "))
                    tipoActual = linea.substring("Tipo: ".length());
                else if (linea.startsWith("Placa: "))
                    placa = linea.substring("Placa: ".length());
                else if (linea.startsWith("Marca: "))
                    marca = linea.substring("Marca: ".length());
                else if (linea.startsWith("Modelo: "))
                    modelo = Integer.parseInt(linea.substring("Modelo: ".length()));
                else if (linea.startsWith("PrecioDiario: "))
                    precio = Float.parseFloat(linea.substring("PrecioDiario: ".length()));
                else if (linea.startsWith("Estado: "))
                    estado = linea.substring("Estado: ".length()).equals("1");
                // — Solo CarroSedan —
                else if (linea.startsWith("TipoCombustible: "))
                    tipoCombustible = linea.substring("TipoCombustible: ".length());
                else if (linea.startsWith("Transmision: "))
                    transmision = linea.substring("Transmision: ".length());
                // — Solo CamionetaSUV —
                else if (linea.startsWith("Traccion: "))
                    traccion = linea.substring("Traccion: ".length());
                else if (linea.startsWith("CapacidadMaletero: "))
                    capacidadMaletero = Float.parseFloat(linea.substring("CapacidadMaletero: ".length()));
            }

            System.out.println("Archivo importado correctamente. Vehiculos cargados: " + lista.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
