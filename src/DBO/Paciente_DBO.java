package DBO;

import java.awt.Image;
import java.sql.Date;

public class Paciente_DBO {
    private Date fecha;
    private String DNI_Paciente, FechadeNacimiento,telefono,Apellidos,
                   nombres, Direccion, EstadoCivil;
    private int edad;
    private char Sexo;
    private Image Foto;

    public Paciente_DBO(Date fecha, String DNI_Paciente, String FechadeNacimiento, String telefono, String Apellidos, String nombres, String Direccion, String EstadoCivil, int edad, char Sexo, Image Foto) {
        this.fecha = fecha;
        this.DNI_Paciente = DNI_Paciente;
        this.FechadeNacimiento = FechadeNacimiento;
        this.telefono = telefono;
        this.Apellidos = Apellidos;
        this.nombres = nombres;
        this.Direccion = Direccion;
        this.EstadoCivil = EstadoCivil;
        this.edad = edad;
        this.Sexo = Sexo;
        this.Foto = Foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDNI_Paciente() {
        return DNI_Paciente;
    }

    public void setDNI_Paciente(String DNI_Paciente) {
        this.DNI_Paciente = DNI_Paciente;
    }

    public String getFechadeNacimiento() {
        return FechadeNacimiento;
    }

    public void setFechadeNacimiento(String FechadeNacimiento) {
        this.FechadeNacimiento = FechadeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public Image getFoto() {
        return Foto;
    }

    public void setFoto(Image Foto) {
        this.Foto = Foto;
    }
    }

    