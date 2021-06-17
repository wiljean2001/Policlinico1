package DBO;



/**
 * @author Se_Perdio_Mi_Cuenta
 * @version 1.0
 * @created 16-jun.-2021 5:43:32
 */
public class Usuario {

    private boolean Perfil;
    private String Usuario;
    private String Comtraseña;

    public Usuario(boolean Perfil, String Usuario, String Comtraseña) {
        this.Perfil = Perfil;
        this.Usuario = Usuario;
        this.Comtraseña = Comtraseña;
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
	
	
}//end Usuario