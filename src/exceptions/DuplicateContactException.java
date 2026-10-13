package exceptions;
//class para Excepción de duplicado Contacto
public class DuplicateContactException extends RuntimeException {

    // ============ CONSTRUCTOR ============
    public DuplicateContactException(String message) {
        // super(mensaje) llama al constructor de la clase Exception,
        // para que el mensaje se guarde y pueda mostrarse
        super(message);
    }
}//class
