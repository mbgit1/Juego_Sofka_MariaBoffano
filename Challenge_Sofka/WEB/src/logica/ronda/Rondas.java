package logica.ronda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import logica.vo.VORondasLista;

@SuppressWarnings("serial")
public class Rondas implements Serializable {

	private ArrayList<Ronda> rondas;
	private static final int MAX = 5;

	public Rondas() {
		rondas = new ArrayList<Ronda>();
	}
	
	public Rondas( Rondas rondas ) {
		this.rondas = rondas.rondas;
	}
	
	public void addRonda( Ronda ronda ) {
		rondas.add( ronda );
	}
	
	public Ronda obtenerRonda( int id ) {
		Ronda r = null;
		int i = 0;
		boolean encontrada = false;
		
		while( i < rondas.size() && !encontrada ) {
			r = rondas.get( i );
			//if( r.getRespuestaId.equals( id ) )
			if( r.getRondaId() == id  )
				encontrada = true;
			i++;
		}
		return r;
	}
	
	public boolean existeRonda( int id ) {
		int i = 0;
		boolean existe = false;
		
		while( i < rondas.size() && !existe) {
			Ronda r = rondas.get( i );
			if( r.getRondaId() == id  ) {
				existe = true;
			}
			i++;
		}
		return existe; 
	}
	
	public boolean estaLlena() {
		return ( rondas.size() == MAX );
	}
	
	public List<VORondasLista> listarRondas() {
		List<VORondasLista> lista = new LinkedList<VORondasLista>();
		
		for( int i = 0; i < rondas.size(); i++) {
			Ronda r = rondas.get( i );
			lista.add( new VORondasLista( r.getRondaId(), r.getRondaPuntaje(), r.getCategoriaNivelDific() ) );
		}
		
		return lista;
	}
	
}
