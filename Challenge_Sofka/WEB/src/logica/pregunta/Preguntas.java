package logica.pregunta;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import logica.pregunta.Pregunta;
import logica.vo.VOPreguntasLista;


@SuppressWarnings("serial")
public class Preguntas implements Serializable  {
	
	LinkedList<Pregunta> preguntas;
	
	public Preguntas() {
		preguntas = new LinkedList<Pregunta>();
	}	
    
	
	public void addPregunta( Pregunta pregunta ) {
		preguntas.add( pregunta );
	}
	
	public Pregunta obtenerPregunta( int id ) {
		return preguntas.get( id );
	}
	

	public List<VOPreguntasLista> listarPreguntas() {
		List<VOPreguntasLista> listaPreguntas = new LinkedList<VOPreguntasLista>();

		for(Pregunta i: preguntas) {
			listaPreguntas.add( new VOPreguntasLista( i.getPreguntaId(), i.getPreguntaTexto(), i.getIdRespuestaValida()) );
			}
		
		return listaPreguntas;
	}	
	
		
	
}
