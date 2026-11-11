package app;

import java.time.LocalDate;

public class Paciente extends Persona {

    private int idPaciente;
    private String direccion;
    private String telefono;
    private String correo;
    private Seguro seguro;

    public Paciente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String sexo, String direccion, String telefono, String correo, Seguro seguro) {
        super(dni, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
        setSeguro(seguro);
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        if (idPaciente <= 0) {
            throw new IllegalArgumentException("ID de paciente invalido");
        }
        this.idPaciente = idPaciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Direccion obligatoria");
        }
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("Telefono obligatorio");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("Correo obligatorio");
        }
        this.correo = correo;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        if (seguro == null) {
            throw new IllegalArgumentException("Seguro obligatorio");
        }
        this.seguro = seguro;
    }

    @Override
    public String mostrarInformacion() {
        return "PACIENTE: " + getNombreCompleto()
             + " | DNI: " + getDni()
             + " | Seguro: " + seguro.getNombreSeguro();
    }
}
