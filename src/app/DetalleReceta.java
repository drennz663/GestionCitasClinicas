package app;

public class DetalleReceta {

    private int idDetalleReceta;
    private Receta receta;
    private Medicamento medicamento;
    private String dosis;
    private String frecuencia;
    private int duracion;

    public DetalleReceta(Receta receta, Medicamento medicamento, String dosis, String frecuencia, int duracion) {
        setReceta(receta);
        setMedicamento(medicamento);
        setDosis(dosis);
        setFrecuencia(frecuencia);
        setDuracion(duracion);
    }


    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public Receta getReceta() {
        return receta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public int getDuracion() {
        return duracion;
    }


    public void setIdDetalleReceta(int idDetalleReceta) {
        if (idDetalleReceta <= 0) {
            throw new IllegalArgumentException("ID de detalle de receta invalido");
        }
        this.idDetalleReceta = idDetalleReceta;
    }

    public void setReceta(Receta receta) {
        if (receta == null) {
            throw new IllegalArgumentException("Receta obligatoria");
        }

        if (this.receta != null && this.receta != receta) {
            throw new IllegalArgumentException("No se puede cambiar la receta de un detalle existente");
        }
        this.receta = receta;
    }

    public void setMedicamento(Medicamento medicamento) {
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento obligatorio");
        }
        this.medicamento = medicamento;
    }

    public void setDosis(String dosis) {
        if (dosis == null || dosis.isBlank()) {
            throw new IllegalArgumentException("Dosis obligatoria");
        }
        if (dosis.length() > 100) {
            throw new IllegalArgumentException("La dosis no puede superar 100 caracteres");
        }

        this.dosis = dosis.trim();
    }

    public void setFrecuencia(String frecuencia) {
        if (frecuencia == null || frecuencia.isBlank()) {
            throw new IllegalArgumentException("Frecuencia obligatoria");
        }
        if (frecuencia.length() > 100) {
            throw new IllegalArgumentException("La frecuencia no puede superar 100 caracteres");
        }
        this.frecuencia = frecuencia.trim();
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duracion debe ser mayor a cero");
        }
        this.duracion = duracion;
    }
}