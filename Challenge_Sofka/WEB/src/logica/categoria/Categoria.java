package logica.categoria;
import java.io.Serializable;
import java.util.List;

import configuracion.Configuracion;
import logica.pregunta.Pregunta;
import logica.pregunta.Preguntas;
import logica.vo.VOCategoriasLista; 
import logica.vo.VOPreguntasLista;


@SuppressWarnings("serial")
public class Categoria implements Serializable {

	private int categoriaNivelDific;
	private Preguntas preguntas;


	public Categoria(int categoria)	{

		this.categoriaNivelDific = categoria;
		this.preguntas = new Preguntas();


	}



	public int getCategoriaNivelDific() {
		return categoriaNivelDific;
	}

	public void addPregunta(Pregunta pregunta){

		this.preguntas.addPregunta(pregunta); 

	}

	

	public Preguntas getPreguntas(){

		return this.preguntas;

	}

	public VOCategoriasLista voCategoriasLista() {
		return new VOCategoriasLista(categoriaNivelDific);
	}
	


	public Pregunta obtenerPregunta(int idPregunta) {

		return preguntas.obtenerPregunta(idPregunta);
	}

}

