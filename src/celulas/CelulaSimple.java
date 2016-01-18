package celulas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import control.Superficie;
import utils.*;

public class CelulaSimple implements Celula {
	private final int MAX_PASOS_REPRODUCCION;
	private final int MAX_PASOS_SIN_MOVER;
	private int pasReproduccion;
	private int pasNoMov;

	// CONSTRUCTOR
	public CelulaSimple(int pasosNoMov, int pasosReproduccion) {
		this.MAX_PASOS_REPRODUCCION = pasosReproduccion;
		this.MAX_PASOS_SIN_MOVER = pasosNoMov;
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
	 * Es el metodo de superficie, busco en los adyacentes a mi posicion
	 * casillas libres, crea un array de libres adyacentes devuelve una pos
	 * aleatoria del array de Casillas
	 * @return me devuelve una casilla a la que se puede mover  la  celulasimple;
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

		return libres[x];//se va a mover a esta posicion
	}

	public int getPasReproduccion() {
		return pasReproduccion;
	}

	public void setPasReproduccion(int pasReproduccion) {
		this.pasReproduccion = pasReproduccion;
	}

	public int getPasNoMov() {
		return pasNoMov;
	}

	public void setPasNoMov(int pasNoMov) {
		this.pasNoMov = pasNoMov;
	}

	@Override
	public boolean esComenstible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void cargar(Scanner sc) throws IOException {
		// TODO Auto-generated method stub
		this.pasReproduccion=new Integer(sc.nextInt());
		this.pasNoMov=new Integer(sc.nextInt());
	}

	@Override
	public void guardar(FileWriter fw) throws IOException {
		// TODO Auto-generated method stub
		fw.write("simple");
		fw.write(" ");
		fw.write(Integer.toString(this.pasReproduccion));
		fw.write(" ");
		fw.write(Integer.toString(this.pasNoMov));
	
	}

}
