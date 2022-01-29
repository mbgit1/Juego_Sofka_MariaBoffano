package exception;



@SuppressWarnings("serial")
public class JugadorNoExisteException extends Exception{
		public JugadorNoExisteException() { super(); }
		public JugadorNoExisteException(String message) {
			super(message);
		}
}
