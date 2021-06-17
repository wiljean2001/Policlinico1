package DBO;

import java.awt.Image;

public class Paciente_DBO {
    private int DNI, telefono, edad;
    private String Apellidos, nombres, Direccion, EstadoCivil;
    private char Sexo;
    private Image Foto;

    public Paciente_DBO(int DNI, int telefono, int edad, String Apellidos, String nombres, String Direccion, String EstadoCivil, char Sexo, Image Foto) {
        this.DNI = DNI;
        this.telefono = telefono;
        this.edad = edad;
        this.Apellidos = Apellidos;
        this.nombres = nombres;
        this.Direccion = Direccion;
        this.EstadoCivil = EstadoCivil;
        this.Sexo = Sexo;
        this.Foto = Foto;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
