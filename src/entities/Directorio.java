package entities;

import exceptions.ContactNotExistException;
import exceptions.DuplicateContactException;
import exceptions.NotSuficcientSpaceException;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

//Clase donde estara el constructor de contato
public class Directorio {
    private HashMap<String, String> contactos;
    private int capacidadDirectorio;

    public Directorio() {
        this.contactos = new HashMap<>();
        this.capacidadDirectorio = 10; //Limite de 10 intrucciones de Canva
    }//constructor Directorio

    private String normalizar(String texto){
        String sinAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", ""); //quitar acentos
        return sinAcentos.toLowerCase(java.util.Locale.ROOT);
    }

    public void agregarContacto(String nombre, String apellido, String telefono) throws NotSuficcientSpaceException, DuplicateContactException {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)){
            throw new DuplicateContactException("El contacto ya existe");
        }// if de duplicados
        this.contactos.put(nombreCompletoNormalizado, telefono);

        if (this.contactos.size() >= this.capacidadDirectorio) {
            throw new NotSuficcientSpaceException("Agenda llena. Elimina contactos para añadir un contacto nuevo");
        }//if agenda llena
    }//metodo agregarContacto

    public boolean existeContacto(String nombre, String apellido) {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)) {
            // System.out.println(nombreCompleto);
            return true;
        }//if
        //System.out.println("No hay contactos registrados con ese nombre");
        return false;
    }//metodo existeContacto

    public void listarContactos() {
        if (this.contactos.isEmpty()){
            System.out.println("Agenda vacía.");
            return;
        }
        //Para aprovechar el hash usamos Map<String para ordenar alfabeticamente
        // recorriendolo en un ciclo for
        Map<String, String> contactosOrdenados =new TreeMap<>(this.contactos);
        for (Map.Entry<String, String> entry : contactosOrdenados.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }//ciclo for

    }//listarContactos

    public void buscarContacto(String nombre, String apellido) throws ContactNotExistException {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)){
            System.out.println("Teléfono: " + this.contactos.get(nombreCompletoNormalizado));
        } else {
            throw new ContactNotExistException("No se encuentra el contacto");
        }//else

    }//buscarContacto

    public void eliminarContacto(String nombre, String apellido) throws ContactNotExistException{
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)){
            this.contactos.remove(nombreCompletoNormalizado);
            System.out.println("Contacto eliminado");
        } else {
            throw new ContactNotExistException("El contacto que seleccionaste no se pudo eliminar porque no existe");
        }// else

    }//eliminarContacto

    funtion modificarTelefono() {

    }//modificarTelefono

    funtion agendaLlena() {

    }//agendaLlena

    funtion espaciosLibres() {

    } //espaciosLibres
}
