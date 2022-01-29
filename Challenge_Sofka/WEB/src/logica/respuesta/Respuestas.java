package logica.respuesta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import logica.respuesta.Respuesta;
import logica.vo.VORespuestasLista;

@SuppressWarnings("serial")
public class Respuestas implements Serializable {
	
	private ArrayList<Respuesta> respuestas;
	private static final int MAX = 4;

	public Respuestas() {
		respuestas = new ArrayList<Respuesta>();
	}
	
	public Respuestas( Respuestas respuestas ) {
		this.respuestas = respuestas.respuestas;
	}
	
	public void addRespuesta( Respuesta respuesta ) {
		respuestas.add( respuesta );
	}
	
	public Respuesta obtenerRespuesta( int id ) {
		Respuesta r = null;
		int i = 0;
		boolean encontrada = false;
		
		while( i < respuestas.size() && !encontrada ) {
			r = respuestas.get( i );
			//if( r.getRespuestaId.equals( id ) )
			if( r.getRespuestaId() == id  )
				encontrada = true;
			i++;
		}
		return r;
	}
	
	public boolean existeRespuesta( int id ) {
		int i = 0;
		boolean existe = false;
		
		while( i < respuestas.size() && !existe) {
			Respuesta r = respuestas.get( i );
			if( r.getRespuestaId() == id  ) {
				existe = true;
			}
			i++;
		}
		return existe; 
	}
	
	public boolean estaLlena() {
		return ( respuestas.size() == MAX );
	}
	
	public List<VORespuestasLista> listarRespuestas() {
		List<VORespuestasLista> lista = new LinkedList<VORespuestasLista>();
		
		for( int i = 0; i < respuestas.size(); i++) {
			Respuesta r = respuestas.get( i );
			lista.add( new VORespuestasLista( r.getRespuestaId(), r.getRespuestaTexto() ) );
		}
		
		return lista;
	}
	
	
}
