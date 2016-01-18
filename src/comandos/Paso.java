package comandos;
import control.Controlador;
import excepciones.IndicesFueraDeRango;
import mundos.*;

public class Paso implements Comando{

	@Override
	public void ejecuta(Controlador control) throws IndicesFueraDeRango {
		// TODO Auto-generated method stub
		control.daUnPaso();
	}
	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		if(cadenaComando[0].equalsIgnoreCase("PASO")){
			return ParserComandos.comando[0];
		}
		else{
		return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		String ayuda=" Paso: Este comando realiza un paso en la evolucion moviendo las celulas.\n";
		return ayuda;
	}

}
