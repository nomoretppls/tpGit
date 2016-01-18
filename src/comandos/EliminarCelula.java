package comandos;

import control.Controlador;


public class EliminarCelula implements Comando{
	private int fila;
	private  int columna;
	@Override
	public void ejecuta(Controlador control) {
		// TODO Auto-generated method stub
		control.eliminar(fila, columna);
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("ELIMINARCELULA")){
			fila=Integer.parseInt(cadenaComando[1]);
			columna=Integer.parseInt(cadenaComando[2]);
			return ParserComandos.comando[3];//ayuda
			
		}
		else{
		return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "EliminarCelula: Elimina la celula  de la fila f y columna c.\n";
	}

	

}
