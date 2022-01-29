package logica.ronda;

import java.io.Serializable;


import logica.jugador.Jugador;

	
@SuppressWarnings("serial")
public class Ronda implements Serializable  {
		private int rondaId;
		private int rondaPuntaje;
		private int categoriaNivelDific;
		private Jugador jugador;
		
		
		public Ronda( int id, int puntaje, int catNivel, Jugador jugador) {
			this.rondaId = id;
			this.rondaPuntaje = puntaje;
			this.categoriaNivelDific = catNivel;
			this.jugador = jugador;
		}
		
		public int getRondaId() {
			return rondaId;
		}
		
		public int getRondaPuntaje() {
			return rondaPuntaje;
		}
		
		public int getCategoriaNivelDific() {
			return categoriaNivelDific;
		}

		
		public Jugador getJugador() {
			return jugador;
		}
	

}
