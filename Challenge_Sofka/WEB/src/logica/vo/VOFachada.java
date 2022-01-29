package logica.vo;

import java.io.Serializable;

import logica.categoria.Categorias;
import logica.jugador.Jugadores;
import logica.pregunta.Preguntas;
import logica.ronda.Rondas;


@SuppressWarnings("serial")
public class VOFachada implements Serializable {
		
		private Jugadores jugadores;
		private Categorias categorias;
		private Rondas rondas;
		private Preguntas preguntas;
		
		public VOFachada() {
			jugadores = new Jugadores();
			categorias = new Categorias();
			rondas = new Rondas();
			preguntas = new Preguntas();
		}
		
		public VOFachada(Jugadores jugadores, Categorias categorias, Rondas rondas, Preguntas preguntas ) {
			this.jugadores = jugadores;
			this.categorias = categorias;
			this.rondas = rondas;
			this.preguntas = preguntas;
		}
		
		public Jugadores getJugadores() {
			return jugadores;
		}
		
		public void setJugadores(Jugadores jugadores) {
			this.jugadores = jugadores;
		}
		
		public Categorias getCategorias() {
			return categorias;
		}
		
		public void setCategorias(Categorias categorias) {
			this.categorias = categorias;
		}

		public Rondas getRondas() {
			return rondas;
		}

		public void setRondas(Rondas rondas) {
			this.rondas = rondas;
		}

		public Preguntas getPreguntas() {
			return preguntas;
		}

		public void setPreguntas(Preguntas preguntas) {
			this.preguntas = preguntas;
		}
		
}
