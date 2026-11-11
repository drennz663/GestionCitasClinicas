package app;

public class Medicamento {

    private int idMedicamento;
    private String descripcion;

    public Medicamento(String descripcion) {
        setDescripcion(descripcion);
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        if (idMedicamento <= 0)
            throw new IllegalArgumentException("IdMedicamento invalido");
        this.idMedicamento = idMedicamento;
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