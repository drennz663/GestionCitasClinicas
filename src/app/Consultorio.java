
package app;

public class Consultorio {

    private static int contador = 0;

    private String codigo;
    private String nombre;
    private String distrito;
    private String direccion;

    public Consultorio(String nombre, String distrito, String direccion) {
        setNombre(nombre);
        setDistrito(distrito);
        setDireccion(direccion);
        this.codigo = String.format("CON%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDistrito() {
        return distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre vacío");
        this.nombre = nombre;
    }

    public void setDistrito(String distrito) {
        if (distrito == null || distrito.isBlank())
            throw new IllegalArgumentException("Distrito vacío");
        this.distrito = distrito;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank())
            throw new IllegalArgumentException("Dirección vacía");
        this.direccion = direccion;
    }
}
