
package app;

public class Medicamento {

    private static int contador = 0;

    private String codigo;
    private String descripcion;
    private String dosis;

    public Medicamento(String descripcion, String dosis) {
        setDescripcion(descripcion);
        setDosis(dosis);
        this.codigo = String.format("MEDI%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getDosis() {
        return dosis;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("Descripción vacía");
        }
        this.descripcion = descripcion;
    }

    public void setDosis(String dosis) {
        if (dosis == null || dosis.isBlank()) {
            throw new IllegalArgumentException("Dosis vacía");
        }
        this.dosis = dosis;
    }

}
