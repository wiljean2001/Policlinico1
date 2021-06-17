package DBO;



/**
 * @author Se_Perdio_Mi_Cuenta
 * @version 1.0
 * @created 16-jun.-2021 5:43:32
 */
public class Recepcionista extends Usuario {
    
    private String IDRecepcionista, DNI, Sexo, Apellidos, Nombres;

    public Recepcionista(String IDRecepcionista, String DNI, String Sexo, String Apellidos, String Nombres, boolean Perfil, String Usuario, String Comtraseña) {
        super(Perfil, Usuario, Comtraseña);
        this.IDRecepcionista = IDRecepcionista;
        this.DNI = DNI;
        this.Sexo = Sexo;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
    }

    public String getIDRecepcionista() {
        return IDRecepcionista;
    }

    public void setIDRecepcionista(String IDRecepcionista) {
        this.IDRecepcionista = IDRecepcionista;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    
}//end Recepcionista