package app;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Paciente {

    private static int contador = 0;

    private String codigo;
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String direccion;
    private String telefono;
    private String correo;
    private Seguro seguro;
    private ArrayList<Atencion> historial;

    public Paciente(String dni, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String sexo, String direccion, String telefono, String correo, Seguro seguro) {

        setDni(dni);
        setNombres(nombres);
        setApellidoPaterno(apellidoPaterno);
        setApellidoMaterno(apellidoMaterno);
        setFechaNacimiento(fechaNacimiento);
        setSexo(sexo);
        setDireccion(direccion);
        setTelefono(telefono);
        setCorreo(correo);
        setSeguro(seguro);
        this.historial = new ArrayList<>();
        this.codigo = String.format("PAC%03d", ++contador);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDni() {
        return dni;
    }
    public String getNombres() {
        return nombres;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getSexo() {
        return sexo;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public Seguro getSeguro() {
        return seguro;
    }
    public ArrayList<Atencion> getHistorial() {
        return historial;
    }

    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}")) {
            throw new IllegalArgumentException("El DNI debe tener 8 dígitos");
        }
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        if (nombres == null || nombres.isBlank()) {
            throw new IllegalArgumentException("Nombres vacíos");
        }
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        if (apellidoPaterno == null || apellidoPaterno.isBlank()) {
            throw new IllegalArgumentException("Apellido paterno vacío");
        }
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        if (apellidoMaterno == null || apellidoMaterno.isBlank()) {
            throw new IllegalArgumentException("Apellido materno vacío");
        }
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        if (sexo == null ||
                (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F"))) {
            throw new IllegalArgumentException("Sexo debe ser M o F");
        }
        this.sexo = sexo.toUpperCase();
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Dirección vacía");
        }
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("El teléfono debe tener 9 dígitos");
        }
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        if (correo == null || !correo.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.-]+$")) {
            throw new IllegalArgumentException("Correo electrónico inválido");
        }
        this.correo = correo;
    }

    public void setSeguro(Seguro seguro) {
        if (seguro == null) {
            throw new IllegalArgumentException("Debe seleccionar un seguro");
        }
        this.seguro = seguro;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    public void agregarAlHistorial(Atencion atencion) {
        if (atencion == null) {
            throw new IllegalArgumentException("Atención obligatoria");
        }
        historial.add(atencion);
    }
    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE " + getNombreCompleto() + " (DNI " + dni + ") ---");
        if (historial.isEmpty()) {
            System.out.println("El paciente no tiene atenciones registradas");
            return;
        }
        for (Atencion a : historial) {
            System.out.println(a.getCodigo() + " | " + a.getFechaAtencion()
                    + " | Medico: " + a.getMedico().getNombresMedico() + " " + a.getMedico().getApellidosMedico()
                    + " | Consultorio: " + a.getConsultorio().getNombre());
            System.out.println("    Motivo: " + a.getMotivo());
            System.out.println("    Diagnostico: " + a.getDiagnostico().getDescripcion());
        }
    }
    public static Paciente buscarPorDni(ArrayList<Paciente> pacientes, String dni) {
        for (Paciente p : pacientes) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }

    public static void registrarPaciente(Scanner sc, ArrayList<Paciente> pacientes, ArrayList<Seguro> seguros) {

        if (seguros.isEmpty()) {
            System.out.println("Primero debe registrar al menos un seguro");
            return;
        }

        System.out.print("DNI: ");
        String dni = sc.nextLine().trim();

        if (!dni.matches("\\d{8}")) {
            System.out.println("El DNI debe tener 8 digitos");
            return;
        }
        if (buscarPorDni(pacientes, dni) != null) {
            System.out.println("Paciente duplicado: ya existe ese DNI");
            return;
        }

        try {
            System.out.print("Nombres: ");
            String nombres = sc.nextLine();
            System.out.print("Apellido paterno: ");
            String paterno = sc.nextLine();
            System.out.print("Apellido materno: ");
            String materno = sc.nextLine();
            System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
            LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine().trim());
            System.out.print("Sexo (M/F): ");
            String sexo = sc.nextLine().trim();
            System.out.print("Direccion: ");
            String direccion = sc.nextLine();
            System.out.print("Telefono (9 digitos): ");
            String telefono = sc.nextLine().trim();
            System.out.print("Correo: ");
            String correo = sc.nextLine().trim();

            System.out.println("Seguros disponibles:");
            for (int i = 0; i < seguros.size(); i++) {
                System.out.println((i + 1) + ". " + seguros.get(i).getNombreSeguro());
            }
            System.out.print("Elija el seguro: ");
            int posicion = Integer.parseInt(sc.nextLine().trim());
            if (posicion < 1 || posicion > seguros.size()) {
                System.out.println("Seguro no valido");
                return;
            }

            Paciente paciente = new Paciente(dni, nombres, paterno, materno,
                    fechaNacimiento, sexo, direccion, telefono, correo, seguros.get(posicion - 1));
            pacientes.add(paciente);
            System.out.println("Paciente registrado correctamente" + paciente.getCodigo());

        } catch (DateTimeParseException e) {
            System.out.println("Fecha invalida. Use el formato AAAA-MM-DD");
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un numero valido");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarPacientes(ArrayList<Paciente> pacientes) {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
            return;
        }
        for (Paciente p : pacientes) {
            System.out.println(p.getCodigo() + " | DNI " + p.getDni() + " | " + p.getNombreCompleto()
                    + " | Nac: " + p.getFechaNacimiento() + " | Tel: " + p.getTelefono()
                    + " | " + p.getCorreo() + " | Seguro: " + p.getSeguro().getNombreSeguro());
        }
    }
}