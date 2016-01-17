package utils;
/**
 La clase Casilla implementa una coordenada (x,y) y
tendr� constructora con argumentos as� c�mo m�todos de consulta a las coordenadas.
*/
public class Casilla {
	
	private int x;
	private int y;
	
	public Casilla(int x, int y){
		this.x = x;
		this.y = y;
	}

	
	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}

	

}
