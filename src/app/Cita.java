package app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Cita {

    private int idCita;
    private Paciente paciente;
    private Turno turno;
    private String estado;

    public Cita(Paciente paciente, Turno turno, String estado) {
        setPaciente(paciente);
        setTurno(turno);
        setEstado(estado);
    }


    public int getIdCita() {
        return idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Turno getTurno() {
        return turno;
    }

    public String getEstado() {
        return estado;
    }

    public Medico getMedico() {
        return turno.getHorario().getMedico();
    }

    public Consultorio getConsultorio() {
        return turno.getHorario().getConsultorio();
    }

    public LocalDate getFecha() {
        return turno.getFecha();
    }

    public LocalTime getHora() {
        return turno.getHoraInicio();
    }
    

    public void setIdCita(int idCita) {
        if (idCita <= 0) {
            throw new IllegalArgumentException("ID de cita invalido");
        }
        this.idCita = idCita;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente obligatorio");
        }
        this.paciente = paciente;
    }

    public void setTurno(Turno turno) {
        if (turno == null) {
            throw new IllegalArgumentException("Turno obligatorio");
        }
        this.turno = turno;
    }

    public void setEstado(String estado) {
        if (estado == null ||
            (!estado.equals("PROGRAMADA") &&
             !estado.equals("CONFIRMADA") &&
             !estado.equals("ATENDIDA") &&
             !estado.equals("CANCELADA") &&
             !estado.equals("NO ASISTIO"))) {

            throw new IllegalArgumentException("Estado de cita invalido");
        }

        this.estado = estado;
    }

    public static void filtrarPorEstado(List<Cita> citas, Scanner sc) {
        System.out.print("Estado (PROGRAMADA, CONFIRMADA, ATENDIDA, CANCELADA, NO ASISTIO): ");
        String estado = sc.nextLine().trim();

        boolean encontrada = false;
        for (Cita c : citas) {
            if (c.getEstado().equalsIgnoreCase(estado)) {
                System.out.println("Cita " + c.getIdCita()
                        + " | Paciente: " + c.getPaciente().getNombreCompleto()
                        + " | Medico: " + c.getMedico().getNombreCompleto()
                        + " | " + c.getFecha() + " " + c.getHora()
                        + " | " + c.getEstado());
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No hay citas con ese estado");
        }
    }




}