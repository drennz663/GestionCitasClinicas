
package app;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

	// VALIDAR FORMATO DE HORA
	public static LocalTime validarFormatoHora(Scanner sc, String mensaje) {

		while (true) {
			try {
				System.out.print(mensaje);
				return LocalTime.parse(sc.nextLine().trim());

			} catch (java.time.format.DateTimeParseException e) {
				System.out.println("Hora invalida. Ejemplo: 08:00");
			}
		}
	}

	// VALIDAR CRUCE CON OTROS HORARIOS
	public static boolean validarCruce(List<Horario> horarios, Horario actual, int dia, LocalTime inicio, LocalTime fin) {
		for (Horario h : horarios) {
			if (h != actual && h.getMedico().getDni().equals(actual.getMedico().getDni()) 
					&& h.getDiaSemana() == dia
					&& inicio.isBefore(h.getHoraFin()) 
					&& fin.isAfter(h.getHoraInicio())) {
				return true;
			}
		}
		return false;
	}
	

	

	public static void modificarHorario(List<Medico> medicos, List<Horario> horarios, List<Turno> turnos, Scanner sc) {
		// BUSCAR MEDICO
		while (true) {
			System.out.print("\nDNI del medico (0 para volver): ");
			String dni = sc.nextLine().trim();

			if (dni.equals("0"))
				return;

			if (!Persona.validarDNI(dni)) {
				System.out.println("El DNI debe tener 8 digitos");
				continue;
			}

			Medico medico = Medico.obtenerMedicoPorDNI(medicos, dni);

			if (medico == null) {
				System.out.println("El medico no existe");
				continue;
			}

			// OBTENER HORARIOS
			List<Horario> encontrados = new ArrayList<>();

			for (Horario h : horarios) {
				if (h.getMedico() == medico)
					encontrados.add(h);
			}

			if (encontrados.isEmpty()) {
				System.out.println("El medico no tiene horarios");
				continue;
			}

			// SELECCIONAR HORARIO
			while (true) {
				System.out.println("\n=== HORARIOS DEL MEDICO ===");

				for (int i = 0; i < encontrados.size(); i++) {
					Horario h = encontrados.get(i);
					System.out.println((i + 1) + ". " + h.getNombreDia() + " | " + h.getHoraInicio() + " - " + h.getHoraFin());
				}

				int opcion = Principal.leerEntero("Seleccione horario (0 para volver): ");

				if (opcion == 0)
					break;

				if (opcion < 1 || opcion > encontrados.size()) {
					System.out.println("Opcion invalida");
					continue;
				}

				Horario horario = encontrados.get(opcion - 1);

				// VALIDAR TURNOS ASOCIADOS
				boolean tieneTurnos = false;

				for (Turno t : turnos) {
					if (t.getHorario() == horario) {
						tieneTurnos = true;
						break;
					}
				}

				if (tieneTurnos) {
					System.out.println("No se puede modificar: existen turnos asociados");
					continue;
				}

				// INGRESAR NUEVO HORARIO
				int dia;

				while (true) {
					dia = Principal.leerEntero("Nuevo dia (1=Lunes, 7=Domingo): ");

					if (dia >= 1 && dia <= 7)
						break;

					System.out.println("Dia invalido");
				}

				LocalTime inicio, fin;

				while (true) {
					inicio = validarFormatoHora(sc, "Hora inicio (HH:mm): ");
					fin = validarFormatoHora(sc, "Hora fin (HH:mm): ");

					if (inicio.isBefore(fin))
						break;

					System.out.println("La hora de inicio debe ser menor a la de fin");
				}

				// VALIDAR CRUCES DE HORARIOS
				if (validarCruce(horarios, horario, dia, inicio, fin)) {
					System.out.println("El medico ya tiene un horario que se cruza");
					continue;
				}

				// GUARDAR CAMBIOS
				horario.setDiaSemana(dia);
				horario.setHoras(inicio, fin);

				System.out.println("\nHorario modificado correctamente");
				System.out.println("Nuevo horario: " + horario.getNombreDia() + " | " + horario.getHoraInicio() + " - " + horario.getHoraFin());
			}
		}
	}
}