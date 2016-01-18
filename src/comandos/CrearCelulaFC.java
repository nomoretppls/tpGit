package comandos;

import control.*;


public class CrearCelulaFC implements Comando{
	private int fila;
	private int columna;
	public CrearCelulaFC(int fila,int columna){
		this.fila=fila;
		this.columna=columna;
	}
	@Override
	public void ejecuta(Controlador control) {
		// TODO Auto-generated method stub
		control.crearCelula(this.fila,this.columna);
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		if(cadenaComando.length!=3)return null;
		else{
			if(cadenaComando[0].equalsIgnoreCase("CREARCELULA")){
				int f=Integer.parseInt(cadenaComando[1]);
				int c=Integer.parseInt(cadenaComando[2]);
				return new CrearCelulaFC(f,c);
				
			}
			else {
				return null;
			}
			
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return null;
	}

}
