package DBO;

//import controlador.Recepcionista;
import java.sql.Date;

/**
 * @author Se_Perdio_Mi_Cuenta
 * @version 1.0
 * @created 16-jun.-2021 5:43:31
 */
public class HistoriaClinica {

    private int CodigoHC;
    private Date FechaCreacion;
    public Recepcionista m_Recepcionista;
    private int IDAnamnesis;
    private String ConsumeAlcohol;
    private String ConsumeTabaco;
    private String ConsumeDrogas;
    private String ConsumeInfusiones;
    private String Alimentacion;
    private String Diuresis;
    private String Catarsis;
    private String Sueño;
    private String EnfermedadActual;

    public HistoriaClinica() {

    }

    public void finalize() {

    }

    public int getCodigoHC() {
        return CodigoHC;
    }

    public void setCodigoHC(int CodigoHC) {
        this.CodigoHC = CodigoHC;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Recepcionista getM_Recepcionista() {
        return m_Recepcionista;
    }

    public void setM_Recepcionista(Recepcionista m_Recepcionista) {
        this.m_Recepcionista = m_Recepcionista;
    }

    public int GenerarCodigoHC() {
        return 0;
    }
}//end Historia Clinica
