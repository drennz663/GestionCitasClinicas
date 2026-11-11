package app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {

    private static int contador = 0;

    private String codigo;
    private Medico medico;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean disponible;

    public Horario(Medico medico, LocalDate fecha, LocalTime hora) {
        setMedico(medico);
        setFecha(fecha);
        setHora(hora);
        this.disponible = true;
        this.codigo = String.format("HOR%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
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
    public boolean isDisponible() {
        return disponible;
    }

    public void setMedico(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico obligatorio");
        }
        this.medico = medico;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("Fecha obligatoria");
        }
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        if (hora == null) {
            throw new IllegalArgumentException("Hora obligatoria");
        }
        this.hora = hora;
    }

    public void reservar() {
        if (!disponible) {
            throw new IllegalStateException("El horario ya está reservado");
        }
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }

    // RF-15: consultar horarios disponibles por especialidad
    public static void consultarDisponiblesPorEspecialidad(ArrayList<Horario> horarios, ArrayList<Especialidad> especialidades) {
        for (int i = 0; i < especialidades.size(); i++) {
            System.out.println((i + 1) + ". " + especialidades.get(i).getDescripcion());
        }

        int opcion = Principal.leerEntero("Seleccione una especialidad: ");
        if (opcion < 1 || opcion > especialidades.size()) {
            System.out.println("Especialidad no valida");
            return;
        }

        Especialidad especialidad = especialidades.get(opcion - 1);
        boolean hay = false;
        for (Horario h : horarios) {
            if (h.disponible && h.medico.getEspecialidad() == especialidad) {
                System.out.println(h.codigo + " | " + h.fecha + " " + h.hora + " | "
                        + h.medico.getNombresMedico() + " " + h.medico.getApellidosMedico());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay horarios disponibles");
        }
    }
}


