package logica.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class VOCategoriasLista implements Serializable  {
		private int categoriaNivelDific;
		
		
		public VOCategoriasLista( int nivel) {
			this.categoriaNivelDific = nivel;
			
		}
		
		public int getCategoriaNivelDific() {
			return categoriaNivelDific;
		}
		
		
}
