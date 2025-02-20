package umca.semanacuatro.calculadora_articulos_marchamo.dto;

public class MarchamoDto {

    private Double valorFiscal;
    private String tipoVehiculo;
    private String conoceFigueres;
    private Double resultadoMarchamo;

    public MarchamoDto() {
    }

    public Double getValorFiscal() {
        return valorFiscal;
    }

    public void setValorFiscal(Double valorFiscal) {
        this.valorFiscal = valorFiscal;

    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getConoceFigueres() {
        return conoceFigueres;
    }

    public void setConoceFigueres(String conoceFigueres) {
        this.conoceFigueres = conoceFigueres;
    }

    public Double getResultadoMarchamo() {
        return resultadoMarchamo;
    }

    public void setResultadoMarchamo(Double resultadoMarchamo) {
        this.resultadoMarchamo = resultadoMarchamo;
    }

}
