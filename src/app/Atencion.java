
package app;

import java.time.LocalDate;

public class Atencion {

    private static int contador = 0;
    private String codigo;
    private LocalDate fechaAtencion;
    private Paciente paciente;
    private Medico medico;
    private Consultorio consultorio;
    private Diagnostico diagnostico;
    private String motivo;

    public Atencion(LocalDate fechaAtencion, Paciente paciente, Medico medico, Consultorio consultorio, Diagnostico diagnostico, String motivo) {
        setFechaAtencion(fechaAtencion);
        setPaciente(paciente);
        setMedico(medico);
        setConsultorio(consultorio);
        setDiagnostico(diagnostico);
        setMotivo(motivo);
        this.codigo = String.format("ATE%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }
    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public Consultorio getConsultorio() {
        return consultorio;
    }
    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
    public String getMotivo() {
        return motivo;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        if (fechaAtencion == null || fechaAtencion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de atención inválida");
        }
        this.fechaAtencion = fechaAtencion;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente obligatorio");
        }
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico obligatorio");
        }
        this.medico = medico;
    }

    public void setConsultorio(Consultorio consultorio) {
        if (consultorio == null) {
            throw new IllegalArgumentException("Consultorio obligatorio");
        }
        this.consultorio = consultorio;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        if (diagnostico == null) {
            throw new IllegalArgumentException("Diagnóstico obligatorio");
        }
        this.diagnostico = diagnostico;
    }

    public void setMotivo(String motivo) {
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("Motivo vacío");
        }
        this.motivo = motivo;
    }
}
