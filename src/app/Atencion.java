package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Atencion {

    private int idAtencion;
    private Cita cita;
    private LocalDate fechaAtencion;
    private String motivo;
    private List<Diagnostico> diagnosticos;

    public Atencion(Cita cita, LocalDate fechaAtencion, String motivo) {
        setCita(cita);
        setFechaAtencion(fechaAtencion);
        setMotivo(motivo);
        this.diagnosticos = new ArrayList<>();
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public Cita getCita() {
        return cita;
    }

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public String getMotivo() {
        return motivo;
    }

    public List<Diagnostico> getDiagnosticos() {
        return List.copyOf(diagnosticos);
    }

    public Paciente getPaciente() {
        return cita.getPaciente();
    }

    public Medico getMedico() {
        return cita.getMedico();
    }

    public Consultorio getConsultorio() {
        return cita.getConsultorio();
    }


    public void setIdAtencion(int idAtencion) {
        if (idAtencion <= 0) {
            throw new IllegalArgumentException("ID de atencion invalido");
        }
        this.idAtencion = idAtencion;
    }

    public void setCita(Cita cita) {
        if (cita == null) {
            throw new IllegalArgumentException("Cita obligatoria");
        }
        this.cita = cita;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        if (fechaAtencion == null || fechaAtencion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de atencion invalida");
        }

        this.fechaAtencion = fechaAtencion;
    }

    public void setMotivo(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("Motivo obligatorio");
        }
        this.motivo = motivo.trim();
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        if (diagnosticos == null) {
            throw new IllegalArgumentException("Lista de diagnosticos obligatoria");
        }

        this.diagnosticos = new ArrayList<>(diagnosticos);
    }


    public void agregarDiagnostico(Diagnostico diagnostico) {
        if (diagnostico == null) {
            throw new IllegalArgumentException("Diagnostico obligatorio");
        }

        if (!diagnosticos.contains(diagnostico)) {
            diagnosticos.add(diagnostico);
        }
    }

    public void quitarDiagnostico(Diagnostico diagnostico) {
        if (diagnostico == null) {
            throw new IllegalArgumentException("Diagnostico obligatorio");
        }

        diagnosticos.remove(diagnostico);
    }
}