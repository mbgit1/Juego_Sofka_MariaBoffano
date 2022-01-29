package logica.pregunta;

import java.io.Serializable;
import java.util.List;
import configuracion.Configuracion;
import exception.ListaLlenaException;
import logica.respuesta.Respuesta;
import logica.respuesta.Respuestas;
import logica.vo.VOPreguntasLista;
import logica.vo.VORespuestasLista;


@SuppressWarnings("serial")
public class Pregunta implements Serializable {

	private int preguntaId;
	private String preguntaTexto;
	private int idRespuestaValida;
	private Respuestas respuestas;
	

	public Pregunta(int id, String texto, int respuestaV)	{

		this.preguntaId = id;
		this.preguntaTexto = texto;
		this.idRespuestaValida = respuestaV;
		this.respuestas = new Respuestas();
		
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

	public void addRespuesta(Respuesta respuesta){

		this.respuestas.addRespuesta(respuesta); 

	}
	
	public Respuestas getRespuestas(){

		return this.respuestas;
	}
	
	public VOPreguntasLista voPreguntasLista() {
		return new VOPreguntasLista(preguntaId, preguntaTexto, idRespuestaValida);
	}

	

}