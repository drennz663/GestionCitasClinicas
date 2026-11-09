
package app;

public class Medico {

    private static int contador = 0;

    private String codigo;
    private String cmp;
    private String nombresMedico;
    private String apellidosMedico;
    private Especialidad especialidad;

    public Medico(String cmp, String nombresMedico, String apellidosMedico, Especialidad especialidad) {

        setCmp(cmp);
        setNombresMedico(nombresMedico);
        setApellidosMedico(apellidosMedico);
        setEspecialidad(especialidad);
        this.codigo = String.format("MED%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCmp() {
        return cmp;
    }

    public String getNombresMedico() {
        return nombresMedico;
    }

    public String getApellidosMedico() {
        return apellidosMedico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setCmp(String cmp) {
        if (cmp == null || cmp.isBlank()) {
            throw new IllegalArgumentException("CMP vacío");
        }
        this.cmp = cmp;
    }

    public void setNombresMedico(String nombresMedico) {
        if (nombresMedico == null || nombresMedico.isBlank()) {
            throw new IllegalArgumentException("Nombres vacíos");
        }
        this.nombresMedico = nombresMedico;
    }

    public void setApellidosMedico(String apellidosMedico) {
        if (apellidosMedico == null || apellidosMedico.isBlank()) {
            throw new IllegalArgumentException("Apellidos vacíos");
        }
        this.apellidosMedico = apellidosMedico;
    }

    public void setEspecialidad(Especialidad especialidad) {
        if (especialidad == null) {
            throw new IllegalArgumentException("Debe seleccionar una especialidad");
        }
        this.especialidad = especialidad;
    }

    public void modificardatos(){

    }// fin de la clase modificar datos




}
