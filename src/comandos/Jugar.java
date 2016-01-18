package comandos;

import control.Controlador;
import excepciones.ErrorDeInicializacion;
import excepciones.IndicesFueraDeRango;
import excepciones.PalabraIncorrecta;
import mundos.*;

public class Jugar implements Comando {
	private Mundo mundo;//aqui inicio un nuevo mundo para cada juego

	@Override
	public void ejecuta(Controlador control) throws Exception {
		// TODO Auto-generated method stub
		control.juega(this.mundo);
	}

	@Override
	public Comando parsea(String[] cadenaComando) throws ErrorDeInicializacion, IndicesFueraDeRango, PalabraIncorrecta {
		// TODO Auto-generated method stub
		
		if (cadenaComando[0].equalsIgnoreCase("JUGAR")) {
			int f= Integer.parseInt(cadenaComando[2]);
			int c= Integer.parseInt(cadenaComando[3]);
			int cs= Integer.parseInt(cadenaComando[4]);
			
			if (cadenaComando[1].equalsIgnoreCase("SIMPLE")) {
				mundo = new MundoSimple(f,c,cs);
			} else if (cadenaComando[1].equalsIgnoreCase("COMPLEJO")) {
				int cc= Integer.parseInt(cadenaComando[5]);
				mundo = new MundoComplejo(f,c,cs,cc);

			}
			else{
				throw new PalabraIncorrecta("Tipo de mundo incorrecto");
			}
			return ParserComandos.comando[7];// ayuda

		} else {
			return null;
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "Jugar tipomundo filas columnas csimples ccomplejas : Inicia un juego  con las caracteristicas introducidas.\n";
	}

}
