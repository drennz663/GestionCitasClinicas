package app;

public class Diagnostico {

    private int idDiagnostico;
    private String descripcion;
    private String tipoDiagnostico;

    public Diagnostico(String descripcion, String tipoDiagnostico) {
        setDescripcion(descripcion);
        setTipoDiagnostico(tipoDiagnostico);
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        if (idDiagnostico <= 0)
            throw new IllegalArgumentException("IdDiagnostico invalido");
        this.idDiagnostico = idDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isBlank())
            throw new IllegalArgumentException("Descripcion obligatoria");
        this.descripcion = descripcion.trim();
    }

    public String getTipoDiagnostico() {
        return tipoDiagnostico;
    }

    public void setTipoDiagnostico(String tipoDiagnostico) {
        if (tipoDiagnostico == null || tipoDiagnostico.isBlank())
            throw new IllegalArgumentException("Tipo de diagnostico obligatorio");
        this.tipoDiagnostico = tipoDiagnostico.trim();
    }
}