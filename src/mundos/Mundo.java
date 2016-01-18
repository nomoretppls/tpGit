package mundos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import comandos.*;
import control.*;
import excepciones.ErrorDeInicializacion;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IndicesFueraDeRango;
import excepciones.PalabraIncorrecta;

/**
 * @author J.Henry Yanchapanta Copara
 * @author Seilys Iglesias Rojas
 *
 */
public abstract class Mundo {
	private boolean simulacionTerminada = true;// se modificara cuando se
												// ejecute el comando salirS
	protected Superficie superficie;
	protected int filas;
	protected int columnas;
	// private ParserComandos pc=new ParserComandos();

	// CONSTRUCTOR
	/**
	 * 
	 */
	public Mundo() {
		superficie = null;
		filas = 0;
		columnas = 0;
	}

	// public Mundo() {
	//
	// superficie = new Superficie(filas, columnas);
	// pc = new ParserComandos();
	// superficie.iniciar();
	// }
	public Mundo(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.superficie = new Superficie(filas, columnas);
	}

	public abstract void inicializaMundo() throws Exception;

	public abstract void cargar();

	public abstract void guardarMundo(FileWriter fw) throws IOException;

	protected abstract void creaCelula(int f, int c) throws IndicesFueraDeRango;

	/**
	 * @param fw
	 * @throws IOException
	 * @throws IndicesFueraDeRango
	 * @throws ErrorDeInicializacion 
	 */
	public void guardar(FileWriter fw) throws IOException, IndicesFueraDeRango, ErrorDeInicializacion {

		fw.write(Integer.toString(this.filas));
		fw.write(System.getProperty("line.separator"));
		fw.write(Integer.toString(this.columnas));
		fw.write(System.getProperty("line.separator"));
		if (superficie != null) {
			this.superficie.guardar(fw);// explota fw
		}
		else throw new  ErrorDeInicializacion("Superficie apunta a null, no se puede guardar nada. ");
		
	}

	public void cargar(Scanner sc)
			throws PalabraIncorrecta, FormatoNumericoIncorrecto, IOException, IndicesFueraDeRango, ErrorDeInicializacion {
		this.filas = sc.nextInt();
		this.columnas = sc.nextInt();
		this.superficie = new Superficie(this.filas, this.columnas);
		if (superficie != null) {
			this.superficie.cargar(sc);
		}
		else throw new  ErrorDeInicializacion("Superficie apunta a null, no se puede cargar. ");

	}

	// para vaciar la superficie
	/**
	 * Metodo que elimina las celulas de la superficie.
	 * 
	 */
	public void limpiar() {
		superficie.vaciarSuperficie();
	}

	// __________________________________________________
	/**
	 * Metodo que muestra al usuario el progreso de las celulas.
	 * 
	 * @return devuelve un string con el avance de la superficie.
	 */
	public String mostrarAvance() {
		return superficie.mostrar();
	}

	public boolean isSimulacionTerminada() {
		return simulacionTerminada;
	}

	public void setSimulacionTerminada(boolean simulacionTerminada) {
		this.simulacionTerminada = simulacionTerminada;
	}

	/**
	 * Metodo que inicia el mundo.
	 * 
	 */
	// public void iniciar() {
	// superficie.iniciar();
	// }

	/**
	 * Metodo que da un paso en la evolucion del mundo celular.
	 * 
	 * @return devuelve un string con las acciones que realizan las celulas del
	 *         mundo.
	 * @throws IndicesFueraDeRango
	 */
	public String evoluciona() throws IndicesFueraDeRango {
		StringBuilder avance = new StringBuilder();
		superficie.movimiento(avance);
		return avance.toString();
	}

	/**
	 * Metodo que elimina las celulas de la superficie.
	 * 
	 * @return devuelve un boolean si las elimina , en caso contrario devuelve
	 *         false.
	 */
	public boolean superficieVacia() {
		return superficie.superficieVacia();
	}

	/**
	 * Metodo que crea una celula en una posicino de la superficie.
	 * 
	 * @param f
	 *            fila de la posicion de la superfice donde instanciara la
	 *            celula.
	 * @param c
	 *            columna de la posicion de la superfice donde instanciara la
	 *            celula.
	 * @return devuelve un boolean si crea la celula, en caso contrario devuelve
	 *         false.
	 */

	// public boolean crear(int f, int c) {
	// return (superficie.creaCelula(f, c));
	// }

	/**
	 * Metodo que elimina una celula de una posicion de la superficie.
	 * 
	 * @param f
	 *            fila de la posicion de la superfice donde se eliminara la
	 *            celula.
	 * @param c
	 *            columna de la posicion de la superfice donde se eliminara la
	 *            celula.
	 * @return devuelve un boolean true si elimina la celula , false en caso
	 *         contrario.
	 * @throws IndicesFueraDeRango
	 */
	public boolean eliminar(int f, int c) throws IndicesFueraDeRango {
		return (superficie.eliminaUnaCelula(f, c));
	}

	public String mostrarAyuda() {

		return ParserComandos.ayudaComandos();
	}

	public void crearCelula(int fila, int columna) throws IndicesFueraDeRango {
		if (superficie.esVacio(fila, columna)) {
			this.creaCelula(fila, columna);
		} else {
			System.out.println("Posicion ocupada.");
		}
	}

}
