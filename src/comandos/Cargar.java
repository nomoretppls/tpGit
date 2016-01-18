package comandos;

import java.io.FileNotFoundException;

import control.Controlador;
import excepciones.FormatoNumericoIncorrecto;


public class Cargar implements Comando {
	String nomFich;

	public Cargar(String nombre) {
		this.nomFich=nombre;
	}
	public Cargar(){}

	@Override
	public void ejecuta(Controlador control) throws FileNotFoundException, FormatoNumericoIncorrecto {
		// TODO Auto-generated method stub
		control.cargar(this.nomFich);
		
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		if(cadenaComando.length!=2)return null;
		else{
			if(cadenaComando[0].equalsIgnoreCase("cargar")){
				return new Cargar(cadenaComando[1]);
				
			}
			else {
				return null;
			}
			
		}
		
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return null;
	}

}
