package app;

import java.util.ArrayList;

public class Cita {

    private static int contador = 0;

    private String codigo;
    private Paciente paciente;
    private Horario horario;
    private EstadoCita estado;

    public Cita(Paciente paciente, Horario horario) {
        setPaciente(paciente);
        if (horario == null) {
            throw new IllegalArgumentException("Horario obligatorio");
        }
        horario.reservar();
        this.horario = horario;
        this.estado = EstadoCita.PENDIENTE;
        this.codigo = String.format("CIT%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Horario getHorario() {
        return horario;
    }

    public Medico getMedico() {
        return horario.getMedico();
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente obligatorio");
        }
        this.paciente = paciente;
    }

    public void setEstado(EstadoCita estado) {
        if (estado == null) {
            throw new IllegalArgumentException("Estado obligatorio");
        }
        if (estado == EstadoCita.CANCELADA) {
            horario.liberar();
        }
        this.estado = estado;
    }

    // RF-25: filtrar las citas por estado
    public static void filtrarCitasPorEstado(ArrayList<Cita> citas) {
        EstadoCita[] estados = EstadoCita.values();
        for (int i = 0; i < estados.length; i++) {
            System.out.println((i + 1) + ". " + estados[i]);
        }

        int opcion = Principal.leerEntero("Seleccione un estado: ");
        if (opcion < 1 || opcion > estados.length) {
            System.out.println("Estado no valido");
            return;
        }

        EstadoCita estado = estados[opcion - 1];
        boolean hay = false;
        for (Cita c : citas) {
            if (c.estado == estado) {
                System.out.println(c.codigo + " | " + c.paciente.getNombres() + " " + c.paciente.getApellidoPaterno()
                        + " | " + c.getMedico().getNombresMedico() + " " + c.getMedico().getApellidosMedico()
                        + " | " + c.horario.getFecha() + " " + c.horario.getHora());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay citas en este estado");
        }
    }
}





