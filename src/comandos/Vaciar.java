package comandos;

import mundos.*;

public class Vaciar implements Comando {

	@Override
	public void ejecuta(Mundo mundo) {
		// TODO Auto-generated method stub
		mundo.limpiar();
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		
		if (cadenaComando[0] == "vaciar") {

			return ParserComandos.comando[5];// ayuda

		} else {
			return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "vaciar: Elimina todas las celulas de la superficie dejando las posiciones de la superficie a null.\n";
	}

}
