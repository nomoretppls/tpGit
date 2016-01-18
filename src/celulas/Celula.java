package celulas;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import control.Superficie;
import excepciones.IndicesFueraDeRango;
import utils.*;


/**
 * @author J.Henry Yanchapanta Copara
 * @author Seilys Iglesias Rojas
 *
 */


/**
 Celula: Es una clase abstracta, de la que heredan las clases concretas CelulaCompleja y
CelulaSimple. Esta clase contiene un atributo privado protected boolean esComestible.
que indica si una celula es comestible o no. 
 */
public interface  Celula {
	
	//METODOS
	/**Este m�todo realiza el movimiento de una c�lula colocada en la posici�n (f,c)
	de la superficie, y devuelve la casilla a la que se ha movido la c�lula o null en caso de
	que la c�lula no se pueda mover
	 * @param f
	 * @param c
	 * @param superficie
	 * @return
	 * @throws IndicesFueraDeRango 
	 */
	public  Casilla ejecutaMovimiento(int f, int c, Superficie superficie,StringBuilder avance) throws IndicesFueraDeRango;
	
	
	/** Este m�todo devuelve el valor del atributo esComestible. 
	 * @return
	 */
	public  boolean esComenstible();
	public void cargar(Scanner sc)throws IOException;
	public void guardar(FileWriter fw) throws IOException;
	
	

}
