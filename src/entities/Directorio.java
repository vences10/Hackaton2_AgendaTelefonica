package entities;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Locale;

//Clase donde estara el constructor de contato
public class Directorio {
    private HashMap<String, String> contactos;

    public Directorio() {
        this.contactos = new HashMap<>();
    }//constructor Directorio

    private String normalizar(String texto){
        String sinAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", ""); //quitar acentos
        return sinAcentos.toLowerCase(java.util.Locale.ROOT);
    }

    public void agregarContacto(String nombre, String apellido, String telefono) {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        this.contactos.put(nombreCompletoNormalizado, telefono);
    }//metodo agregarContacto

    public boolean existeContacto(String nombre, String apellido) {
        String nombreCompletoNormalizado = normalizar(nombre + " " + apellido);
        if (this.contactos.containsKey(nombreCompletoNormalizado)) {
            // System.out.println(nombreCompleto);
            return true;
        }//if
        //System.out.println("No hay contactos registrados con ese nombre");
        return false
    }//metodo existeContacto
    funtion listarContactos() {

    }//listarContactos

    function buscarContacto() {

    }//buscarContacto

    funtion eliminarContacto() {

    }//eliminarContacto

    funtion modificarTelefono() {

    }//modificarTelefono

    funtion agendaLlena() {

    }//agendaLlena

    funtion espaciosLibres() {

    } //espaciosLibres
}
