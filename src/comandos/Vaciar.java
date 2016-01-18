package comandos;

import control.Controlador;


public class Vaciar implements Comando {

	@Override
	public void ejecuta(Controlador control) {
		// TODO Auto-generated method stub
		control.vaciar();
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		
		if (cadenaComando[0].equalsIgnoreCase("VACIAR")) {

			return ParserComandos.comando[4];// ayuda

		} else {
			return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "Vaciar: Elimina todas las celulas de la superficie dejando las posiciones de la superficie a null.\n";
	}

}
