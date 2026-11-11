
package app;

import java.util.ArrayList;
import java.util.Scanner;

import static app.Principal.sc;

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

    public void modificarDatos(Scanner sc, ArrayList<Especialidad> especialidades) {
        try {
            System.out.print("Nuevo CMP: ");
            setCmp(sc.nextLine());

            System.out.print("Nuevos nombres: ");
            setNombresMedico(sc.nextLine());

            System.out.print("Nuevos apellidos: ");
            setApellidosMedico(sc.nextLine());

            for (int i = 0; i < especialidades.size(); i++) {
                System.out.println((i + 1) + ". " + especialidades.get(i).getDescripcion());
            }
            System.out.print("Numero de especialidad: ");
            setEspecialidad(especialidades.get(Integer.parseInt(sc.nextLine()) - 1));

            System.out.println("Medico actualizado");
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Dato invalido, revise lo ingresado");
        }
    }

    public static void modificarMedico(Scanner sc, ArrayList<Medico> medicos, ArrayList<Especialidad> especialidades) {
        if (medicos.isEmpty()) {
            System.out.println("No hay medicos registrados");
            return;
        }

        System.out.println("\n--- Medicos ---");
        for (Medico m : medicos) {
            System.out.println(m.codigo + " | CMP " + m.cmp + " | " + m.nombresMedico + " "
                    + m.apellidosMedico + " | " + m.especialidad.getDescripcion());
        }

        System.out.print("Codigo del medico a modificar: ");
        String buscado = sc.nextLine().trim();
        for (Medico m : medicos) {
            if (m.codigo.equalsIgnoreCase(buscado)) {
                m.modificarDatos(sc, especialidades);
                return;
            }
        }
        System.out.println("Medico no encontrado");
    }//final de la clase








}