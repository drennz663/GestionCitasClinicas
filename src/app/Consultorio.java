package app;

public class Consultorio {

    private int idConsultorio;
    private String nombre;
    private String distrito;
    private String direccion;

    public Consultorio(String nombre, String distrito, String direccion) {
        setNombre(nombre);
        setDistrito(distrito);
        setDireccion(direccion);
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        if (idConsultorio <= 0)
            throw new IllegalArgumentException("IdConsultorio invalido");
        this.idConsultorio = idConsultorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre obligatorio");
        this.nombre = nombre.trim();
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        if (distrito == null || distrito.isBlank())
            throw new IllegalArgumentException("Distrito obligatorio");
        this.distrito = distrito.trim();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank())
            throw new IllegalArgumentException("Direccion obligatoria");
        this.direccion = direccion.trim();
    }
}