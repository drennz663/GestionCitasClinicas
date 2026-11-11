
package app;

import java.time.LocalTime;
import java.util.Objects;

public class Horario {

    private int idHorario;
    private Medico medico;
    private Consultorio consultorio;
    private int diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Horario(Medico medico, Consultorio consultorio, int diaSemana, LocalTime horaInicio, LocalTime horaFin) {
        setMedico(medico);
        setConsultorio(consultorio);
        setDiaSemana(diaSemana);
        setHoras(horaInicio, horaFin);
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        if (idHorario <= 0)
            throw new IllegalArgumentException("IdHorario invalido");

        this.idHorario = idHorario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = Objects.requireNonNull(medico, "Medico obligatorio");
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = Objects.requireNonNull( consultorio, "Consultorio obligatorio");
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        if (diaSemana < 1 || diaSemana > 7)
            throw new IllegalArgumentException("DiaSemana debe estar entre 1 y 7");

        this.diaSemana = diaSemana;
    }

    public String getNombreDia() {
        String[] dias = {"Lunes", "Martes", "Miercoles","Jueves", "Viernes", "Sabado", "Domingo"};

        return dias[diaSemana - 1];
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoras(LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio == null || horaFin == null || !horaInicio.isBefore(horaFin)) {
            throw new IllegalArgumentException("Rango de horas invalido");
        }

        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
}
