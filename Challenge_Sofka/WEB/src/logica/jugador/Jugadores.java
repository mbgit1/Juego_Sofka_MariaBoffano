package logica.jugador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logica.Diccionario;
import logica.vo.VOJugadoresLista;


@SuppressWarnings("serial")
public class Jugadores extends Diccionario<Integer,Jugador> implements Serializable {


	public Jugadores() {
		super();	
	}

	public Jugadores( Jugadores jugadores ) {
		this.ponerTodos(jugadores);
	}


	public void addJugador(Jugador jugador) {
		poner(jugador.getJugadorCi(), jugador);
	}


	public boolean existeJugador(int cedula) {
		return contiene(cedula);
	}

	public Jugador obtenerJugador(int cedula) {
		return obtener(cedula);
	}
	public List<VOJugadoresLista> listarJugadores(){
		
		Jugador jugador;
		Iterator<Jugador> iteradorJugador = iterador();
		List<VOJugadoresLista> jugadorSalida = new ArrayList<VOJugadoresLista>();
		VOJugadoresLista vojugador= null; 

		while (iteradorJugador.hasNext()) {
			jugador = iteradorJugador.next();
			vojugador = new VOJugadoresLista(jugador.getJugadorCi(),jugador.getJugadorNombre(),jugador.getJugadorPuntos());
			jugadorSalida.add(vojugador);
				
		}

		return jugadorSalida;	 

	}
	
}