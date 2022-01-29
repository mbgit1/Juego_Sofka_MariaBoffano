package logica.categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import logica.Diccionario;
import logica.jugador.Jugador;
import logica.vo.VOCategoriasLista;
import logica.vo.VOJugadoresLista;
/*import logica.vo.VOAlumnoListado;

*/
@SuppressWarnings("serial")
public class Categorias extends Diccionario<Integer,Categoria> implements Serializable {


	public Categorias() {
		super();	
	}

	public Categorias( Categorias categorias ) {
		this.ponerTodos(categorias);
	}


	public void addCategoria(Categoria categoria) {
		poner(categoria.getCategoriaNivelDific(), categoria);
	}


	public boolean existeCategoria(int nivelDificultad) {
		return contiene(nivelDificultad);
	}

	public Categoria obtenerCategoria(int nivelDificultad) {
		return obtener(nivelDificultad);
	}
	
	public List<VOCategoriasLista> listarCategorias(){

		Categoria categoria;
		Iterator<Categoria> iteradorCategoria = iterador();
		List<VOCategoriasLista> categoriaSalida = new ArrayList<VOCategoriasLista>();
			VOCategoriasLista voCategoria =null;
		while (iteradorCategoria.hasNext()) {
			categoria = iteradorCategoria.next();
			voCategoria = new VOCategoriasLista(categoria.getCategoriaNivelDific());
			categoriaSalida.add(voCategoria);
			
		}

		return categoriaSalida;

	}
	
				
}
