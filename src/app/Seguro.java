package app;

public class Seguro {

    private int idSeguro;
    private String nombreSeguro;

    public Seguro(String nombreSeguro) {
        setNombreSeguro(nombreSeguro);
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        if (idSeguro <= 0)
            throw new IllegalArgumentException("IdSeguro invalido");
        this.idSeguro = idSeguro;
    }

    public String getNombreSeguro() {
        return nombreSeguro;
    }

    public void setNombreSeguro(String nombreSeguro) {
        if (nombreSeguro == null || nombreSeguro.isBlank())
            throw new IllegalArgumentException("Nombre del seguro obligatorio");
        this.nombreSeguro = nombreSeguro.trim();
    }
}