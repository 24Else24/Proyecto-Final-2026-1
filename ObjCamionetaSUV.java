public class ObjCamionetaSUV extends ObjVehiculos{

    private String traccion;           
    private float capacidadMaletero;

    public ObjCamionetaSUV() {
    }
    
    public ObjCamionetaSUV(String placa, String marca, int modelo, float precioDiario, String estado, String traccion,
            float capacidadMaletero) {
        super(placa, marca, modelo, precioDiario, estado);
        this.traccion = traccion;
        this.capacidadMaletero = capacidadMaletero;
    }
    public String getTraccion() {
        return traccion;
    }
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
    public float getCapacidadMaletero() {
        return capacidadMaletero;
    }
    public void setCapacidadMaletero(float capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }   
}
