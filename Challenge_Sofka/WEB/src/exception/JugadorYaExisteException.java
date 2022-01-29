package exception;

@SuppressWarnings("serial")
public class JugadorYaExisteException extends Exception {
 
	public JugadorYaExisteException() {
		super();
	}

	public JugadorYaExisteException(String message) {
		super(message);
	}

	
}