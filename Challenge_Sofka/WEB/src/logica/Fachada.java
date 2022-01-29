package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import configuracion.Configuracion;
import exception.JugadorNoExisteException;
import exception.JugadorYaExisteException;

import exception.ListaLlenaException;
import exception.PersistenciaException;

import persistencia.Persistencia;
import logica.IFachada;
import logica.Monitor;
import logica.categoria.Categoria;
import logica.categoria.Categorias;
import logica.jugador.Jugador;
import logica.jugador.Jugadores;
import logica.pregunta.Pregunta;
import logica.pregunta.Preguntas;
import logica.respuesta.Respuesta;
import logica.ronda.Ronda;
import logica.ronda.Rondas;
import logica.vo.VOFachada;
import logica.vo.VOPreguntasLista;
import logica.vo.*;



@SuppressWarnings("serial")
public class Fachada   extends UnicastRemoteObject implements IFachada {

	private Jugadores jugadores;
	private Categorias categorias;
	private Rondas rondas;
	private Preguntas preguntas;
	private Monitor monitor;

	public Fachada() throws RemoteException, IOException, ClassNotFoundException {
		VOFachada voFachadaPersistencia;
		
		try {
			voFachadaPersistencia = Persistencia.recuperar( Configuracion.getProperty("ArchivoRespaldo") );

			if ( voFachadaPersistencia != null ) {
				jugadores = voFachadaPersistencia.getJugadores();
			}

			monitor = new Monitor();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(4);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(5);
		}
	}

	//Requerimiento previo: Registro de Jugador	

		public void registrarJugador( VOJugadoresLista voJugador ) throws JugadorYaExisteException{
			monitor.comienzoEscritura();
		
			Jugador jugador;
			
			if(jugadores.contiene( voJugador.getJugadorCi()) ) {
				monitor.terminoEscritura();
				throw new JugadorYaExisteException("Ya se registro un jugador con la misma cedula");
			}
			else {
				jugador = new Jugador( voJugador.getJugadorCi(), voJugador.getJugadorNombre(), voJugador.getPuntos() );
								
				jugadores.addjugador(jugador); 			
				}
			
			monitor.terminoEscritura();
		}

		
		
	//Requerimiento 1: Configurar Juego (Creación de preguntas y sus respuestas)		
	public void registrarPregunta( VOPreguntasLista voPregunta) throws AsignaturaYaExisteException, ListaLlenaException {
		monitor.comienzoEscritura();
		
		Pregunta pregunta = new Pregunta( voPregunta.getPreguntaId(),voPregunta.getPreguntaTexto(),voPregunta.getIdRespuestaValida()  );
		//Aqui No me da el tiempo para realizar el ingreso de las respuestas para la pregunta, 
		//entiendo que la lista de respuestas no tiene que estar en la fachada, sino que es independiente a cada pregunta
		//Es decir, cada pregunta tiene y conoce su lista de respuestas, sin embargo, no me da el tiempo para implementarlo.
		/*for (int i=0; i<4 ; i++) {
			VORespuestasLista voRespuesta = new VORespuestasLista( respuesta = new Respuesta();
		}
		if(respuestas.estaLlena() ) {
			monitor.terminoEscritura();
			throw new ListaLlenaException();
		}*/
				
		preguntas.addPregunta( pregunta );
		monitor.terminoEscritura();
	}


	//Requerimiento 2,3,: Iniciar el Juego		
	public void iniciarJuego( VORondasListar voRondasListar ) {
		Ronda rondaIncicial = new Ronda(voRondasListar.getRondaId(),voRondasListar.getJugador(),voRondasListar.getRondaPuntaje(),voRondasListar.getCategoriaNivelDific());
		//obtengo la categoria según el nivel de dificultad de la ronda
		Categoria categoria = new Categoria(voRondasListar.getCategoriaNivelDific);
		//se busca un numero random entre 1 y 5 que son la cantidad de preguntas de cada categoria
		int random = (int) Math.random()* 5;
		Pregunta pregunta =  preguntas.obtenerPregunta(random);
		//Aqui debe de ir el método que seleccione la respuesta, será un int (nro de respuesta)
		
		//Luego si el nro de respuesta coincide con la respuestaValida, entonces se le suman puntos al jugador.
		//Y se suma uno a la id de ronda inicial, para pasar a la segunda ronda, asi se pasa a buscar nuevamente la categoría
		//que coincide con ese nivel de dificultad y se procede nuevamente a buscar sus preguntas y elegir una de manera
		//randomica.
		//cada vez que se acierta una respuesta se acumula en el jugador el puntaje (requerimiento 5)
		
	}
	
	public boolean responderPregunta(VOPreguntasLista pregunta,int respuesta) {
		boolean respondeOK= false;
		if(pregunta.getIdRespuestaValida()== respuesta) {
			respondeOK= true;
		}
		return respondeOK;
	}

	//Requerimiento 5: Acumular puntos
	public void acumularPuntos (VOJugadoresLista voJugador, int puntos)throws JugadorNoExisteException{
		monitor.comienzoEscritura();
	
		Jugador jugador;
		
		if(jugadores.contiene( voJugador.getJugadorCi()) ) {
			monitor.terminoEscritura();
			throw new JugadorNoExisteException("No existe un jugador con la misma cedula");
		}
		else {
			jugador.setJugadorPuntos(puntos); 
					
			}
		
		monitor.terminoEscritura();
	}

	//Requerimiento 6 y 7: Fin de juego voluntario o  fin de juego forzado (guardar datos del jugador)
	public void respaldar() throws PersistenciaException, FileNotFoundException, IOException {
		monitor.comienzoEscritura();

		VOFachada voFachada = new VOFachada( jugadores,categorias,rondas,preguntas);
		Persistencia.respaldar( Configuracion.getProperty("ArchivoRespaldo"), voFachada );

		monitor.terminoEscritura();
	}
	
		


	

}

