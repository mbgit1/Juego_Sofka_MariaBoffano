package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VORespuestasLista implements Serializable  {
		private int respuestaId;
		private String respuestaTexto;
		
		
		public VORespuestasLista( int id, String texto) {
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
