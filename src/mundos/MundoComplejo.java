package mundos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import celulas.*;
import control.Superficie;
import excepciones.ErrorDeInicializacion;
import excepciones.IndicesFueraDeRango;

public class MundoComplejo extends Mundo {
	private int numSimples;
	private int numComplejas;
	public MundoComplejo(){
		super();
		this.numSimples=0;
		this.numComplejas=0;
	}
	
	public MundoComplejo(int filas,int columnas,int numSimples,int numComplejas) throws ErrorDeInicializacion, IndicesFueraDeRango{
		super(filas,columnas);
		this.numSimples=numSimples;
		this.numComplejas=numComplejas;
		
		this.inicializaMundo();
	}
	@Override
	public void inicializaMundo()throws ErrorDeInicializacion,IndicesFueraDeRango {
		// TODO Auto-generated method stub
		this.superficie=new Superficie(filas,columnas);
		try {
			int i = 0;
			while (i<this.numSimples){
				int f=(int)( Math.random() * 10)%this.filas;
				int c=(int)( Math.random() * 10)%this.columnas;
				if(this.superficie.esVacio(f,c)){
					this.superficie.creaCelula(f,c,new CelulaSimple(3,3));
					i++;
				}
			}
			int j=0;
			while (j<this.numComplejas){
				int f=(int)( Math.random() * 10)%this.filas;
				int c=(int)( Math.random() * 10)%this.columnas;
				if(this.superficie.esVacio(f,c)){
					this.superficie.creaCelula(f,c,new CelulaCompleja(3));
					j++;
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
	protected void creaCelula(int f,int c) throws IndicesFueraDeRango{
		System.out.println("Estas en un mundo complejo, que se le va a hacer T-T.");
		System.out.print("De que tipo:Simple (1) o Compleja (2):");
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
		else System.out.println("tipo de celula no valida");
		
	}

}
