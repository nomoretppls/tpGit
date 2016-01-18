package comandos;

import control.Controlador;
import excepciones.ErrorDeInicializacion;
import mundos.*;

public class Iniciar implements Comando{

	@Override
	public void ejecuta(Controlador control)throws ErrorDeInicializacion{
		// TODO Auto-generated method stub
		Mundo mundo;
		String cin =scan;
		String cadena =.toLowerCase().trim();
		String[] entrada = cadena.split(" ");
		if(entrada[1].equals("simple")){
			//hacer cast a int de entrada[2] etc..
			mundo= new MundoSimple((int)entrada[2],(int)entrada[3],(int) entrada[4]);
		}
		
		mundo.iniciar();
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0]=="iniciar"){
			
			return ParserComandos.comando[1];//ayuda
			
		}
		else{
		return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "Inicia el mundo colocando las celulas en la superficie aleatoriamente.";
	}

	

}
