package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    public static final String PROGRAMADA = "Programada";
    public static final String CONFIRMADA = "Confirmada";
    public static final String ATENDIDA = "Atendida";
    public static final String CANCELADA = "Cancelada";
    public static final String NO_ASISTIO = "No asistió";

    private static int contador = 0;

    private String codigo;
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;
    private String motivoCancelacion;

    public Cita(Paciente paciente, Medico medico, LocalDate fecha, LocalTime hora) {
        setPaciente(paciente);
        setMedico(medico);
        setFecha(fecha);
        setHora(hora);
        this.estado = PROGRAMADA;
        this.motivoCancelacion = null;
        this.codigo = String.format("CIT%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public LocalTime getHora() {
        return hora;
    }
    public String getEstado() {
        return estado;
    }
    public String getMotivoCancelacion() {
        return motivoCancelacion;
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

    public void setFecha(LocalDate fecha) {
        if (fecha == null || fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser pasada");
        }
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        if (hora == null) {
            throw new IllegalArgumentException("Hora obligatoria");
        }
        this.hora = hora;
    }

    public void confirmar() {
        if (!estado.equals(PROGRAMADA)) {
            throw new IllegalStateException("Solo se puede confirmar una cita Programada (estado actual: " + estado + ")");
        }
        estado = CONFIRMADA;
    }

    public void marcarAtendida() {
        if (!estado.equals(CONFIRMADA)) {
            throw new IllegalStateException("Solo se puede atender una cita Confirmada (estado actual: " + estado + ")");
        }
        estado = ATENDIDA;
    }

    public void cancelar(String motivo) {
        if (!estado.equals(PROGRAMADA) && !estado.equals(CONFIRMADA)) {
            throw new IllegalStateException("No se puede cancelar una cita en estado " + estado);
        }
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("Debe indicar el motivo de la cancelación");
        }
        estado = CANCELADA;
        motivoCancelacion = motivo;
    }

    public void marcarNoAsistio() {
        if (!estado.equals(PROGRAMADA) && !estado.equals(CONFIRMADA)) {
            throw new IllegalStateException("No se puede marcar 'No asistió' una cita en estado " + estado);
        }
        estado = NO_ASISTIO;
    }

    public void mostrarCita() {
        System.out.println(codigo + " | " + fecha + " " + hora
                + " | Paciente: " + paciente.getNombreCompleto()
                + " | Medico: " + medico.getNombresMedico() + " " + medico.getApellidosMedico()
                + " | Estado: " + estado);
        if (motivoCancelacion != null) {
            System.out.println("    Motivo de cancelacion: " + motivoCancelacion);
        }
    }
}