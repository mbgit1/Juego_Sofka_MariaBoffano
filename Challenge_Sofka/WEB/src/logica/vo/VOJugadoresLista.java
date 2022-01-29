package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOJugadoresLista implements Serializable  {
		private int jugadorCi;
		private String jugadorNombre;
		private int jugadorPuntos;
		
		
		public VOJugadoresLista( int cedula, String nombre, int puntos ) {
			this.jugadorCi	= cedula;
			this.jugadorNombre	= nombre;
			this.jugadorPuntos	= puntos;
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
		
		
}
