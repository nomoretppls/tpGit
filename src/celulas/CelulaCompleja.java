package celulas;


import java.io.FileWriter;
import java.util.Scanner;

import control.Superficie;
import utils.*;

public class CelulaCompleja implements Celula {
	private int comidos;
	private final int MAX_CELULAS_COMIDAS;
	
	//CONSTRUCTOR
	public CelulaCompleja(int maximoComer){
		this.MAX_CELULAS_COMIDAS = maximoComer;
		this.comidos = 0;
	}
	

	//METODOS
	
	@Override
	public Casilla ejecutaMovimiento(int f, int c, Superficie superficie) {
		Casilla mueveteAqui; // la creo cuando encuentro la pos aleat vacia
		
		int x = 0, y = 0;		
		//creo coordenas aleatorias en x e y
		randCoor(x, y, superficie);

		while (!superficie.esVacio(x, y)){//si esta vacia crea devuelve la casilla donde se creara
			//si no es comestible, busco una posicion nueva
			if (!superficie.getSuperficie()[x][y].esComenstible()) {
				int x1 = 0, y1 = 0;
				randCoor(x1, y1, superficie);
				while (x1 == x && y1 == y){
					randCoor(x1, y1, superficie);
				}
				x=x1;y=y1;
			}
			else {// si es comestible
				mueveteAqui=new Casilla(x,y);
				return mueveteAqui;
			}
			/* Esto creo que hay que comprobarlo en otro sitio.
			//si es comestible, y no he alcanzado el maximo de comidas
			else if (superficie.getSuperficie()[x][y].esComenstible() && comidos < MAX_CELULAS_COMIDAS){
				mueveteAqui = new Casilla(x, y);
				return mueveteAqui;
			}
			//si es comestible y he alcanzado el maximo de comidas permitidas
			else if (comidos == MAX_CELULAS_COMIDAS){
				superficie.eliminaUnaCelula(x, y);
			}
			*/

		}
		//si la primera que encuentro es libre, devuelvo la casilla a donde mover la celula
		mueveteAqui = new Casilla(x, y);
		return mueveteAqui;
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
		this.comidos=new Integer(sc.nextInt());
	}

	@Override
	public void guardar(FileWriter fw) {
		// TODO Auto-generated method stub
		
	}
	
	
}
