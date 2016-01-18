package comandos;

import control.Controlador;


public class Guardar implements Comando {
	String nomFich;
	public Guardar(String nombre) {
		this.nomFich=nombre;
	}
	public Guardar(){}


	@Override
	public void ejecuta(Controlador control) throws Exception {
		// TODO Auto-generated method stub
		control.guardar(this.nomFich);
	}

	@Override
	public Comando parsea(String[] cadenaComando) {
		// TODO Auto-generated method stub
		if(cadenaComando.length!=2)return null;
		else{
			if(cadenaComando[0].equalsIgnoreCase("GUARDAR")){
				return new Guardar(cadenaComando[1]);
				
			}
			else {
				return null;
			}
			
		}
	}

	@Override
	public String textoAyuda() {
		// TODO Auto-generated method stub
		return "Guardar fichero: Guarda una partida en el fichero indicado.\n";
	}

}
