
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
            System.out.println("3. Modificar datos del paciente");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    //Paciente.registrarPaciente(sc, pacientes, seguros);
                    break;
                case 2:
                     //Paciente.listarPacientes(pacientes);
                    break;
                case 3:

                     System.out.print("Ingrese el código del paciente (Ej: PAC001): ");
                    String codigoBuscado = sc.nextLine().trim();
                    
                    Paciente pacienteEncontrado = null;
                    for (Paciente p : pacientes) { 
                        if (p.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                            pacienteEncontrado = p;
                            break;
                        }
                    }

                    if (pacienteEncontrado == null) {
                        System.out.println("Error: Paciente no encontrado.");
                        break;
                    }

                    // Selección independiente 1: Dirección
                    String nuevaDireccion = null;
                    System.out.print("¿Desea modificar la dirección? (SI/N): ");
                    if (sc.nextLine().trim().equalsIgnoreCase("SI")) {
                        System.out.print("Ingrese la nueva dirección: ");
                        nuevaDireccion = sc.nextLine();
                    }

                    // Selección independiente 2: Seguro 
                    Seguro nuevoSeguro = null;
                    System.out.print("¿Desea modificar el seguro? (SI/NO): ");
                    if (sc.nextLine().trim().equalsIgnoreCase("SI") && !seguros.isEmpty()) {
                        System.out.println("Seguros disponibles:");
                        for (int i = 0; i < seguros.size(); i++) { 
                            
                            System.out.println((i + 1) + ". " + seguros.get(i).getNombreSeguro());
                        }
                        System.out.print("Seleccione el número de seguro: ");
                        int idSeguro = Integer.parseInt(sc.nextLine()) - 1;
                        if (idSeguro >= 0 && idSeguro < seguros.size()) {
                            nuevoSeguro = seguros.get(idSeguro);
                        }
                    }

                    try {
                        
                        pacienteEncontrado.actualizarDatos(nuevaDireccion, nuevoSeguro);
                        System.out.println("¡Datos del paciente actualizados exitosamente!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de validación: " + e.getMessage());
                    }
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
            System.out.println("4. Reprogramar citas");
            System.out.println("0. Volver");
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:

                    System.out.print("Ingrese DNI o Código del paciente: ");
                    String codPac = sc.nextLine().trim();
                    Paciente pacEncontrado = null;
                    for (Paciente p : pacientes) { 
                        if (p.getCodigo().equalsIgnoreCase(codPac) || p.getDni().equals(codPac)) {
                            pacEncontrado = p;
                            break;
                        }
                    }
                    if (pacEncontrado == null) {
                        System.out.println("Error: Paciente no encontrado.");
                        break;
                    }

                    
                    System.out.println("Médicos disponibles:");
                    for (int i = 0; i < medicos.size(); i++) {
                        Medico m = medicos.get(i);
                        System.out.println((i + 1) + ". Dr(a). " + m.getNombresMedico() + " " + m.getApellidosMedico());
                    }
                    int idMed = leerEntero("Seleccione número de médico: ") - 1;
                    if (idMed < 0 || idMed >= medicos.size()) {
                        System.out.println("Error: Médico inválido.");
                        break;
                    }
                    Medico medSeleccionado = medicos.get(idMed);

                    // REQ: Selección de Consultorio
                    System.out.println("Consultorios disponibles:");
                    for (int i = 0; i < consultorios.size(); i++) {
                        Consultorio c = consultorios.get(i);
                        System.out.println((i + 1) + ". " + c.getNombre() + " (" + c.getDistrito() + ")");
                    }
                    int idCons = leerEntero("Seleccione número de consultorio: ") - 1;
                    if (idCons < 0 || idCons >= consultorios.size()) {
                        System.out.println("Error: Consultorio inválido.");
                        break;
                    }
                    Consultorio consSeleccionado = consultorios.get(idCons);

                    // 
                    System.out.print("Ingrese fecha de cita (AAAA-MM-DD): ");
                    LocalDate fecha = LocalDate.parse(sc.nextLine().trim());

                    System.out.print("Ingrese motivo de consulta: ");
                    String motivo = sc.nextLine().trim();

                    try {
                        
                        Atencion nuevaCita = new Atencion(fecha, pacEncontrado, medSeleccionado, consSeleccionado, null, motivo);
                        atenciones.add(nuevaCita);
                        System.out.println("¡Cita programada con éxito! Código asignado: " + nuevaCita.getCodigo());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de validación: " + e.getMessage());
                    }
                    break;
                    break;
                case 2:
                    //listarAtenciones();
                    break;
                case 3:
                    //verDetalleAtencion();
                    break;
                case 4:

                    if (atenciones.isEmpty()) {
                        System.out.println("Error: No existen citas registradas para reprogramar.");
                        break;
                    }
                    
                    System.out.print("Ingrese el código de la atención (Ej: ATE001): ");
                    String codigoBuscado = sc.nextLine().trim();

                    Atencion citaEncontrada = null;
                    for (Atencion a : atenciones) {
                        if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                            citaEncontrada = a;
                            break;
                        }
                    }

                    if (citaEncontrada == null) {
                        System.out.println("Error: Cita médica no encontrada.");
                        break;
                    }

                    System.out.println("Cita actual encontrada : " + citaEncontrada.getPaciente().getNombres());
                    System.out.println("Fecha actual: " + citaEncontrada.getFechaAtencion());

                    System.out.print("Ingrese la nueva fecha (AAAA-MM-DD): ");
                    LocalDate nuevaFecha = null;
                    try {
                        nuevaFecha = LocalDate.parse(sc.nextLine().trim());
                        
                        citaEncontrada.reprogramarCita(nuevaFecha);
                        System.out.println("¡Cita reprogramada exitosamente : " + citaEncontrada.getFechaAtencion() + "!");
                    } catch (Exception e) {
                        System.out.println("Error en la reprogramación: " + e.getMessage());
                    }
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
