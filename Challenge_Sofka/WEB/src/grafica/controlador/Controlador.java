package grafica.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import configuracion.Configuracion;


public abstract class Controlador {
	
/*	private Ventana ventana;
	private IFachada fachada;
	
	public Controlador( Ventana ventana) {
		this.ventana = ventana;
		
		String servidorIp;
		String servidorPuerto;

		try {
			servidorIp = Configuracion.getProperty("ServidorIp");
			servidorPuerto = Configuracion.getProperty("ServidorPuerto");
			fachada = (IFachada) Naming.lookup("//" + servidorIp + ":" + servidorPuerto + "/fachada");
		} catch (FileNotFoundException e) {
			showMessageDialog( "Falta el archivo de configuraci�n" );
			System.exit(1);
		} catch (IOException e) {
			showMessageDialog( "El servidor est� ca�do" );
			System.exit(2);
		} catch (NotBoundException e) {
			showMessageDialog( "El servidor est� ca�do" );
			System.exit(2);
		}
		
	}
	
	public Ventana getVentana() {
		return ventana;
	}

	public IFachada getFachada() {
		return fachada;
	}
	
	public void showMessageDialog( String string ) {
		ventana.showMessageDialog( string );
	}
	
	protected boolean soloNumeros( String string ) {
        Pattern pattern = Pattern.compile( "^[0-9]*$" );

        Matcher matcher = pattern.matcher( string );
        boolean matches = matcher.matches();
        
        return matches;
	}
	*/
}
