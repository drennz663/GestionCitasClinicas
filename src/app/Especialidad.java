package app;

public class Especialidad {

    private int idEspecialidad;
    private String descripcion;

    public Especialidad(String descripcion) {
        setDescripcion(descripcion);
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        if (idEspecialidad <= 0)
            throw new IllegalArgumentException("IdEspecialidad invalido");
        this.idEspecialidad = idEspecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank())
            throw new IllegalArgumentException("Descripcion obligatoria");
        this.descripcion = descripcion.trim();
    }
}