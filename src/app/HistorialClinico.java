package app;

import java.time.LocalDateTime;

public class HistorialClinico {

    private int idHistorial;
    private Paciente paciente;
    private LocalDateTime fechaCreacion;
    private String antecedentes;
    private String tipoSangre;

    public HistorialClinico(Paciente paciente, LocalDateTime fechaCreacion, String antecedentes, String tipoSangre) {
        setPaciente(paciente);
        setFechaCreacion(fechaCreacion);
        setAntecedentes(antecedentes);
        setTipoSangre(tipoSangre);
    }


    public int getIdHistorial() {
        return idHistorial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }


    public void setIdHistorial(int idHistorial) {
        if (idHistorial <= 0) {
            throw new IllegalArgumentException("ID de historial invalido");
        }
        this.idHistorial = idHistorial;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente obligatorio");
        }
        this.paciente = paciente;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        if (fechaCreacion == null || fechaCreacion.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Fecha de creacion invalida");
        }
        this.fechaCreacion = fechaCreacion;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public void setTipoSangre(String tipoSangre) {
        if (tipoSangre != null && tipoSangre.length() > 10) {
            throw new IllegalArgumentException("El tipo de sangre no puede superar 10 caracteres");
        }
        this.tipoSangre = tipoSangre;
    }
}