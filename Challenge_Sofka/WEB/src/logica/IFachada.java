package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.List;

import exception.ListaLlenaException;
import logica.vo.VOJugadoresLista;
import logica.pregunta.Pregunta;
import logica.vo.*;

public interface IFachada  extends Remote { 

	public void registrarJugador( VOJugadoresLista voJugador) throws RemoteException, JugadorYaExisteException ;
	
	public void registrarPregunta( VOPreguntasLista voPreguntas );
	
	public void iniciarJuego( VORondasLista voRondas );
	
	public boolean responderPregunta (VOPreguntasLista pregunta,int respuesta);
	
	public void acumularPuntos( VOJugadoresLista jugador, int puntos ) throws RemoteException, JugadorNoExisteException;
	
	public void respaldar()  throws RemoteException, PersistenciaException, FileNotFoundException, IOException;



}
