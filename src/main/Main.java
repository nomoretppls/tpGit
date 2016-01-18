package main;

import control.Controlador;

/**
 * @author J.Henry Yanchapanta Copara
 * @author Seilys Iglesias Rojas
 *
 */
public class Main {
	private static final int FILAS=5;
	private static final int COLUMNAS=6;
	private static final int CELULAS=7;
	

	public static void main(String[] args) throws Exception{

		Controlador c = new Controlador();
		c.simula();
	}

}
