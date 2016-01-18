package mundos;

import java.io.FileWriter;
import java.io.IOException;

import celulas.CelulaSimple;
import control.Superficie;
import excepciones.ErrorDeInicializacion;
import excepciones.IndicesFueraDeRango;

public class MundoSimple extends Mundo {
	private int numCelulas;
	public MundoSimple(){
		super();
		this.numCelulas=0;
	}
	
	public MundoSimple(int filas,int columnas,int numCelulas) throws ErrorDeInicializacion{
		super(filas,columnas);
		this.numCelulas=numCelulas;


		this.inicializaMundo();
	}
	@Override
	public void inicializaMundo() throws ErrorDeInicializacion {
		// TODO Auto-generated method stub
		
		try {
			int i = 0;
			while (i<this.numCelulas){
				int f=(int)( Math.random() * 10)%this.filas;
				int c=(int)( Math.random() * 10)%this.columnas;
				if(this.superficie.esVacio(f,c)){
					this.superficie.creaCelula(f,c,new CelulaSimple(3,3));
					i++;
				}
			}

		} catch (IndicesFueraDeRango e) {
			
			throw new ErrorDeInicializacion("EXCEPTION:No se inicia el mundo.");
		}
	}

	@Override
	public void cargar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarMundo(FileWriter fw) throws IOException {
		// TODO Auto-generated method stub
		fw.write("simple");fw.write(System.getProperty("line.separator"));
	}
	
	protected void creaCelula(int f,int c) throws IndicesFueraDeRango{
		System.out.println("Estas en un mundo simple");
		this.superficie.creaCelula(f,c,new CelulaSimple(3,3));
	}

	

}
