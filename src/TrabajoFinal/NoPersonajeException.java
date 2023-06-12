package TrabajoFinal;

public class NoPersonajeException extends Exception {
	public NoPersonajeException() {
		super("No hay ningun personaje con esas caracteristicas!");
	}
}
