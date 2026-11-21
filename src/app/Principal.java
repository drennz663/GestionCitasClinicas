package app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Paciente> pacientes = new ArrayList<>();
    static ArrayList<Seguro> seguros = new ArrayList<>();
    static ArrayList<Medico> medicos = new ArrayList<>();
    static ArrayList<Especialidad> especialidades = new ArrayList<>();
    static ArrayList<Consultorio> consultorios = new ArrayList<>();
    static ArrayList<Diagnostico> diagnosticos = new ArrayList<>();
    static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    static ArrayList<Atencion> atenciones = new ArrayList<>();
    static ArrayList<Receta> recetas = new ArrayList<>();
    static ArrayList<Cita> citas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n========== SISTEMA MEDICO ==========");
            System.out.println("1. Gestion de Pacientes");
            System.out.println("2. Gestion de Medicos");
            System.out.println("3. Gestion de Especialidades");
            System.out.println("4. Gestion de Seguros");
            System.out.println("5. Gestion de Consultorios");
            System.out.println("6. Gestion de Atenciones");
            System.out.println("7. Gestion de Citas");
            System.out.println("8. Cargar datos de prueba");
            System.out.println("0. Salir");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    gestionPacientes();
                    break;
                case 2:
                    gestionMedicos();
                    break;
                case 3:
                    gestionEspecialidades();
                    break;
                case 4:
                    gestionSeguros();
                    break;
                case 5:
                    gestionConsultorios();
                    break;
                case 6:
                    gestionAtenciones();
                    break;
                case 7:
                    gestionCitas();
                    break;
                case 8:
                    cargarDatosPrueba();
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        sc.close();
    }
    public static void gestionPacientes() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE PACIENTES ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Ver historial de un paciente");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    Paciente.registrarPaciente(sc, pacientes, seguros);
                    break;
                case 2:
                    Paciente.listarPacientes(pacientes);
                    break;
                case 3:
                    verHistorialPaciente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    // médicos
    public static void gestionMedicos() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE MEDICOS ===");
            System.out.println("1. Registrar medico");
            System.out.println("2. Listar medicos");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //Medico.registrarMedico(sc, medicos, especialidades);
                    break;
                case 2:
                    //Medico.listarMedicos(medicos);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }
    public static void gestionEspecialidades() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE ESPECIALIDADES ===");
            System.out.println("1. Registrar especialidad");
            System.out.println("2. Listar especialidades");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //Especialidad.registrarEspecialidad(sc, especialidades);
                    break;
                case 2:
                    //Especialidad.listarEspecialidades(especialidades);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    public static void gestionSeguros() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE SEGUROS ===");
            System.out.println("1. Registrar seguro");
            System.out.println("2. Listar seguros");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //Seguro.registrarSeguro(sc, seguros);
                    break;
                case 2:
                    //Seguro.listarSeguros(seguros);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }
    public static void gestionConsultorios() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE CONSULTORIOS ===");
            System.out.println("1. Registrar consultorio");
            System.out.println("2. Listar consultorios");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //registrarConsultorio();
                    break;
                case 2:
                    //listarConsultorios();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    public static void gestionAtenciones() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE ATENCIONES ===");
            System.out.println("1. Registrar atencion");
            System.out.println("2. Listar atenciones");
            System.out.println("3. Ver detalle de atencion");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    registrarAtencion();
                    break;
                case 2:
                    //listarAtenciones();
                    break;
                case 3:
                    //verDetalleAtencion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }
    public static void gestionCitas() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE CITAS ===");
            System.out.println("1. Registrar cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Confirmar cita");
            System.out.println("4. Cancelar cita");
            System.out.println("5. Marcar cita como atendida");
            System.out.println("6. Marcar cita como no asistio");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    registrarCita();
                    break;
                case 2:
                    listarCitas();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    cambiarEstadoCita(opcion);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    public static void registrarAtencion() {
        if (medicos.isEmpty() || consultorios.isEmpty()) {
            System.out.println("Debe haber medicos y consultorios registrados (use la opcion 8 para datos de prueba)");
            return;
        }

        System.out.print("DNI del paciente: ");
        Paciente paciente = Paciente.buscarPorDni(pacientes, sc.nextLine().trim());
        if (paciente == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        Medico medico = elegirMedico();
        if (medico == null) {
            return;
        }

        System.out.println("Consultorios:");
        for (Consultorio c : consultorios) {
            System.out.println(c.getCodigo() + " - " + c.getNombre() + " (" + c.getDistrito() + ")");
        }
        System.out.print("Codigo del consultorio: ");
        Consultorio consultorio = buscarConsultorio(sc.nextLine().trim());
        if (consultorio == null) {
            System.out.println("Consultorio no encontrado");
            return;
        }

        try {
            System.out.print("Fecha de la atencion (AAAA-MM-DD, Enter = hoy): ");
            String textoFecha = sc.nextLine().trim();
            LocalDate fecha;
            if (textoFecha.isEmpty()) {
                fecha = LocalDate.now();
            } else {
                fecha = LocalDate.parse(textoFecha);
            }
            System.out.print("Motivo de la consulta: ");
            String motivo = sc.nextLine();
            System.out.print("Diagnostico: ");
            Diagnostico diagnostico = new Diagnostico(sc.nextLine());

            Atencion atencion = new Atencion(fecha, paciente, medico, consultorio, diagnostico, motivo);
            diagnosticos.add(diagnostico);
            atenciones.add(atencion);
            paciente.agregarAlHistorial(atencion); // se guarda en el historial del paciente
            System.out.println("Atencion " + atencion.getCodigo() + " guardada en el historial de " + paciente.getNombreCompleto());

        } catch (DateTimeParseException e) {
            System.out.println("Fecha invalida. Use el formato AAAA-MM-DD");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void verHistorialPaciente() {
        System.out.print("DNI del paciente: ");
        Paciente paciente = Paciente.buscarPorDni(pacientes, sc.nextLine().trim());
        if (paciente == null) {
            System.out.println("Paciente no encontrado");
        } else {
            paciente.mostrarHistorial();
        }
    }

    public static void registrarCita() {
        if (medicos.isEmpty()) {
            System.out.println("No hay medicos registrados (use la opcion 8 para datos de prueba)");
            return;
        }

        System.out.print("DNI del paciente: ");
        Paciente paciente = Paciente.buscarPorDni(pacientes, sc.nextLine().trim());
        if (paciente == null) {
            System.out.println("Paciente no encontrado");
            return;
        }

        Medico medico = elegirMedico();
        if (medico == null) {
            return;
        }

        try {
            System.out.print("Fecha de la cita (AAAA-MM-DD): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine().trim());
            System.out.print("Hora de la cita (HH:MM): ");
            LocalTime hora = LocalTime.parse(sc.nextLine().trim());

            Cita cita = new Cita(paciente, medico, fecha, hora);
            citas.add(cita);
            System.out.println("Cita " + cita.getCodigo() + " registrada con estado " + cita.getEstado());

        } catch (DateTimeParseException e) {
            System.out.println("Fecha u hora invalida. Use AAAA-MM-DD y HH:MM");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void listarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas");
            return;
        }
        for (Cita c : citas) {
            c.mostrarCita();
        }
    }
    
    
    public static void cambiarEstadoCita(int accion) {
        System.out.print("Codigo de la cita (ej: CIT001): ");
        Cita cita = buscarCita(sc.nextLine().trim());
        if (cita == null) {
            System.out.println("Cita no encontrada");
            return;
        }

        try {
            if (accion == 3) {
                cita.confirmar();
            } else if (accion == 4) {
                System.out.print("Motivo de la cancelacion: ");
                cita.cancelar(sc.nextLine());
            } else if (accion == 5) {
                cita.marcarAtendida();
            } else {
                cita.marcarNoAsistio();
            }
            System.out.println("Estado actualizado: " + cita.getEstado());
        } catch (IllegalStateException e) {
            System.out.println("No permitido: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static Medico elegirMedico() {
        System.out.println("Medicos:");
        for (Medico m : medicos) {
            System.out.println(m.getCodigo() + " - " + m.getNombresMedico() + " " + m.getApellidosMedico()
                    + " (" + m.getEspecialidad().getDescripcion() + ")");
        }
        System.out.print("Codigo del medico: ");
        String codigo = sc.nextLine().trim();
        for (Medico m : medicos) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        System.out.println("Medico no encontrado");
        return null;
    }
    public static Consultorio buscarConsultorio(String codigo) {
        for (Consultorio c : consultorios) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }
    public static Cita buscarCita(String codigo) {
        for (Cita c : citas) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    //
    public static void cargarDatosPrueba() {
        if (!seguros.isEmpty()) {
            System.out.println("Los datos de prueba ya fueron cargados");
            return;
        }
        seguros.add(new Seguro("SIS"));
        seguros.add(new Seguro("EsSalud"));
        Especialidad cardiologia = new Especialidad("Cardiologia");
        Especialidad pediatria = new Especialidad("Pediatria");
        especialidades.add(cardiologia);
        especialidades.add(pediatria);
        medicos.add(new Medico("CMP10001", "Luis", "Paredes", cardiologia));
        medicos.add(new Medico("CMP10002", "Rosa", "Vega", pediatria));
        consultorios.add(new Consultorio("Consultorio Central", "Miraflores", "Av. Larco 123"));
        consultorios.add(new Consultorio("Consultorio Norte", "Los Olivos", "Av. Universitaria 456"));
        System.out.println("Datos de prueba cargados: 2 seguros, 2 especialidades, 2 medicos y 2 consultorios");
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }
    }
}