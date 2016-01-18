package control;

import comandos.*;
import mundos.*;
import excepciones.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import excepciones.ErrorDeInicializacion;
import excepciones.FormatoNumericoIncorrecto;
import excepciones.IndicesFueraDeRango;
import excepciones.PalabraIncorrecta;

/**
 * @author J.Henry Yanchapanta Copara
 * @author Seilys Iglesias Rojas
 *
 */
public class Controlador {

	private Mundo m = null;
	private Scanner scan;
	private boolean simulacionTerminada = false;

	/**
	 * Metodo que interactua con el ususario mostrandole las acciones que puede
	 * realizar el Mundo ,asi como la ayuda al usuario.
	 * 
	 */
	public void simula() {
		System.out.println("BIENVENIDO AL JUEGO DE LA VIDA");
		ParserComandos pc = new ParserComandos();
		menuOpciones();

		while (!simulacionTerminada) {
			try {
				scan = new Scanner(System.in);
				String cin = scan.nextLine().toString();
				String[] entrada = cin.split(" ");

				Comando comando = ParserComandos.parseaComando(entrada);
				if (comando != null) {
					comando.ejecuta(this);// me devuelve el comando
											// correspondiente

				}

			} catch (PalabraIncorrecta e) {
				e.getStackTrace();
				System.out.println("pi" + e.toString());
			} catch (IndicesFueraDeRango e) {
				e.getStackTrace();
				System.out.println("ifr" + e);
			} catch (ErrorDeInicializacion e) {
				e.getStackTrace();
				System.out.println("edi" + e);
			} catch (FileNotFoundException e) {
				e.getStackTrace();
				System.out.println("fnfe" + e);
			} catch (FormatoNumericoIncorrecto e) {
				e.getStackTrace();
				System.out.println(e);
			} catch (Exception e) {
				e.getStackTrace();
				System.out.println(e + "e");
			} finally {
				if (!m.superficieVacia()&& !simulacionTerminada) {
					System.out.println(m.mostrarAvance());
				}
				if(!simulacionTerminada) menuOpciones();
				
			}
			
		}
	}

	public void cargar(String nomFich) throws FormatoNumericoIncorrecto, IOException, ErrorDeInicializacion, PalabraIncorrecta {
		Mundo game = this.m;
		Scanner sc = new Scanner(new File(nomFich));
		try {
			String typeGame = sc.nextLine();
			if (typeGame.equalsIgnoreCase("SIMPLE")) {
				this.m = new MundoSimple();
				this.m.cargar(sc);
			} else {
				if (typeGame.equalsIgnoreCase("COMPLEJO")) {
					this.m = new MundoComplejo();
					this.m.cargar(sc);
				} else {
					throw new PalabraIncorrecta("ERROR al cargar.");
				}
			}
//		} catch (PalabraIncorrecta e) {
//			this.m = game;
//		} 
			}
			catch (FormatoNumericoIncorrecto e) {
			this.m = game;

		} catch (IndicesFueraDeRango e) {
			System.out.println("EXCEPTION: El fichero tiene celulas fuera de rango." + e.toString());
		} finally {
			// sc.close();
		}
	}

	public void guardar(String nomFich) {
		try {
			FileWriter fw = new FileWriter(nomFich);// sobreescribimos el
													// fichero
			this.m.guardarMundo(fw);
			this.m.guardar(fw);
			fw.flush();
			fw.close();
		} catch (IOException e) {

		} catch (IndicesFueraDeRango e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErrorDeInicializacion e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void daUnPaso() throws IndicesFueraDeRango {
		if (m != null && !m.superficieVacia()) {
			System.out.println(m.mostrarAvance());
			String mensaje = m.evoluciona();
			System.out.println("Se ha dado un paso en la evolucion. \n"+mensaje);
		} else {
			System.out.println("No se ha podido dar un paso en la evolucion, la superficie esta vacia.\n");
		}

	}

	public void juega(Mundo mundo) throws Exception {// este mundo se inicia en
														// el comando juega y												// aqui lo instancio
		this.m = mundo;
		mundo.inicializaMundo();
		// completar

	}

	// fin del while
	// comando guarda el comando que se va a ejecutar

	// mientras lo que se escribe no sea igual a salir o es vacia
	/*
	 * while (!cadena.equals("salir")) {
	 * 
	 * 
	 * /** Metodo que muestra las opciones que puede elegir el usuario para el
	 * desarrollo del mundo celular.
	 * 
	 * 
	 */
	public void menuOpciones() {

		System.out.println("ESCRIBE UNA DE LAS SIGUIENTES OPCIONES, COMO APARECEN");
		System.out.println("JUGAR M F C S C");
		System.out.println("INICIAR");
		System.out.println("PASO");
		System.out.println("CREARCELULA F C");
		System.out.println("ELIMINARCELULA F C");
		System.out.println("VACIAR");
		System.out.println("CARGAR [nombreFichero]");
		System.out.println("GUARDAR [nombreFichero]");
		System.out.println("AYUDA");
		System.out.println("SALIR");
		System.out.print("COMANDO > ");

	}

	/**
	 * Mensaje de despedida, que se envia cuando se termina el programa.
	 * 
	 */
	public void salir() {
		this.simulacionTerminada = true;
		System.out.println("HASTA PRONTO");
	}

	public void eliminar(int fila, int columna) {
		// TODO Auto-generated method stub
		boolean ok;
		try {
			ok = this.m.eliminar(fila, columna);
			if (ok) {
				System.out.println("Eliminamos la celula de la posicion: ("+fila+","+columna+").\n");
			} else {
				System.out.println("No se ha eliminado la celula");
			}
		} catch (IndicesFueraDeRango e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString()+"----");

			// e.printStackTrace();
		}

	}

	public void ayuda() {
		// TODO Auto-generated method stub
		System.out.println(this.m.mostrarAyuda());
	}

	public void crearCelula(int fila, int columna)  {
		// TODO Auto-generated method stub
		try {
			
			this.m.crearCelula(fila, columna);
			System.out.println("Creamos nueva celula en la posicion:("+fila+","+columna+").\n");
		} catch (IndicesFueraDeRango e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

	public void iniciar() {
		// TODO Auto-generated method stub
		try {
			this.m.inicializaMundo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void vaciar() {
		// TODO Auto-generated method stub
		this.m.limpiar();

	}

}
