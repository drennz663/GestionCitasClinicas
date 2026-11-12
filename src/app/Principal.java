package app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
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
        cargarDatosPrueba();

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
                    listarPorFecha();
                    break;
                case 3:
                    // confirmarCita();
                    confirmarCita();
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

    // VALIDAR ENTRADA DE FECHA
    public static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                return LocalDate.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Ingrese una fecha valida (AAAA-MM-DD)");
            }
        }
    }

    public static void confirmarCita() {
        int id;
        int opcion;
        id = leerEntero("Ingresa el ID de la cita a confirmar : ");
        for(int x = 0; x < citas.size(); x++) {
            Cita citaObtenida = citas.get(x);
            if (citaObtenida.getIdCita() == id) {
                if(Objects.equals(citaObtenida.getEstado(), "CONFIRMADA")){
                    System.out.println("La cita ya esta confirmada...");
                    return;
                }
                System.out.println("¿Estás seguro de que quieres confirmar esta cita? " + citaObtenida.getIdCita() + " de estado actual : " + citaObtenida.getEstado());
                System.out.println("1. Sí, confirmar cita");
                System.out.println("2. He escrito el ID incorrectamente");
                opcion = leerEntero("Opción: ");
                switch (opcion) {
                    case 1:
                        citaObtenida.setEstado("CONFIRMADA");
                        System.out.println("La cita ha sido confirmada satisfactoriamente");
                        break;
                    case 2:
                        System.out.println("Operación cancelada");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
                return;
            }
        }
        System.out.println("No se encontró ninguna cita con ese ID");
    }

    public static void listarPorFecha(){
        int opcion;
        LocalDate fecha;
        LocalDate otraFecha;
        fecha = leerFecha("Ingresa la fecha a buscar : ");
        System.out.println("Deseas añadir una segunda fecha?");
        System.out.println("1. Sii!");
        System.out.println("2. Ehh....mejor no");
        opcion = leerEntero("Ingresa una opcion : ");
        switch (opcion) {
            case 1 :
                boolean encontrado = false;
                otraFecha = leerFecha("Ingresa la fecha a buscar : ");
                if (fecha.isAfter(otraFecha)) {
                    System.out.println("La fecha inicial no puede ser posterior a la final");
                    return;
                }
                for (int x = 0;x < citas.size(); x++){
                    Cita citaObtenida = citas.get(x);
                    if (!citaObtenida.getFecha().isBefore(fecha) &&
                            !citaObtenida.getFecha().isAfter(otraFecha)) {
                        encontrado = true;
                        System.out.println("ID: " + citaObtenida.getIdCita());
                        System.out.println("Paciente: " + citaObtenida.getPaciente().getNombres());
                        System.out.println("Fecha: " + citaObtenida.getFecha());
                        System.out.println("Hora: " + citaObtenida.getHora());
                    }
                }
                if(!encontrado){
                    System.out.println("No hay ninguna cita establecida/realizada en esa fecha");
                }
                break;
            case 2 :
                boolean encontradoAgain = false;
                for (int x = 0; x < citas.size(); x++) {
                    Cita citaObtenida = citas.get(x);
                    if (citaObtenida.getFecha().equals(fecha)) {
                        encontradoAgain = true;
                        System.out.println("ID: " + citaObtenida.getIdCita());
                        System.out.println("Paciente: " + citaObtenida.getPaciente().getNombres());
                        System.out.println("Fecha: " + citaObtenida.getFecha());
                        System.out.println("Hora: " + citaObtenida.getHora());
                    }
                }
                if(!encontradoAgain){
                    System.out.println("No hay ninguna cita establecida/realizada en esas fechas");
                }
                break;
            case 0 :
                System.out.println("Operacion cancelada");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    //Aqui dejo el RF-18, eeeh lo aplicas y/o adaptas a la creacion de citas, no me toco hacer eso Dx
    //EEH, pequeño disclaimer, las variables que estoy usando (DNIIngresado, por ejemplo) son variables
    //que he utilizado para pruebas, reemplazalas con las variables que estas usando en la creacion de
    //citas ;0. Guiate del "Se procede con la creacion", porque ahi es donde deberia continuar la creacion
    //de la cita! estoo...nada mas, bye! (mensaje a quien le haya tocado hacer la creacion de citas)
    /*
            for(int x=0;x<citas.size();x++){
                Cita citaObtenida = citas.get(x);
                if(citaObtenida.getPaciente().getDni().equals(DNIIngresado)) {
                    LocalTime horaInicioAntigua = citaObtenida.getTurno()getHoraInicio();
                    LocalTime horaFinalAntigua = citaObtenida.getTurno()getHoraFin();
                    if(citaObtenida.getFecha().equals(fechaNueva)){
                        if(horaInicioNueva.isBefore(horaFinalAntigua) &&
                        horaFinNueva.isAfter(horaInicioAntigua)){
                            System.out.println("Tenemos un problema de fechas...parece que las fechas chocan entre si, intenta con otras fechas");
                            return;
                        }
                    }
                }
            }
            System.out.println("No hay errores, se procede con la creacion!");
    */



    public static void cargarDatosPrueba() {

        // 1. Seguro
        Seguro seguro = new Seguro("SIS");

        // 2. Paciente
        Paciente paciente = new Paciente(
                "12345678",
                "Aaron",
                "Ramirez",
                "Lopez",
                LocalDate.of(2003, 5, 15),
                "M",
                "Av. Principal 123",
                "987654321",
                "aaron@gmail.com",
                seguro
        );

        // 3. Especialidad
        Especialidad especialidad = new Especialidad("Medicina General");

        // 4. Médico
        Medico medico = new Medico(
                "87654321",
                "Carlos",
                "Perez",
                "Garcia",
                LocalDate.of(1980, 3, 20),
                "M",
                "CMP12345"
        );

        // 5. Consultorio
        Consultorio consultorio = new Consultorio(
                "Consultorio 101",
                "Lima",
                "Av. Salud 456"
        );

        // 6. Horario
        Horario horario = new Horario(
                medico,
                consultorio,
                3,
                LocalTime.of(8, 0),
                LocalTime.of(12, 0)
        );

        // 7. Turno
        Turno turno = new Turno(
                horario,
                LocalDate.of(2026, 11, 11),
                LocalTime.of(9, 0),
                LocalTime.of(9, 30),
                "DISPONIBLE"
        );

        // 8. Cita
        Cita cita = new Cita(
                1,
                paciente,
                turno,
                "PROGRAMADA"
        );

        // 9. Agregar a la lista
        citas.add(cita);
        turnos.add(turno);
        seguros.add(seguro);
        pacientes.add(paciente);
        especialidades.add(especialidad);
        medicos.add(medico);
        consultorios.add(consultorio);
        horarios.add(horario);
    }
}
