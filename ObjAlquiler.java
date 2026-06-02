public class ObjAlquiler {
    private String IdContrato;
    private String cedulaCliente;
    private String placaVehiculo;
    private String FechaInicio;
    private String FechaFin;
    private int diasAlquiler;
    private float totalPagar;
    private boolean estado;

    public ObjAlquiler() {
    }

    public ObjAlquiler(String cedulaCliente, String placaVehiculo, int diasAlquiler, float totalPagar, boolean estado) {
        this.cedulaCliente = cedulaCliente;
        this.placaVehiculo = placaVehiculo;
        this.diasAlquiler = diasAlquiler;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public String getIdContrato() {
        return IdContrato;
    }

    public void setIdContrato(String idContrato) {
        IdContrato = idContrato;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
