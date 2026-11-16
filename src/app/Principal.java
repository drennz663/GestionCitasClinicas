
package app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    // LISTAS ARRAYSSaa
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
            System.out.println("\n========== SISTEMAaaa CLINICO ==========");
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
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Listar pacientes");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    // registrarPaciente();
                    break;
                case 2:
                    Paciente.buscarPacientePorDNI(pacientes, sc);
                    break;
                case 3:
                    // listarPacientes();
                    break;
                case 4:
                     System.out.print("Ingrese el código del paciente (Ej: PAC001): ");
                     String codigoBuscado = sc.nextLine().trim();
                    
                    Paciente pacienteEncontrado = null;
                    for (Paciente p : pacientes) { 
                        if (p.getIdPaciente()== Integer.parseInt(codigoBuscado)) {
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
                    // modificarPaciente();
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
            System.out.println("4. Modificar medico");
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
                case 4:
                    Medico.modificar(medicos, sc);
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
            System.out.println("4. Consultar horarios disponibles por especialidad");
            System.out.println("5. Modificar horario de medico");
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
                case 4:
                    Turno.consultarPorEspecialidad(turnos, sc);
                    break;
                case 5:
                    Horario.modificarHorario(medicos, horarios, turnos, sc);;
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
            System.out.println("5. Filtrar citas por estado");
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
                case 5:
                    Cita.filtrarPorEstado(citas, sc);
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
            System.out.println("5. Reprogramar citas");
            System.out.println("0. Volver");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    registrarAtencionCompleta();
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
                case 5:
                    // reprogramarCita();
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

    public static void registrarAtencionCompleta() {
   
    System.out.print("Ingrese DNI o Código del paciente: ");
    String codPac = sc.nextLine().trim();
    Paciente pacienteEncontrado = null;
    
    for (int i = 0; i < pacientes.size(); i++) {
        Paciente p = pacientes.get(i);
        if (String.valueOf(p.getIdPaciente()).equalsIgnoreCase(codPac) || p.getDni().equals(codPac)) {
            pacienteEncontrado = p;
            break;
        }
    }
    
    if (pacienteEncontrado == null) {
        System.out.println("Error: Paciente no encontrado.");
        return;
    }

    // 2. Validar y seleccionar el médico
    if (medicos.isEmpty()) {
        System.out.println("Error: No hay médicos registrados.");
        return;
    }
    
    System.out.println("Médicos disponibles:");
    for (int i = 0; i < medicos.size(); i++) {
        Medico m = medicos.get(i);
        System.out.println((i + 1) + ". Dr(a). " + m.getNombres() + " " + m.getApellidoPaterno());
    }
    
    int idMed = Integer.parseInt(sc.nextLine().trim()) - 1;
    if (idMed < 0 || idMed >= medicos.size()) {
        System.out.println("Error: Médico inválido.");
        return;
    }

    
    if (horarios.isEmpty()) {
        System.out.println("Error: No hay horarios.");
        return;
    }

    System.out.print("Ingrese fecha de cita: ");
    LocalDate fechaCita = LocalDate.parse(sc.nextLine());
    
    System.out.print("Ingrese hora de cita (HH:MM): ");
    LocalTime horaCita = LocalTime.parse(sc.nextLine());

   
    try {
        // Creamos el Turno usando el primer horario y los parámetros correctos
        Turno turnoAsignado = new Turno(horarios.get(0), fechaCita, horaCita, horaCita.plusMinutes(30), "DISPONIBLE");
        

        Cita nuevaCita = new Cita(pacienteEncontrado, turnoAsignado, "PROGRAMADA");
        citas.add(nuevaCita);

    
        System.out.print("Ingrese motivo: ");
        String motivo = sc.nextLine().trim();

        Atencion nuevaAtencion = new Atencion(nuevaCita, fechaCita, motivo);
        atenciones.add(nuevaAtencion);

        System.out.println("¡Cita y atención programadas: " + nuevaAtencion.getIdAtencion());
        
        } catch (IllegalArgumentException e) {
       
            System.out.println("Error de validación: " + e.getMessage());
            }

    }


    public static void reprogramarCita() {
      if (citas.isEmpty()) {
          System.out.println("Error: No hay citas registradas.");
          return;
        }

      // 1. Pedir el DNI del paciente para buscar sus citas
      System.out.print("Ingrese el DNI del paciente para buscar su cita: ");
      String dniBuscado = sc.nextLine().trim();

      // 2. Buscar las citas que correspondan a ese DNI usando un bucle tradicional
      ArrayList<Cita> citasDelPaciente = new ArrayList<>();
      for (int i = 0; i < citas.size(); i++) {
        Cita c = citas.get(i);
        if (c.getPaciente().getDni().equalsIgnoreCase(dniBuscado)) {
            citasDelPaciente.add(c);
            }
        }

       if (citasDelPaciente.isEmpty()) {
          System.out.println("Error: No se encontraron citas para el DNI.");
          return;
        }

         // 3. Mostrar las citas encontradas de ese paciente
        System.out.println("Citas encontradas para el paciente:");
        for (int i = 0; i < citasDelPaciente.size(); i++) {
            Cita c = citasDelPaciente.get(i);
            System.out.println((i + 1) + ". Médico: " + c.getMedico().getNombres() + 
                           " | Fecha actual: " + c.getFecha() + " " + c.getHora() + 
                           " | Estado: " + c.getEstado());
            }

            // 4. Seleccionar cuál de las citas del paciente se va a reprogramar
        System.out.print("Seleccione el número de la cita a reprogramar: ");
        int indexCita = Integer.parseInt(sc.nextLine().trim()) - 1;

        if (indexCita < 0 || indexCita >= citasDelPaciente.size()) {
        System.out.println("Error: Selección inválida.");
        return;

            }

        Cita citaSeleccionada = citasDelPaciente.get(indexCita);

            // 5. Pedir la nueva fecha y hora
         System.out.print("Ingrese la nueva fecha: ");
            LocalDate nuevaFecha = LocalDate.parse(sc.nextLine().trim());

        System.out.print("Ingrese la nueva hora: ");
        LocalTime nuevaHora = LocalTime.parse(sc.nextLine().trim());

         // 6. Actualizar el turno de la cita de forma segura
        try {
        Turno nuevoTurno = new Turno(horarios.get(0), nuevaFecha, nuevaHora, nuevaHora.plusMinutes(30), "REPROGRAMADO");
        citaSeleccionada.setTurno(nuevoTurno);

        System.out.println("¡Cita reprogramada con éxito el DNI " + dniBuscado + 
                           " | Nueva fecha: " + nuevaFecha + " a las " + nuevaHora + "!");
        
            } catch (Exception e) {
        System.out.println("Error al reprogramar: " + e.getMessage());
         }
    }
}
