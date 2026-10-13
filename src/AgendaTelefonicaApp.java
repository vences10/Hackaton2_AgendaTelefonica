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

        System.out.println("Buscar JUAN PEREZ ¿existe? " + dir.existeContacto("JUAN", "PEREZ"));

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
            switch (opcion) {

                case 1:
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.println("Teléfono: ");
                    String telefono = sc.nextLine();
                    dir.agregarContacto(nombre, apellido, telefono);
                    System.out.println("Contacto añadido.");
                    break;
                case 2:
                    System.out.println("Nombre: ");
                    String nombreBuscar = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoBuscar = sc.nextLine();
                    dir.buscarContacto(nombreBuscar, apellidoBuscar);
                    break;
                case 3:
                    System.out.println("Nombre: ");
                    String nombreExiste = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoExiste = sc.nextLine();
                    dir.existeContacto(nombreExiste, apellidoExiste);
                    break;
                case 4:
                    dir.listarContactos();
                    break;
                case 5:
                    System.out.println("Nombre: ");
                    String nombreModificar = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoModificar = sc.nextLine();
                    System.out.println("Ingresa en nuevo número de teléfono: ");
                    String telefonoModificar = sc.nextLine();
                    dir.modificarTelefono(nombreModificar, apellidoModificar, telefonoModificar);
                    break;
                case 6:
                    System.out.println("Nombre: ");
                    String nombreEliminar = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoEliminar = sc.nextLine();
                    dir.eliminarContacto(nombreEliminar, apellidoEliminar);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción Incorrecta - Intentalo nuevamente");

            }//do
        }
            while (opcion != 0) ;
        sc.close();
        }//main
}//class AgendaTelefonicaApp
