import entities.Contacto;
import entities.Directorio;
import exceptions.DuplicateContactException;
import interfaces.Addable;

import java.util.Scanner;

public class AgendaTelefonicaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Directorio dir = new Directorio(); //crear directorio

        // Agregar contactos
        dir.agregarContacto("Juan", "Pérez", "555-1234");
        dir.agregarContacto("María", "López", "555-5678");
        dir.agregarContacto("Carlos", "Ramírez", "555-9999");
        dir.agregarContacto("Ana", "González", "555-89984" +
                "");

        do {
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. ¿Existe contacto?");
            System.out.println("4. Listar contactos");
            System.out.println("5. Modificar contactos");
            System.out.println("6. Eliminar contactos");
            System.out.println("7. Salir");

            System.out.print("Ingresa la opción deseada: ");
            opcion = sc.nextInt();
            sc.nextLine(); // <-- limpiar buffer
            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    dir.agregarContacto(nombre, apellido, telefono);
                    System.out.println("Contacto añadido.");
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
                    System.out.print("Ingresa en nuevo número de teléfono: ");
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
                    break;
                default:
                    System.out.println("Opción Incorrecta - Intentalo nuevamente");

            }//do
        }
            while (opcion != 7) ;
        sc.close();
        }//main
}//class AgendaTelefonicaApp
