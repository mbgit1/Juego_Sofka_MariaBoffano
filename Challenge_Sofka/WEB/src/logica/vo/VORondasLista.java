package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VORondasLista implements Serializable{
	private int rondaId;
	private int rondaPuntaje;
	private int categoriaNivelDific;
		
	public VORondasLista( int id, int puntaje, int nivelDific) {
			this.rondaId = id;
			this.rondaPuntaje = puntaje;
			this.categoriaNivelDific = nivelDific;
			}
		
		public int getRondaId() {
			return rondaId;
		}
		
		public int getRondaPuntaje() {
			return rondaPuntaje;
		}
		public int getRondaCategoriaNivelDific() {
			return categoriaNivelDific;
		}
		
}
