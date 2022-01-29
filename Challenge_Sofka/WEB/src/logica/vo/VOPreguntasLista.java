package logica.vo;


import java.io.Serializable;

@SuppressWarnings("serial")
public class VOPreguntasLista implements Serializable  {
		private int preguntaId;
		private String preguntaTexto;
		private int idRespuestaValida;
		
		
		public VOPreguntasLista( int id, String texto, int rValida ) {
			this.preguntaId	= id;
			this.preguntaTexto	= texto;
			this.idRespuestaValida	= rValida;
			}
		
		public int getPreguntaId() {
			return preguntaId;
		}
		
		public String getPreguntaTexto() {
			return preguntaTexto;
		}
		
		public int getIdRespuestaValida() {
			return idRespuestaValida;
		}
		
}
