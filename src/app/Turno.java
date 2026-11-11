package app;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private int idTurno;
    private Horario horario;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estado;

    public Turno(Horario horario, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String estado) {
        setHorario(horario);
        setFecha(fecha);
        setHoras(horaInicio, horaFin);
        setEstado(estado);
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        if (idTurno <= 0)
            throw new IllegalArgumentException("ID de turno invalido");

        this.idTurno = idTurno;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        if (horario == null)
            throw new IllegalArgumentException("Horario obligatorio");

        if (fecha != null &&
            fecha.getDayOfWeek().getValue() != horario.getDiaSemana())
            throw new IllegalArgumentException("La fecha no coincide con el dia del horario");

        if (horaInicio != null && horaFin != null && (horaInicio.isBefore(horario.getHoraInicio()) || horaFin.isAfter(horario.getHoraFin())))
            throw new IllegalArgumentException("Turno fuera del horario del medico");

        this.horario = horario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null)
            throw new IllegalArgumentException("Fecha obligatoria");

        if (horario != null && fecha.getDayOfWeek().getValue() != horario.getDiaSemana())
            throw new IllegalArgumentException("La fecha no coincide con el dia del horario");

        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoras(LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio == null || horaFin == null)
            throw new IllegalArgumentException("Horas obligatorias");

        if (!horaInicio.isBefore(horaFin))
            throw new IllegalArgumentException("La hora de inicio debe ser menor a la hora de fin");

        if (horario != null && (horaInicio.isBefore(horario.getHoraInicio()) || horaFin.isAfter(horario.getHoraFin())))
            throw new IllegalArgumentException("Turno fuera del horario del medico");

        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (!"DISPONIBLE".equals(estado) && !"RESERVADO".equals(estado) && !"BLOQUEADO".equals(estado))
            throw new IllegalArgumentException("Estado de turno invalido");

        this.estado = estado;
    }
}