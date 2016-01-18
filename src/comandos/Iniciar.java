package comandos;

import control.Controlador;
import excepciones.ErrorDeInicializacion;


public class Iniciar implements Comando{

	@Override
	public void ejecuta(Controlador control)throws ErrorDeInicializacion{
		// TODO Auto-generated method stub
		control.iniciar();
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		if(cadenaComando[0].equalsIgnoreCase("iniciar")){
			
			return ParserComandos.comando[1];
			
		}
		else{
		return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "Iniciar: Inicia el mundo colocando las celulas en la superficie aleatoriamente.";
	}

	

}
