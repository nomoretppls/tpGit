package celulas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import control.Superficie;
import excepciones.IndicesFueraDeRango;
import utils.*;

public class CelulaCompleja implements Celula {
	private int comidas;
	private final int MAX_CELULAS_COMIDAS;

	// CONSTRUCTOR
	public CelulaCompleja(int maximoComer) {
		this.MAX_CELULAS_COMIDAS = maximoComer;
		this.comidas = 0;
	}

	// METODOS

	@Override
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie, String avance) throws IndicesFueraDeRango {
		//he implementado este tipo de celula
		Casilla newPos;
		Casilla oldPos = new Casilla(f, c);
		int libres = 0;
		Casilla[] posLibres = new Casilla[f * c];
		posicionesLibres(posLibres, libres, superficie);
		if (libres != 0) {
			int rand = (int) (Math.random() * 10) % libres;
			newPos = posLibres[rand];
			if(superficie.getSuperficie()[newPos.getX()][newPos.getY()].esComenstible()){
				//se come celulasimple
				superficie.eliminaUnaCelula(newPos.getX(), newPos.getY());
				superficie.moverCelula(f,c,newPos.getX(),newPos.getY());
				avance=avance+"Celula Compleja en ("+f+","+c+") se mueve a("+newPos.getX()+","+newPos.getY()+") --COME--\n";
				if(this.comidas<MAX_CELULAS_COMIDAS){
					this.comidas++;			
				}
				else{//explota a la cuarta comida
					superficie.eliminaUnaCelula(newPos.getX(), newPos.getY());
					avance=avance+"Explota la celula compleja  en ("+newPos.getX()+","+newPos.getY()+")\n";
				}
				
			}
			else{// posicion vacia
				superficie.moverCelula(f,c,newPos.getX(),newPos.getY());
				avance=avance+"Celula Compleja en ("+f+","+c+") se mueve a("+newPos.getX()+","+newPos.getY()+") --NO COME--\n";
			}
			return newPos;
		} else {
			return null;
		}
	}

	public void posicionesLibres(Casilla[] posLibres, int libres, Superficie s) {
		libres = 0;
		for (int i = 0; i < s.getFilas(); i++) {
			for (int j = 0; j < s.getColumnas(); j++) {
				if (s.getSuperficie()[i][j] == null) {
					posLibres[libres] = new Casilla(i, j);
					libres++;
				} else if (s.getSuperficie()[i][j].esComenstible()) {
					//es celula simple
					posLibres[libres] = new Casilla(i, j);
					libres++;
				}
			}
		}
	}

	public int getComidos() {
		return comidas;
	}

	public void setComidos(int comidos) {
		this.comidas = comidos;
	}

	@Override
	public boolean esComenstible() {
		return false;
	}

	public void randCoor(int x, int y, Superficie s) {
		x = (int) (Math.random() * 10) % s.getFilas();
		y = (int) (Math.random() * 10) % s.getColumnas();
	}

	@Override
	public void cargar(Scanner sc) {
		// TODO Auto-generated method stub
		this.comidas = new Integer(sc.nextInt());
	}

	@Override
	public void guardar(FileWriter fw) throws IOException {
		// TODO Auto-generated method stub
		fw.write("compleja");
		fw.write(" ");
		fw.write(Integer.toString(this.comidas));
	}

}
