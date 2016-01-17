package utils;
/**
 La clase Casilla implementa una coordenada (x,y) y
tendrá constructora con argumentos así cómo métodos de consulta a las coordenadas.
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
