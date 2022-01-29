package logica.jugador;

import java.io.Serializable;
import java.util.List;

import configuracion.Configuracion;
import logica.vo.VOJugadoresLista;


@SuppressWarnings("serial")
public class Jugador implements Serializable {

	private int jugadorCi;
	private String jugadorNombre;
	private int jugadorPuntos;
	

	public Jugador(int jugadorCi, String jugadorNombre, int jugadorPuntos)	{

		this.jugadorCi = jugadorCi;
		this.jugadorNombre = jugadorNombre;
		this.jugadorPuntos = jugadorPuntos;
		
	}



	public int getJugadorCi() {
		return jugadorCi;
	}

	public String getJugadorNombre() {
		return jugadorNombre;
	}

	public int getJugadorPuntos() {
		return jugadorPuntos;
	}

	public void setJugadorPuntos(int puntos) {
		this.jugadorPuntos = puntos;
	}

	

	public VOJugadoresLista voJugadoresLista() {
		return new VOJugadoresLista(jugadorCi, jugadorNombre, jugadorPuntos);
	}

		
	public void modificarJugador(int puntos ) {
		this.setJugadorPuntos(puntos);
		if( Configuracion.debug() ) {
			System.out.println( "Modificar Jugador cedula: " + jugadorCi + ", Puntos: " + puntos );
		}
	}

	

}
