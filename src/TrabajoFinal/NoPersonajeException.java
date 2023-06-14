package TrabajoFinal;

public class NoPersonajeException extends Exception {
    public NoPersonajeException() {
        super("No hay ningún personaje con esas características");
    }
}