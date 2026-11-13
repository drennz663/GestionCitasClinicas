
package app;

import java.time.LocalTime;
import java.util.Objects;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

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

    public boolean seCruzaCon(Horario otro) {
        return medico == otro.medico
                && diaSemana == otro.diaSemana
                && horaInicio.isBefore(otro.horaFin)
                && horaFin.isAfter(otro.horaInicio);
    }
    public static void registrar(List<Horario> horarios, List<Medico> medicos,
                                 List<Consultorio> consultorios, Scanner sc) {
        if (medicos.isEmpty()) {
            System.out.println("No hay medicos registrados");
            return;
        }
        if (consultorios.isEmpty()) {
            System.out.println("No hay consultorios registrados");
            return;
        }

        System.out.print("DNI del medico: ");
        String dni = sc.nextLine().trim();

        Medico medico = null;
        for (Medico m : medicos) {
            if (m.getDni().equals(dni)) {
                medico = m;
                break;
            }
        }
        if (medico == null) {
            System.out.println("Medico no encontrado");
            return;
        }
        if (!medico.isActivo()) {
            System.out.println("No se puede asignar horario a un medico inactivo");
            return;
        }

        try {
            for (int i = 0; i < consultorios.size(); i++) {
                Consultorio c = consultorios.get(i);
                System.out.println((i + 1) + ". " + c.getNombre() + " - " + c.getDistrito());
            }
            System.out.print("Consultorio (numero): ");
            int pos = Integer.parseInt(sc.nextLine().trim());
            if (pos < 1 || pos > consultorios.size()) {
                System.out.println("Consultorio no valido");
                return;
            }
            Consultorio consultorio = consultorios.get(pos - 1);

            System.out.print("Dia (1=Lunes ... 7=Domingo): ");
            int dia = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Hora de inicio (HH:mm): ");
            LocalTime inicio = LocalTime.parse(sc.nextLine().trim());
            System.out.print("Hora de fin (HH:mm): ");
            LocalTime fin = LocalTime.parse(sc.nextLine().trim());

            Horario nuevo = new Horario(medico, consultorio, dia, inicio, fin);

            for (Horario h : horarios) {
                if (h.seCruzaCon(nuevo)) {
                    System.out.println("El horario se cruza con otro ya registrado para este medico");
                    return;
                }
            }

            horarios.add(nuevo);
            System.out.println("Horario registrado");

        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println("Formato invalido (use numeros y horas como 08:00)");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void consultarPorMedico(List<Horario> horarios, Scanner sc) {
        System.out.print("DNI del medico: ");
        String dni = sc.nextLine().trim();

        boolean hay = false;
        for (int dia = 1; dia <= 7; dia++) {
            for (Horario h : horarios) {
                if (h.medico.getDni().equals(dni) && h.diaSemana == dia) {
                    System.out.println(h.getNombreDia() + ": "
                            + h.horaInicio + " - " + h.horaFin
                            + " | Consultorio: " + h.consultorio.getNombre());
                    hay = true;
                }
            }
        }
        if (!hay) {
            System.out.println("No hay horarios para ese medico");
        }
    }
}
