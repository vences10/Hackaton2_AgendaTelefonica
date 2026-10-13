package entities;

import exceptions.ContactNotExistException;
import exceptions.DuplicateContactException;
import exceptions.NotSufficientSpaceException;
import interfaces.Addable;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

//Clase donde estara el constructor de contato
public class Directorio implements Addable {
    private HashMap<String, Contacto> contactos;
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

    public void agregarContacto(String nombre, String apellido, String telefono) throws NotSufficientSpaceException, DuplicateContactException {

        if (this.contactos.size() >= this.capacidadDirectorio) {
            throw new NotSufficientSpaceException("Agenda llena. Elimina contactos para añadir un contacto nuevo");
        }//if agenda llena
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);

        if (this.contactos.containsKey(nombreCompletoNormalizado)){
            throw new DuplicateContactException("El contacto ya existe");
        }// if de duplicados

        Contacto nuevo = new Contacto(nombre, apellido, telefono);
        this.contactos.put(nombreCompletoNormalizado, nuevo);
        System.out.println("Contacto añadido: " + nuevo);


    }//metodo agregarContacto

    public boolean existeContacto(String nombre, String apellido) {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)) {
            System.out.println(nombreCompletoNormalizado);
            return true;
        }//if
        throw new ContactNotExistException("No existe el contacto");
        //return false;
    }//metodo existeContacto

    public void listarContactos() throws ContactNotExistException {
        if (this.contactos.isEmpty()){
            throw new ContactNotExistException("Agenda vacia");
        }// if
        Map<String, Contacto> contactosOrdenados = new TreeMap<>(this.contactos);
        for (Map.Entry<String, Contacto> entry : contactosOrdenados.entrySet()){
            Contacto c = entry.getValue();
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }// for
    }//listar contactos

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

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) throws ContactNotExistException {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)) {
            this.contactos.get(nombreCompletoNormalizado).setTelefono(nuevoTelefono);
            System.out.println("Teléfono actualizado. Nuevo teléfono: " + nuevoTelefono);
        } else {
            throw new ContactNotExistException("No se pudo modificar el teléfono porque el contacto no existe");
        }//else
    }//modificarTelefono

    public boolean agendaLlena() {
        if (this.contactos.size() >= this.capacidadDirectorio) {
            System.out.println("La agenda está llena. No hay espacio disponible para nuevos contactos.");
            return true;
        }//if
        System.out.println("La agenda aún tiene espacio disponible.");
        return false;
    }//agendaLlena

    public int espaciosLibres() {
        int libres = this.capacidadDirectorio - this.contactos.size();
        System.out.println("Puedes agregar " + libres + " contacto(s) más (capacidad máxima: " + this.capacidadDirectorio + ").");
        return libres;
    } //espaciosLibres

    @Override
    public void aniadirContacto(Contacto c) {
        try {
            agregarContacto(c.getNombre(), c.getApellido(), c.getTelefono());
        } catch (NotSufficientSpaceException | DuplicateContactException e) {
            throw e;
        }
    }
}
