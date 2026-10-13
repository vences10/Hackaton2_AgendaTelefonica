import entities.Directorio;
import java.util.Scanner;

public class AgendaTelefonicaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Directorio dir = new Directorio();
        int opcion;
        boolean salir = false;

        do {
            System.out.println("\n1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. ¿Existe contacto?");
            System.out.println("4. Listar contactos");
            System.out.println("5. Modificar contactos");
            System.out.println("6. Eliminar contactos");
            System.out.println("7. Salir");
            System.out.print("Ingresa la opción deseada: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    dir.agregarContacto(nombre, apellido, telefono);
                    System.out.println("Contacto añadido");
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombreBuscar = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoBuscar = sc.nextLine();
                    dir.buscarContacto(nombreBuscar, apellidoBuscar);
                    break;
                case 3:
                    System.out.print("Nombre: ");
                    String nombreExiste = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoExiste = sc.nextLine();
                    boolean existe = dir.existeContacto(nombreExiste, apellidoExiste);
                    System.out.println(existe ? "Sí existe" : "No existe");
                    break;
                case 4:
                    dir.listarContactos();
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    String nombreModificar = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoModificar = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String telefonoModificar = sc.nextLine();
                    dir.modificarTelefono(nombreModificar, apellidoModificar, telefonoModificar);
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    String nombreEliminar = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEliminar = sc.nextLine();
                    dir.eliminarContacto(nombreEliminar, apellidoEliminar);
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta - Inténtalo nuevamente");
            }
        } while (!salir);
        sc.close();
    }//main
}//class AgendaTelefonicaApp