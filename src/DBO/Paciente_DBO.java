package DBO;

import java.awt.Image;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import rojeru_san.rsdate.RSDateChooser;

public class Paciente_DBO {

    private String DNI_Paciente, telefono, Apellidos, nombres, Direccion, EstadoCivil;
    private Date FechadeNacimiento;
    private int edad;
    private char Sexo;
    private byte[] Foto;

    public Paciente_DBO(String DNI_Paciente, Date FechadeNacimiento, String telefono, String Apellidos, String nombres, String Direccion,
            char Sexo, int edad, String EstadoCivil, byte[] Foto) {
        this.DNI_Paciente = DNI_Paciente;
        this.FechadeNacimiento = FechadeNacimiento;
        this.telefono = telefono;
        this.Apellidos = Apellidos;
        this.nombres = nombres;
        this.Direccion = Direccion;
        this.EstadoCivil = EstadoCivil;
        if(edad==0){
        this.edad = calcularEdad(FechadeNacimiento);
        }else{
            this.edad = edad;
        }
        this.Sexo = Sexo;
        this.Foto = Foto;
    }

    public Paciente_DBO retornarPac() {
        return new Paciente_DBO(DNI_Paciente, FechadeNacimiento, telefono, Apellidos, nombres, Direccion, Sexo, edad, EstadoCivil, Foto);
    }

    /*Calcula la edad tomando como referencia la fecha actual con la fecha de  nació*/
    public int calcularEdad(Date fechaNaci) {
        Date hoy = new Date();
        int diff_año = hoy.getYear() - fechaNaci.getYear();
        JOptionPane.showMessageDialog(null,"Edad: > " +diff_año + " <","Edad:",1);
        return diff_año;
    }//Cierra método calcularEdad

    public String getDNI_Paciente() {
        return DNI_Paciente;
    }

    public void setDNI_Paciente(String DNI_Paciente) {
        this.DNI_Paciente = DNI_Paciente;
    }

    public Date getFechadeNacimiento() {
        return FechadeNacimiento;
    }

    public void setFechadeNacimiento(Date FechadeNacimiento) {
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

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }
}
