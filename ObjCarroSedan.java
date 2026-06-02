public class ObjCarroSedan extends ObjVehiculos{
    
    private String tipoCombustible;
    private String transmision;

    public ObjCarroSedan() {
    }

    public ObjCarroSedan(String placa, String marca, int modelo, float precioDiario, Boolean estado,
            String tipoCombustible, String transmision) {
        super(placa, marca, modelo, precioDiario, estado);
        this.tipoCombustible = tipoCombustible;
        this.transmision = transmision;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
}
