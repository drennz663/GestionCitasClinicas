
package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Medico extends Persona {

	private int idMedico;
	private String cmp;
	private boolean activo = true;
	private List<Especialidad> especialidades;

	public Medico(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String sexo, String cmp) {
		super(dni, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo);
		setCmp(cmp);
		this.especialidades = new ArrayList<>();
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		if (idMedico <= 0) {
			throw new IllegalArgumentException("ID de medico invalido");
		}
		this.idMedico = idMedico;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		if (cmp == null || cmp.isBlank()) {
			throw new IllegalArgumentException("CMP obligatorio");
		}
		this.cmp = cmp;
	}

	public List<Especialidad> getEspecialidades() {
		return List.copyOf(especialidades);
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
	    if (especialidades == null) {
	        throw new IllegalArgumentException("La lista de especialidades no puede ser nula"
	        );
	    }
	    if (especialidades.contains(null)) {
	        throw new IllegalArgumentException("La lista no puede contener especialidades nulas"
	        );
	    }
	    this.especialidades = new ArrayList<>(
	        new java.util.LinkedHashSet<>(especialidades)
	    );
	}
	
	public void agregarEspecialidad(Especialidad especialidad) {

		if (especialidad == null) {
			throw new IllegalArgumentException("Especialidad obligatoria");
		}

		if (!especialidades.contains(especialidad)) {
			especialidades.add(especialidad);
		}
	}

	@Override
	public String mostrarInformacion() {
		return "MEDICO: " + getNombreCompleto()
				+ " | DNI: " + getDni()
				+ " | CMP: " + cmp
				+ " | Especialidades: " + especialidades.size()
				+ " | Estado: " + (activo ? "ACTIVO" : "INACTIVO");
	}

	public static void modificar(List<Medico> medicos, Scanner sc) {
		System.out.print("DNI del medico: ");
		String dni = sc.nextLine().trim();

		for (Medico m : medicos) {
			if (m.getDni().equals(dni)) {
				m.modificarMedico(sc);
				return;
			}
		}
		System.out.println("Medico no encontrado");
	}

	public boolean isActivo() {
		return activo;
	}

	public static void desactivar(List<Medico> medicos, List<Cita> citas,
								  List<Turno> turnos, Scanner sc) {
		System.out.print("DNI del medico a desactivar: ");
		String dni = sc.nextLine().trim();

		for (Medico m : medicos) {
			if (m.getDni().equals(dni)) {

				if (!m.activo) {
					System.out.println("El medico ya esta inactivo");
					return;
				}

				int pendientes = 0;
				for (Cita c : citas) {
					if (c.getMedico() == m
							&& (c.getEstado().equals("PROGRAMADA")
							|| c.getEstado().equals("CONFIRMADA"))) {
						pendientes++;
					}
				}

				if (pendientes > 0) {
					System.out.print("El medico tiene " + pendientes
							+ " cita(s) pendiente(s). Desactivar de todos modos? (S/N): ");
					if (!sc.nextLine().trim().equalsIgnoreCase("S")) {
						System.out.println("Operacion cancelada");
						return;
					}
				}

				m.activo = false;

				// Bloquear turnos futuros que aun estan disponibles
				LocalDate hoy = LocalDate.now();
				LocalTime ahora = LocalTime.now();
				int bloqueados = 0;

				for (Turno t : turnos) {
					boolean esDelMedico = t.getHorario().getMedico() == m;
					boolean esFuturo = t.getFecha().isAfter(hoy)
							|| (t.getFecha().equals(hoy) && t.getHoraInicio().isAfter(ahora));

					if (esDelMedico && esFuturo && t.getEstado().equals("DISPONIBLE")) {
						t.setEstado("BLOQUEADO");
						bloqueados++;
					}
				}

				System.out.println("Medico desactivado. Sus citas historicas se conservan.");
				System.out.println("Turnos futuros bloqueados: " + bloqueados);
				return;
			}
		}
		System.out.println("Medico no encontrado");
	}
	public static void registrar(List<Medico> medicos, List<Especialidad> especialidades, Scanner sc) {
		try {
			System.out.print("DNI: ");
			String dni = sc.nextLine().trim();

			for (Medico m : medicos) {
				if (m.getDni().equals(dni)) {
					System.out.println("Ya existe un medico con ese DNI");
					return;
				}
			}

			System.out.print("Nombres: ");
			String nombres = sc.nextLine().trim();
			System.out.print("Apellido paterno: ");
			String paterno = sc.nextLine().trim();
			System.out.print("Apellido materno: ");
			String materno = sc.nextLine().trim();
			System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
			LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine().trim());
			System.out.print("Sexo (M/F): ");
			String sexo = sc.nextLine().trim();
			System.out.print("CMP: ");
			String cmp = sc.nextLine().trim();

			for (Medico m : medicos) {
				if (m.getCmp().equalsIgnoreCase(cmp)) {
					System.out.println("Ya existe un medico con ese CMP");
					return;
				}
			}

			Medico nuevo = new Medico(dni, nombres, paterno, materno, fechaNacimiento, sexo, cmp);

			int maxId = 0;
			for (Medico m : medicos) {
				if (m.getIdMedico() > maxId) {
					maxId = m.getIdMedico();
				}
			}
			nuevo.setIdMedico(maxId + 1);

			// Asignar especialidades (opcional)
			if (!especialidades.isEmpty()) {
				while (true) {
					System.out.println("\nEspecialidades disponibles:");
					for (int i = 0; i < especialidades.size(); i++) {
						System.out.println((i + 1) + ". " + especialidades.get(i).getDescripcion());
					}
					System.out.print("Numero a asignar (0 para terminar): ");
					int pos = Integer.parseInt(sc.nextLine().trim());

					if (pos == 0) {
						break;
					}
					if (pos < 1 || pos > especialidades.size()) {
						System.out.println("Opcion no valida");
						continue;
					}
					nuevo.agregarEspecialidad(especialidades.get(pos - 1));
					System.out.println("Especialidad agregada");
				}
			}

			medicos.add(nuevo);
			System.out.println("Medico registrado con ID " + nuevo.getIdMedico());

		} catch (DateTimeParseException e) {
			System.out.println("Fecha invalida. Use el formato AAAA-MM-DD");
		} catch (NumberFormatException e) {
			System.out.println("Ingrese un numero valido");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void modificarMedico(Scanner sc) {
		try {
			System.out.print("Nuevos nombres: ");
			String nombres = sc.nextLine();
			System.out.print("Nuevo apellido paterno: ");
			String paterno = sc.nextLine();
			System.out.print("Nuevo apellido materno: ");
			String materno = sc.nextLine();
			System.out.print("Nuevo CMP: ");
			String cmp = sc.nextLine();

			setNombres(nombres);
			setApellidoPaterno(paterno);
			setApellidoMaterno(materno);
			setCmp(cmp);

			System.out.println("Medico modificado");
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public boolean tieneEspecialidad(String nombre) {
		for (Especialidad e : especialidades) {
			if (e.getDescripcion().equalsIgnoreCase(nombre)) {
				return true;
			}
		}
		return false;
	}

}
