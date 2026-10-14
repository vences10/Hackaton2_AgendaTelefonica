package exceptions;

//class para Excepción Espacio Insuficiente
public class NotSufficientSpaceException extends RuntimeException {

    // ============ CONSTRUCTOR ============
    public NotSufficientSpaceException(String message) {
        // super(mensaje) llama al constructor de la clase Exception,
        // para que el mensaje se guarde y pueda mostrarse
        super(message);
    }
}//class
