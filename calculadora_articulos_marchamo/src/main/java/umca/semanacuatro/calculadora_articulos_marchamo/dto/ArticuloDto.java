package umca.semanacuatro.calculadora_articulos_marchamo.dto;

public class ArticuloDto {

    private Double costo;
    private Double porcentajeGanancia;
    private Boolean aplicaImpuestoVentas;
    private Double impuestoVentas;
    private Double montoGanancia;
    private Double precioFinal;

    public ArticuloDto() {
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(Double porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public Boolean getAplicaImpuestoVentas() {
        return aplicaImpuestoVentas;
    }

    public void setAplicaImpuestoVentas(Boolean aplicaImpuestoVentas) {
        this.aplicaImpuestoVentas = aplicaImpuestoVentas;
    }

    public Double getImpuestoVentas() {
        return impuestoVentas;
    }

    public void setImpuestoVentas(Double impuestoVentas) {
        this.impuestoVentas = impuestoVentas;
    }

    public Double getMontoGanancia() {
        return montoGanancia;
    }

    public void setMontoGanancia(Double montoGanancia) {
        this.montoGanancia = montoGanancia;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

}
