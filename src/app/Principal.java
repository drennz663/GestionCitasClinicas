
package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    // LISTAS
    static ArrayList<Paciente> 			pacientes 		= new ArrayList<>();
    static ArrayList<Seguro> 			seguros 		= new ArrayList<>();
    static ArrayList<Medico> 			medicos 		= new ArrayList<>();
    static ArrayList<Especialidad> 		especialidades 	= new ArrayList<>();
    static ArrayList<Consultorio> 		consultorios 	= new ArrayList<>();
    static ArrayList<Horario> 			horarios 		= new ArrayList<>();
    static ArrayList<Turno> 			turnos 			= new ArrayList<>();
    static ArrayList<Cita> 				citas 			= new ArrayList<>();
    static ArrayList<Atencion> 			atenciones 		= new ArrayList<>();
    static ArrayList<HistorialClinico> 	historiales 	= new ArrayList<>();
    static ArrayList<Diagnostico> 		diagnosticos 	= new ArrayList<>();
    static ArrayList<Medicamento>		medicamentos 	= new ArrayList<>();
    static ArrayList<Receta> 			recetas 		= new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n========== SISTEMA CLINICO ==========");
            System.out.println("\n1.  Gestion de Pacientes");
            System.out.println("2.  Gestion de Medicos");
            System.out.println("3.  Gestion de Especialidades");
            System.out.println("4.  Gestion de Seguros");
            System.out.println("5.  Gestion de Consultorios");
            System.out.println("6.  Gestion de Horarios");
            System.out.println("7.  Gestion de Turnos");
            System.out.println("8.  Gestion de Citas");
            System.out.println("9.  Gestion de Atenciones");
            System.out.println("10. Gestion de Historiales Clinicos");
            System.out.println("11. Gestion de Diagnosticos");
            System.out.println("12. Gestion de Medicamentos");
            System.out.println("13. Gestion de Recetas");
            System.out.println("0.  Salir");

            opcion = leerEntero("\nOpcion: ");

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
                    gestionHorarios();
                    break;
                case 7:
                    gestionTurnos();
                    break;
                case 8:
                    gestionCitas();
                    break;
                case 9:
                    gestionAtenciones();
                    break;
                case 10:
                    gestionHistoriales();
                    break;
                case 11:
                    gestionDiagnosticos();
                    break;
                case 12:
                    gestionMedicamentos();
                    break;
                case 13:
                    gestionRecetas();
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
                    // registrarPaciente();
                    break;
                case 2:
                    // listarPacientes();
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
            System.out.println("3. Asignar especialidad");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarMedico();
                    break;
                case 2:
                    // listarMedicos();
                    break;
                case 3:
                    // asignarEspecialidad();
                    break;
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
                    // registrarEspecialidad();
                    break;
                case 2:
                    // listarEspecialidades();
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
                    // registrarSeguro();
                    break;
                case 2:
                    // listarSeguros();
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
                    // registrarConsultorio();
                    break;
                case 2:
                    // listarConsultorios();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE HORARIOS
    public static void gestionHorarios() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE HORARIOS ===");
            System.out.println("1. Registrar horario");
            System.out.println("2. Listar horarios");
            System.out.println("3. Consultar horarios por medico");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarHorario();
                    break;
                case 2:
                    // listarHorarios();
                    break;
                case 3:
                    // consultarHorariosMedico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE TURNOS
    public static void gestionTurnos() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE TURNOS ===");
            System.out.println("1. Registrar turno");
            System.out.println("2. Listar turnos");
            System.out.println("3. Consultar turnos disponibles");
            System.out.println("4. Bloquear turno");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarTurno();
                    break;
                case 2:
                    // listarTurnos();
                    break;
                case 3:
                    // consultarTurnosDisponibles();
                    break;
                case 4:
                    // bloquearTurno();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE CITAS
    public static void gestionCitas() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE CITAS ===");
            System.out.println("1. Registrar cita");
            System.out.println("2. Listar citas");
            System.out.println("3. Confirmar cita");
            System.out.println("4. Cancelar cita");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarCita();
                    break;
                case 2:
                    // listarCitas();
                    break;
                case 3:
                    // confirmarCita();
                    break;
                case 4:
                    // cancelarCita();
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
            System.out.println("4. Asignar diagnostico");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarAtencion();
                    break;
                case 2:
                    // listarAtenciones();
                    break;
                case 3:
                    // verDetalleAtencion();
                    break;
                case 4:
                    // asignarDiagnostico();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE HISTORIALES CLINICOS
    public static void gestionHistoriales() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE HISTORIALES CLINICOS ===");
            System.out.println("1. Registrar historial");
            System.out.println("2. Listar historiales");
            System.out.println("3. Consultar historial por paciente");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarHistorial();
                    break;
                case 2:
                    // listarHistoriales();
                    break;
                case 3:
                    // consultarHistorialPaciente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE DIAGNOSTICOS
    public static void gestionDiagnosticos() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE DIAGNOSTICOS ===");
            System.out.println("1. Registrar diagnostico");
            System.out.println("2. Listar diagnosticos");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarDiagnostico();
                    break;
                case 2:
                    // listarDiagnosticos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE MEDICAMENTOS
    public static void gestionMedicamentos() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE MEDICAMENTOS ===");
            System.out.println("1. Registrar medicamento");
            System.out.println("2. Listar medicamentos");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarMedicamento();
                    break;
                case 2:
                    // listarMedicamentos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    // GESTION DE RECETAS
    public static void gestionRecetas() {
        int opcion;

        do {
            System.out.println("\n=== GESTION DE RECETAS ===");
            System.out.println("1. Registrar receta");
            System.out.println("2. Listar recetas");
            System.out.println("3. Agregar medicamento a receta");
            System.out.println("4. Ver detalle de receta");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarReceta();
                    break;
                case 2:
                    // listarRecetas();
                    break;
                case 3:
                    // agregarMedicamentoReceta();
                    break;
                case 4:
                    // verDetalleReceta();
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
