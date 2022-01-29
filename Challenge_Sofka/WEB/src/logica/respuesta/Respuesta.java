package logica.respuesta;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Respuesta implements Serializable  {
	private int respuestaId;
	private String respuestaTexto;
	
	public Respuesta( int id, String texto ) {
		this.respuestaId = id;
		this.respuestaTexto	= texto;
	}
	
	public int getRespuestaId() {
		return respuestaId;
	}
	
	public String getRespuestaTexto() {
		return respuestaTexto;
	}

	
}