package celulas;

import logica.Superficie;
import utils.*;

public class CelulaSimple extends Celula {
	private final int MAX_PASOS_REPRODUCCION;
	private final int MAX_PASOS_SIN_MOVER;

	// CONSTRUCTOR
	public CelulaSimple(int pasNoMov, int pasosReproduccion) {
		this.MAX_PASOS_REPRODUCCION = pasosReproduccion;
		this.MAX_PASOS_SIN_MOVER = pasNoMov;
	}

	// METODOS

	public int size(Casilla[] c) {
		int cont = 0;
		while (c[cont] != null) {
			cont++;
		}
		return cont;
	}

	/**
	 * Es el mï¿½todo de superficie, busco en los adyacentes a mi posicion
	 * casillas libres, crea un array de libres adyacentes devuelve una pos
	 * aleatoria del array de Casillas
	 */
	@Override
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie) {// solo
		int tamañoArray = 8; 
		Casilla libres[] = new Casilla[tamañoArray];

		int i = 0;
		if (f - 1 >= 0 && c - 1 >= 0
				&& superficie.getSuperficie()[f - 1][c - 1] == null) {
			libres[i] = new Casilla(f - 1, c - 1);
			i++;
		}
		if (f - 1 >= 0 && c >= 0
				&& superficie.getSuperficie()[f - 1][c] == null) {
			libres[i] = new Casilla(f - 1, c);
			i++;
		}
		if (f - 1 >= 0 && c + 1 < superficie.getColumnas()
				&& superficie.getSuperficie()[f - 1][c + 1] == null) {
			libres[i] = new Casilla(f - 1, c + 1);
			i++;

		}
		if (f >= 0 && c - 1 >= 0
				&& superficie.getSuperficie()[f][c - 1] == null) {
			libres[i] = new Casilla(f, c - 1);
			i++;

		}
		if (f >= 0 && c + 1 < superficie.getColumnas()
				&& superficie.getSuperficie()[f][c + 1] == null) {
			libres[i] = new Casilla(f, c + 1);
			i++;

		}
		if (f + 1 < superficie.getFilas() && c - 1 >= 0
				&& superficie.getSuperficie()[f + 1][c - 1] == null) {
			libres[i] = new Casilla(f + 1, c - 1);
			i++;
		}
		if (f + 1 < superficie.getFilas() && c >= 0
				&& superficie.getSuperficie()[f + 1][c] == null) {
			libres[i] = new Casilla(f + 1, c);
			i++;
		}
		if (f + 1 < superficie.getFilas() && c + 1 < superficie.getColumnas()
				&& superficie.getSuperficie()[f + 1][c + 1] == null) {
			libres[i] = new Casilla(f + 1, c + 1);
			i++;

		}

		int x = (int) (Math.random() * 10) % size(libres);

		return libres[x];
	}

	@Override
	public boolean esComenstible() {
		// TODO Auto-generated method stub
		return true;
	}

}
