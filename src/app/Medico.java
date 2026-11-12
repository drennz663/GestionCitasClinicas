
package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Medico extends Persona {

	private int idMedico;
	private String cmp;
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
             + " | Especialidades: "
             + especialidades.size();
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
