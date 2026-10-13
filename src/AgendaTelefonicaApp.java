import entities.Directorio;

public class AgendaTelefonicaApp {
    public static void main(String[] args) {
        Directorio dir = new Directorio(); //crear directorio
        // Agregar contactos
        dir.agregarContacto("Juan", "Pérez", "555-1234");
        dir.agregarContacto("María", "López", "555-5678");
        dir.agregarContacto("Carlos", "Ramírez", "555-9999");

        System.out.println("Buscar JUAN PEREZ ¿existe? " + dir.existeContacto("JUAN", "PEREZ"));
    }//main
}//class AgendaTelefonicaApp
