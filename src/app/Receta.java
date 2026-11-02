package app;

import java.time.LocalDate;

public class Receta {

    private static int contador = 0;

    private String codigo;
    private Atencion atencion;
    private Medicamento medicamento;
    private String dosis;
    private String frecuencia;
    private int duracion;
    private LocalDate fechaReceta;

    public Receta(Atencion atencion, Medicamento medicamento, String dosis, String frecuencia, int duracion, LocalDate fechaReceta) {
        setAtencion(atencion);
        setMedicamento(medicamento);
        setDosis(dosis);
        setFrecuencia(frecuencia);
        setDuracion(duracion);
        setFechaReceta(fechaReceta);
        this.codigo = String.format("REC%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }
    public Atencion getAtencion() {
        return atencion;
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
    public LocalDate getFechaReceta() {
        return fechaReceta;
    }

    public void setAtencion(Atencion atencion) {
        if (atencion == null) {
            throw new IllegalArgumentException("Atención obligatoria");
        }
        this.atencion = atencion;
    }

    public void setMedicamento(Medicamento medicamento) {
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento obligatorio");
        }
        this.medicamento = medicamento;
    }

    public void setDosis(String dosis) {
        if (dosis == null || dosis.isBlank()) {
            throw new IllegalArgumentException("Dosis vacía");
        }
        this.dosis = dosis;
    }

    public void setFrecuencia(String frecuencia) {
        if (frecuencia == null || frecuencia.isBlank()) {
            throw new IllegalArgumentException("Frecuencia vacía");
        }
        this.frecuencia = frecuencia;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a cero");
        }
        this.duracion = duracion;
    }

    public void setFechaReceta(LocalDate fechaReceta) {
        if (fechaReceta == null) {
            throw new IllegalArgumentException("Fecha obligatoria");
        }
        if (fechaReceta.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser futura");
        }
        this.fechaReceta = fechaReceta;
    }
}