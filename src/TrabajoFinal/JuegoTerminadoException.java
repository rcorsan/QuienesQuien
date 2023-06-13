package TrabajoFinal;

public class JuegoTerminadoException extends RuntimeException {
    public JuegoTerminadoException() {
        super("El juego ha terminado");
    }
}