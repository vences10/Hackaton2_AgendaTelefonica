package exceptions;

//class para Excepción Espacio Insuficiente
public class NotSuficcientSpaceException extends RuntimeException {

    // ============ CONSTRUCTOR ============
    public NotSuficcientSpaceException(String message) {
        // super(mensaje) llama al constructor de la clase Exception,
        // para que el mensaje se guarde y pueda mostrarse
        super(message);
    }
}//class
