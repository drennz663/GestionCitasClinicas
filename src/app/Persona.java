
package app;

import java.time.LocalDate;

public abstract class Persona {

    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String sexo;

    public Persona(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String sexo) {
        setDni(dni);
        setNombres(nombres);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setFechaNacimiento(fechaNacimiento);
        setSexo(sexo);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe tener 8 digitos");
        }
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("Nombres obligatorios");
        }
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if (apellidoPaterno == null ||
            apellidoPaterno.isBlank()) {
            throw new IllegalArgumentException("Apellido paterno obligatorio");
        }
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        if (apellidoMaterno == null ||
            apellidoMaterno.isBlank()) {
            throw new IllegalArgumentException("Apellido materno obligatorio");
        }
        this.apellidoMaterno = apellidoMaterno;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(
            LocalDate fechaNacimiento) {

        if (fechaNacimiento == null ||
            fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento invalida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        if (sexo == null ||
            (!sexo.equalsIgnoreCase("M") &&
             !sexo.equalsIgnoreCase("F"))) {
            throw new IllegalArgumentException("Sexo debe ser M o F");
        }
        this.sexo = sexo.toUpperCase();
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    public abstract String mostrarInformacion();
}
