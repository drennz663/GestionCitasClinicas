
package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
