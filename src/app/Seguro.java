
package app;

public class Seguro {

    private static int contador = 0;

    private String codigo;
    private String nombreSeguro;

    public Seguro(String nombreSeguro) {
        setNombreSeguro(nombreSeguro);
        this.codigo = String.format("SEG%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNombreSeguro() {
        return nombreSeguro;
    }

    public void setNombreSeguro(String nombreSeguro) {
        if (nombreSeguro == null || nombreSeguro.isBlank()) {
            throw new IllegalArgumentException("Nombre del seguro vacío");
        }
        this.nombreSeguro = nombreSeguro;
    }
}
