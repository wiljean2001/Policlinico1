

/**
 * @author Se_Perdio_Mi_Cuenta
 * @version 1.0
 * @created 16-jun.-2021 5:43:32
 */
public class Medicos extends Usuario {

	private string  IDMedico;
	private int DNI;
	private String Apellidos;
	private String Nombre;
	private String Sexo;
	private int Telefono;
	private string Especialidad;
	private String Direccion;
	public Historia Clinica m_Historia Clinica;

	public Medicos(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getIDMedico(){
		return "";
	}

	public boolean getPerfil(){
		return false;
	}

	public String getEspecialidad(){
		return "";
	}

	/**
	 * 
	 * @param Perfil
	 */
	public void setPerfil(boolean Perfil){

	}

	public int getTelefono(){
		return 0;
	}

	public String getUsuario(){
		return "";
	}

	public String getSexo(){
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

	public String getNombre(){
		return "";
	}

	public String getDireccion(){
		return "";
	}

	/**
	 * 
	 * @param Contraseña
	 */
	public void setContraseña(String Contraseña){

	}

	public int getDNI(){
		return 0;
	}

	/**
	 * 
	 * @param IDMedico
	 */
	public void setIDMedico(String IDMedico){

	}

	/**
	 * 
	 * @param especialidad
	 */
	public void setEspecialidad(String especialidad){

	}

	/**
	 * 
	 * @param telf
	 */
	public void setTelefono(int telf){

	}

	/**
	 * 
	 * @param sexo
	 */
	public void setSexo(String sexo){

	}

	/**
	 * 
	 * @param Nombre
	 */
	public void setNombre(String Nombre){

	}

	/**
	 * 
	 * @param Direccion
	 */
	public void setDireccion(String Direccion){

	}

	/**
	 * 
	 * @param DNI
	 */
	public void setDNI(int DNI){

	}

	/**
	 * 
	 * @param Usuario
	 * @param Contraseña
	 */
	public boolean BuscarUsuario(String Usuario, String Contraseña){
		return false;
	}
}//end Medicos