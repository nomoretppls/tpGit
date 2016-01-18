package comandos;

import control.Controlador;
import mundos.*;

public class Jugar implements Comando {
	private Mundo mundo;//aqui inicio un nuevo mundo para cada juego

	@Override
	public void ejecuta(Controlador control) throws Exception {
		// TODO Auto-generated method stub
		control.juega(this.mundo);
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		
		if (cadenaComando[0] == "jugar") {
			if (cadenaComando[1].equals("simple")) {
				mundo = new MundoSimple();
			} else if (cadenaComando[1].equals("complejo")) {
				mundo = new MundoComplejo();

			}
			return ParserComandos.comando[7];// ayuda

		} else {
			return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return null;
	}

}
