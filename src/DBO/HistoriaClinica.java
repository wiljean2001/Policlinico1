package DBO;

//import controlador.Recepcionista;
import java.sql.Date;

/**
 * @author Se_Perdio_Mi_Cuenta
 * @version 1.0
 * @created 16-jun.-2021 5:43:31
 */
public class HistoriaClinica {

    private String CodigoHC;
    private Date FechaCreacion;
    private String ConsumeAlcohol;
    private String ConsumeTabaco;
    private String ConsumeDrogas;
    private String ConsumeInfusiones;
    private String Alimentacion;
    private String Diuresis;
    private String Catarsis;
    private String Sueño;
    private String EnfermedadActual;

    public HistoriaClinica(String CodigoHC, Date FechaCreacion, String ConsumeAlcohol, String ConsumeTabaco, String ConsumeDrogas, String ConsumeInfusiones, String Alimentacion, String Diuresis, String Catarsis, String Sueño, String EnfermedadActual) {
        this.CodigoHC = CodigoHC;
        this.FechaCreacion = FechaCreacion;
        this.ConsumeAlcohol = ConsumeAlcohol;
        this.ConsumeTabaco = ConsumeTabaco;
        this.ConsumeDrogas = ConsumeDrogas;
        this.ConsumeInfusiones = ConsumeInfusiones;
        this.Alimentacion = Alimentacion;
        this.Diuresis = Diuresis;
        this.Catarsis = Catarsis;
        this.Sueño = Sueño;
        this.EnfermedadActual = EnfermedadActual;
    }

    public String getCodigoHC() {
        return CodigoHC;
    }

    public void setCodigoHC(String CodigoHC) {
        this.CodigoHC = CodigoHC;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getConsumeAlcohol() {
        return ConsumeAlcohol;
    }

    public void setConsumeAlcohol(String ConsumeAlcohol) {
        this.ConsumeAlcohol = ConsumeAlcohol;
    }

    public String getConsumeTabaco() {
        return ConsumeTabaco;
    }

    public void setConsumeTabaco(String ConsumeTabaco) {
        this.ConsumeTabaco = ConsumeTabaco;
    }

    public String getConsumeDrogas() {
        return ConsumeDrogas;
    }

    public void setConsumeDrogas(String ConsumeDrogas) {
        this.ConsumeDrogas = ConsumeDrogas;
    }

    public String getConsumeInfusiones() {
        return ConsumeInfusiones;
    }

    public void setConsumeInfusiones(String ConsumeInfusiones) {
        this.ConsumeInfusiones = ConsumeInfusiones;
    }

    public String getAlimentacion() {
        return Alimentacion;
    }

    public void setAlimentacion(String Alimentacion) {
        this.Alimentacion = Alimentacion;
    }

    public String getDiuresis() {
        return Diuresis;
    }

    public void setDiuresis(String Diuresis) {
        this.Diuresis = Diuresis;
    }

    public String getCatarsis() {
        return Catarsis;
    }

    public void setCatarsis(String Catarsis) {
        this.Catarsis = Catarsis;
    }

    public String getSueño() {
        return Sueño;
    }

    public void setSueño(String Sueño) {
        this.Sueño = Sueño;
    }

    public String getEnfermedadActual() {
        return EnfermedadActual;
    }

    public void setEnfermedadActual(String EnfermedadActual) {
        this.EnfermedadActual = EnfermedadActual;
    }

   
    
}//end Historia Clinica
