package comandos;


import control.*;



public interface  Comando {

	
	public void ejecuta(Controlador control)throws Exception;
	public  Comando parsea(String[ ] cadenaComando)throws Exception;
	public  String textoAyuda();

}
