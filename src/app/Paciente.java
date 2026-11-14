
package app;

import java.time.LocalDate;


public class Paciente {

    private static int contador = 0;

    private String codigo;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String direccion;
    private Seguro seguro;

    public Paciente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String sexo, String direccion, Seguro seguro) {

        setDni(dni);
        setNombres(nombres);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setFechaNacimiento(fechaNacimiento);
        setSexo(sexo);
        setDireccion(direccion);
        setSeguro(seguro);
        this.codigo = String.format("PAC%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDni() {
        return dni;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getSexo() {
        return sexo;
    }
    public String getDireccion() {
        return direccion;
    }
    public Seguro getSeguro() {
        return seguro;
    }

    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos");
        }
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("Nombres vacíos");
        }
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if (apellidoPaterno == null || apellidoPaterno.isBlank()) {
            throw new IllegalArgumentException("Apellido paterno vacío");
        }
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        if (apellidoMaterno == null || apellidoMaterno.isBlank()) {
            throw new IllegalArgumentException("Apellido materno vacío");
        }
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        if (sexo == null ||
                (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F"))) {
            throw new IllegalArgumentException("Sexo debe ser M o F");
        }
        this.sexo = sexo.toUpperCase();
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Dirección vacía");
        }
        this.direccion = direccion;
    }

    public void setSeguro(Seguro seguro) {
        if (seguro == null) {
            throw new IllegalArgumentException("Debe seleccionar un seguro");
        }
        this.seguro = seguro;
    }

    public void actualizarDatos(String nuevaDireccion, Seguro nuevoSeguro) { // Tipo Parámetro
        if (nuevaDireccion != null && !nuevaDireccion.isBlank()) {
            setDireccion(nuevaDireccion);
        }
        if (nuevoSeguro != null) {
            setSeguro(nuevoSeguro);
}
