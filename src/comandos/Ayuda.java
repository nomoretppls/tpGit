package comandos;

import control.Controlador;
import mundos.*;

public class Ayuda implements Comando {

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		if(cadenaComando[0].equalsIgnoreCase("AYUDA")){
			return ParserComandos.comando[5];//ayuda
		}
		else{
		return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "Ayuda: Muestra la ayuda de los comandos que se puede realizar.\n";
	}

	@Override
	public void ejecuta(Controlador control) throws Exception {
		
		// TODO Auto-generated method stub
		control.ayuda();
		
	}
	

}
