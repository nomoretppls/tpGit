package mundos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import celulas.*;
import excepciones.ErrorDeInicializacion;
import excepciones.IndicesFueraDeRango;

public class MundoComplejo extends Mundo {
	private int numCelulas;
	public MundoComplejo(){
		super();
		this.numCelulas=0;
	}
	
	public MundoComplejo(int filas,int columnas,int numCelulas) throws ErrorDeInicializacion{
		super(filas,columnas);
		this.numCelulas=numCelulas;
		
		this.inicializaMundo();
	}
	@Override
	public void inicializaMundo()throws ErrorDeInicializacion {
		// TODO Auto-generated method stub
		try {
			int i = 0;
			while (i<this.numCelulas){
				int f=(int)( Math.random() * 10)%filas;
				int c=(int)( Math.random() * 10)%columnas;
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
		fw.write("complejo");fw.write("line.separator");
	}
	protected void creaCelula(int f,int c){
		System.out.println("Estas en un mundo complejo.");
		System.out.print("De que tipo:Compleja (1) o Simple (2):");
		Scanner sc=new Scanner(System.in);
		int op=sc.nextInt();
		if(op==1){
			System.out.println("Creamos nueva celula simple en f,c" );
			this.superficie.creaCelula(f,c,new CelulaSimple(3,3));
			
		}
		else if(op==2){
			System.out.println("Creamos nueva celula compleja en f,c" );
			this.superficie.creaCelula(f,c,new CelulaCompleja(3));
		}
		else System.out.println("No se ha creado celula");
		
	}

}
