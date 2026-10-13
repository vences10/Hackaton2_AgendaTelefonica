package exceptions;

//class para Excepción de Contacto no existente
public class ContactNotExistException extends RuntimeException {

    // ============ CONSTRUCTOR ============
    public ContactNotExistException(String message) {
        // super(mensaje) llama al constructor de la clase Exception,
        // para que el mensaje se guarde y pueda mostrarse
        super(message);
    }
}//class
