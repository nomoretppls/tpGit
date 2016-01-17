package logica;
import celulas.*;
import utils.*;
/**
 * @author J.Henry Yanchapanta Copara
 * @author Seilys Iglesias Rojas
 *
 */
public class Superficie {
	private Celula[][] superficie;
	private int filas;
	private int columnas;
	private Posicion[] libres;
	
	
	final int MAX_CELULAS_S = 2;
	final int MAX_CELULAS_C = 2;
	final int PASOS_REPRODUCCION = 3;
	final int MAX_PASOS_SIN_MOVER = 3;

	

	/**Constructor de la clase que inicia todas las posiciones de la superfice  con un puntero a null.
	 * 
	 * @param nf numero de filas que tendra la superficie.
	 * @param nc numero de columnas que tendra la superficie.
	 */
	public Superficie(int nf, int nc) {
		this.filas=nf;
		this.columnas=nc;
		superficie = new CelulaSimple[this.filas][this.columnas];

		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				superficie[i][j] = null;
			}
		}
	}
	
	
	/**Metodo que prepara la superficie instanciando  MAX_CELULAS celulas ,aleatoriamente, en la superficie.
	 * 
	 */
	public void iniciar(){
	
		int i = 0;
		while (i < MAX_CELULAS_S) {
			int num1 = (int)( Math.random() * 10)% filas;
			int num2 = (int) (Math.random() * 10) % columnas;
			if (superficie[num1][num2] == null) {
				superficie[num1][num2] = new CelulaSimple(MAX_PASOS_SIN_MOVER, PASOS_REPRODUCCION);
				i++;
			}
		}
		i=0;
		while (i < MAX_CELULAS_C) {
			int num1 = (int)( Math.random() * 10)% filas;
			int num2 = (int) (Math.random() * 10) % columnas;
			if (superficie[num1][num2] == null) {
				superficie[num1][num2] = new CelulaSimple(MAX_PASOS_SIN_MOVER, PASOS_REPRODUCCION);
				i++;
			}
		}
	}
	
	
	/**Metodo que  verifica los espacios libres en las posiciones vecinas de una celula y las guarda en el atributo libres del objeto de tipo superficie
	 * @param f int , numero de fila en la que se encuentra la celula a verificar
	 * @param c int , numero de columna  en la que se encuentra la celula verificar
	 *//*
	public void huecos(int f, int c){//solo adyacentes
		 libres = new Posicion[8];
		
		int i = 0;
				if(f-1>=0 && c-1>=0 && superficie[f-1][c-1]==null){
					libres[i]=new Posicion();				
					libres[i].newPos(f-1, c-1);
					i++;
				}
				if(f-1>=0 && c>=0 && superficie[f-1][c]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f-1, c);
					i++;	
				}
				if(f-1>=0 && c+1<columnas && superficie[f-1][c+1]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f-1, c+1);
					i++;

				}
				if(f>=0 && c-1>=0 && superficie[f][c-1]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f, c-1);
					i++;
					
				}
				if(f>=0 && c+1<columnas&& superficie[f][c+1]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f, c+1);
					i++;

				}
				if(f+1<filas && c-1>=0 && superficie[f+1][c-1]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f+1, c-1);
					i++;
				}
				if(f+1<filas && c>=0 && superficie[f+1][c]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f+1, c);
					i++;
				}
				if(f+1<filas && c+1<columnas && superficie[f+1][c+1]==null){
					libres[i]=new Posicion();
					libres[i].newPos(f+1, c+1);
					i++;
					
				}
	}*/
	
	
	public void inicializaArrayMovidos(boolean[][] movido){
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
					movido[i][j] = false;
				
			}
			
		}
	}
	
	//devuelve String
	
	/**Metodo que realiza los movimientos de las celulas cuando se realiza un paso ,intenta realizar el movimiento y actuar en consecuencia.
	 * @return string mensaje, que devuelve los pasos que ha realizado la evolucion. 
	 */
	public String movimiento(){
		String mensaje= "";
		boolean acciones = false;
		
		boolean[][] movido = new boolean[filas][columnas];
		inicializaArrayMovidos(movido); 
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (superficie[i][j] != null ) {// selecciono una celula	
					ejecutaMovimiento(i,j);// aqui meto posiciones libres  del atributo libres
					//necesito este i j
					int huecosLibres = size(libres);
					if(huecosLibres > 0){// movimiento y reproduccion si procede
						int randNum=(int)(Math.random()*10)%huecosLibres;						
						//superficie[i][j].setMove(true);
						superficie[i][j].setPasosReproduccion(superficie[i][j].getPasosReproduccion()-1);
						superficie[libres[randNum].getX()][libres[randNum].getY()] = superficie[i][j];
						
						superficie[i][j] = null;
						//Si se mueve guarda este mensaje
						mensaje=mensaje+"Movimiento de ("+i+","+j+") a ("+libres[randNum].getX()+","+libres[randNum].getY()+").\n";
						// 
						if (superficie[libres[randNum].getX()][libres[randNum].getY()].getPasosReproduccion() == -1 && huecosLibres > 0){
							acciones=creaCelula(i,j);//mensaje de rerpoduccion
							mensaje=mensaje+"Nace una celula en ("+i+","+j+")"+ "cuyo padre es ("+libres[randNum].getX()+","+libres[randNum].getY()+").\n";
							superficie[libres[randNum].getX()][libres[randNum].getY()].setPasosReproduccion(3);
						}
//						
					    
					}
					else{//NO movimineto y muerte si procede
						
						superficie[i][j].setPasNoMov(superficie[i][j].getPasNoMov()-1);
						if(superficie[i][j].getPasNoMov()==-1){
							acciones=eliminaUnaCelula(i, j);
							mensaje=mensaje+"Muere la celula ("+i+","+j+") por inactividad.\n";
								
						}
						else if(superficie[i][j].getPasosReproduccion()==0){
							superficie[i][j] = null;	
							mensaje=mensaje+"Muere la celula ("+i+","+j+") por no poder reproducirse.\n";
							
						}
					} 
						
				}
			}
		}
		
		//ahora vuelvo a poner en false move para los proximos movimientos de las celulas
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (superficie[i][j]!=null){
					//superficie[i][j].setMove(false);
				}
			}
			
		}
		return mensaje;
	}
	
	// sirve para saber cuantas posiciones hay guardadas en el array
	
	/**Metodo que cuenta  las posiciones ocupadas de un array de tipo Posicion,
	 * cuya longitud maxima es 8, que son las posiciones libres maximas que puede tener
	 * una celula a su alrededor.
	 * @param p Array de  tipo Posicion.
	 * @return int , numero entero que devuelve el numero de posiciones ocupadas de la array.
	 */
	public int size(Posicion[] p){
		int cont= 0;
		
		while (p[cont]!=null){
			cont++;		
		}
		return cont;
	}
	
	/**Metodo que verifica si una posicion  de la superficie esta vacia.
	 * @param fila  numero de fila de la posiciona verificar..
	 * @param columna numero de columna de la posicion a verificar.
	 * @return devuelve un boolean true si esta vacia , false en caso contrario.
	 */
	public boolean esVacio(int fila, int columna){
		return (superficie[fila][columna] == null);
	}
	
	
	/**Metodo que verifica si  una posicion de la superficie no esta ocupada por una celula.
	 * Si esta ocupada por una celula este metodo la elimina , coloca la posicion apuntando a null,
	 * en cuyo caso devuelve un boolean true, en caso contrario devuelve un boolean false. 
	 * @param fila numero de fila que ocupa la celula.
	 * @param columna numero de columna que ocupa la celula.
	 * @return devuelve un boolean true si se elimina la celula , false en caso contrario.
	 */
	public boolean eliminaUnaCelula(int fila, int columna){
		//si no es vacia, hay celula, la quito
		if (!esVacio(fila, columna)){
			superficie[fila][columna] = null;
			return true;
		}
		//si no he podido, false
		return false;
	}
	
	/**Metodo que elimina todas las celulas de la superficie .
	 * 
	 */
	public void vaciarSuperficie(){
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				superficie[i][j] = null;
			}
		}
	}
	
	/**Metodo que verifica si una  posicion de la superficie  esta  ocupada, si esta vacia 
	 * instancia una celula en dicha posicion y devuelve un boolean true  , en caso contrario devuelve false.
	 * @param fila numero de fila de la posicion en la que se instanciara la celula.
	 * @param columna  numero de columna de la posicion en la que se instanciara la celula.
	 * @return devuelve un boolean true si se instancia una celula , false en caso contrario.
	 */
	public boolean creaCelula(int fila, int columna){
		//si es igual a null, creo la celula
		if (esVacio(fila, columna)){
			superficie[fila][columna] = new CelulaSimple(PASOS_REPRODUCCION, PASOS_REPRODUCCION);
			return true;
		}
		//si no la creo, falso
		return false;
	}
	
	
	/**Metodo que recorre la superficie y devuelve un string  con las posiciones de la superficie. 
	 * @return string , devuelve un string con todas las posiciones de la superficie
	 */
	public String mostrar(){
		String mensaje="";
		for (int i = 0; i < filas; i++) {
			for (int k = 0; k < columnas; k++) {
				if (superficie[i][k]==null){
					mensaje=mensaje+"  "+"\t--";
				}
				else{
					mensaje=mensaje+"\t"+"("+superficie[i][k].getPasNoMov()+"-"+superficie[i][k].getPasosReproduccion()+")";
				}
			}
			mensaje=mensaje+"\n";
		}
		return mensaje;
	}
	
	/**Metodo que verifica si la superficie esta vacia.
	 * @return devuelve un boolean true si la superficie esta vacia , en caso contrario devuelve false.
	 */
	public boolean superficieVacia(){
		boolean vacia=true;
		for (int i = 0; i < filas && vacia; i++) {
			for (int j = 0; j < columnas && vacia; j++) {
				if(!esVacio(i,j)) vacia=false;
				
			}
		}		
		return vacia;
	}
	
	
	public Casilla ejecutaMovimiento(int f, int c){
		//celula.ejecutaMovimiento(...)
		return (superficie[f][c].ejecutaMovimiento(f, c, this));		
		
	}
	
	public Celula[][] getSuperficie() {
		return superficie;
	}


	public int getFilas() {
		return filas;
	}


	public int getColumnas() {
		return columnas;
	}

	
	
}
