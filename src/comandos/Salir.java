package comandos;

import mundos.*;

public class Salir implements Comando {

	@Override
	public void ejecuta(Mundo mundo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		if (cadenaComando[0] == "salir") {

			return ParserComandos.comando[7];// ayuda

		} else {
			return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "salir: Termina el juego y sale del programa.\n";
	}

}
