
package app;

public class Especialidad {

    private static int contador = 0;

    private String codigo;
    private String descripcion;

    public Especialidad(String descripcion) {
        setDescripcion(descripcion);
        this.codigo = String.format("ESP%03d", ++contador);
    }

    public String getCodigo() { 
    	return codigo; 
    	}
    public String getDescripcion() { 
    	return descripcion; 
    	}

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank())
            throw new IllegalArgumentException("Descripción vacía");
        this.descripcion = descripcion;
    }
}
