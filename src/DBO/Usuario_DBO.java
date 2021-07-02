package DBO;

public class Usuario_DBO {

    private String IDMedico, DNI, Apellidos, Nombres, Genero, Especialidad;
    private boolean Perfil;
    private String Usuario;
    private String Comtraseña;

    public Usuario_DBO(String IDMedico, String DNI, String Apellidos, String Nombres,
            String Genero, String Especialidad, boolean Perfil, String Usuario, String Comtraseña) {
        this.IDMedico = IDMedico;
        this.DNI = DNI;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.Genero = Genero;
        this.Especialidad = Especialidad;
        this.Perfil = Perfil;
        this.Usuario = Usuario;
        this.Comtraseña = Comtraseña;
    }

    public Usuario_DBO(String Usuario, String Comtraseña) {
        this.Usuario = Usuario;
        this.Comtraseña = Comtraseña;
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
        return Genero;
    }

    public void setSexo(String Genero) {
        this.Genero = Genero;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public boolean isPerfil() {
        return Perfil;
    }

    public void setPerfil(boolean Perfil) {
        this.Perfil = Perfil;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getComtraseña() {
        return Comtraseña;
    }

    public void setComtraseña(String Comtraseña) {
        this.Comtraseña = Comtraseña;
    }

    

}//end Usuario_DBO
