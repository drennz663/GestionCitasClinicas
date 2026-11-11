
package app;

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
    static ArrayList<Horario> horarios = new ArrayList<>();
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
                case 7:
                    gestionCitas();
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

    // GESTION DE PACIENTES
    public static void gestionPacientes() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE PACIENTES ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //Paciente.registrarPaciente(sc, pacientes, seguros);
                    break;
                case 2:
                    //Paciente.listarPacientes(pacientes);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    // GESTION DE MEDICOS
    public static void gestionMedicos() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE MEDICOS ===");
            System.out.println("1. Registrar medico");
            System.out.println("2. Listar medicos");
            System.out.println("3. Modificar medico");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //Medico.registrarMedico(sc, medicos, especialidades);
                    break;
                case 2:
                    //Medico.listarMedicos(medicos);
                    break;
                case 3:
                    Medico.modificarMedico(sc, medicos, especialidades);
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    // GESTION DE ESPECIALIDADES
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

    // GESTION DE SEGUROS
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

    // GESTION DE CONSULTORIOS
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

    // GESTION DE ATENCIONES
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
                    //registrarAtencion();
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
            System.out.println("1. Filtrar citas por estado");
            System.out.println("2. Consultar horarios disponibles por especialidad");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    Cita.filtrarCitasPorEstado(citas);
                    break;
                case 2:
                    Horario.consultarDisponiblesPorEspecialidad(horarios, especialidades);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    // VALIDAR ENTRADA NUMERICA
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
