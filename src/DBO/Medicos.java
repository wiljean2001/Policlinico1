package DBO;

public class Medicos extends Usuario {

    private String IDMedico,DNI,Apellidos, Nombres, Sexo, Telefono, Especialidad,
            Direccion;

    public Medicos(String IDMedico, String DNI, String Apellidos, String Nombres, String Sexo, String Telefono, String Especialidad, String Direccion, boolean Perfil, String Usuario, String Comtraseña) {
        super(Perfil, Usuario, Comtraseña);
        this.IDMedico = IDMedico;
        this.DNI = DNI;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Especialidad = Especialidad;
        this.Direccion = Direccion;
    }
    public Medicos(boolean Perfil, String Usuario, String Comtraseña){
        super(Perfil, Usuario, Comtraseña);
    }

    

    public String getIDMedico() {
        return IDMedico;
    }

    public void setIDMedico(String IDMedico) {
        this.IDMedico = IDMedico;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
	

	
}//end Medicos