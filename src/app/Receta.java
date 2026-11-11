package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Receta {

    private int idReceta;
    private Atencion atencion;
    private LocalDate fechaReceta;
    private List<DetalleReceta> detalles;

    public Receta(Atencion atencion, LocalDate fechaReceta) {
        setAtencion(atencion);
        setFechaReceta(fechaReceta);
        this.detalles = new ArrayList<>();
    }


    public int getIdReceta() {
        return idReceta;
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public LocalDate getFechaReceta() {
        return fechaReceta;
    }

    public List<DetalleReceta> getDetalles() {
        return List.copyOf(detalles);
    }


    public void setIdReceta(int idReceta) {
        if (idReceta <= 0) {
            throw new IllegalArgumentException("ID de receta invalido");
        }
        this.idReceta = idReceta;
    }

    public void setAtencion(Atencion atencion) {
        if (atencion == null) {
            throw new IllegalArgumentException("Atencion obligatoria");
        }
        this.atencion = atencion;
    }

    public void setFechaReceta(LocalDate fechaReceta) {
        if (fechaReceta == null || fechaReceta.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de receta invalida");
        }
        this.fechaReceta = fechaReceta;
    }

    public void setDetalles(List<DetalleReceta> detalles) {
        if (detalles == null) {
            throw new IllegalArgumentException("Lista de detalles obligatoria");
        }
        this.detalles = new ArrayList<>();

        for (DetalleReceta detalle : detalles) {
            agregarDetalle(detalle);
        }
    }


    public void agregarDetalle(DetalleReceta detalle) {
        if (detalle == null) {
            throw new IllegalArgumentException("Detalle obligatorio");
        }

        if (!detalles.contains(detalle)) {
            detalles.add(detalle);
        }
    }

    public void quitarDetalle(DetalleReceta detalle) {
        if (detalle == null) {
            throw new IllegalArgumentException("Detalle obligatorio");
        }

        detalles.remove(detalle);
    }
}