

/**
 * @author Se_Perdio_Mi_Cuenta
 * @version 1.0
 * @created 16-jun.-2021 5:43:32
 */
public class Recepcionista extends Usuario {

	private string IDRecepcionista;
	private int DNI;
	private String Sexo;
	private String Apellidos;
	private String Nombre;
	public Boleta m_Boleta;

	public Recepcionista(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public int getDNI(){
		return 0;
	}

	public boolean getPerfil(){
		return false;
	}

	public String getSexo(){
		return "";
	}

	/**
	 * 
	 * @param Perfil
	 */
	public void setPerfil(boolean Perfil){

	}

	public String getApellido(){
		return "";
	}

	public String getUsuario(){
		return "";
	}

	public String getNombre(){
		return "";
	}

	/**
	 * 
	 * @param Usuario
	 */
	public void setUsuario(String Usuario){

	}

	public String getContraseña(){
		return "";
	}

	/**
	 * 
	 * @param IDRecepcionista
	 */
	public void setIDRecepcionista(String IDRecepcionista){

	}

	/**
	 * 
	 * @param Contraseña
	 */
	public void setContraseña(String Contraseña){

	}

	/**
	 * 
	 * @param DNI
	 */
	public void setDNI(int DNI){

	}

	/**
	 * 
	 * @param sexo
	 */
	public void setSexo(String sexo){

	}

	/**
	 * 
	 * @param Apellido
	 */
	public void setApellido(String Apellido){

	}

	public void getIDRecepcionista(){

	}

	/**
	 * 
	 * @param Nombre
	 */
	public void setNombre(String Nombre){

	}

	/**
	 * 
	 * @param Usuario
	 * @param Contraseña
	 */
	public boolean BuscarUsuario(String Usuario, String Contraseña){
		return false;
	}
}//end Recepcionista