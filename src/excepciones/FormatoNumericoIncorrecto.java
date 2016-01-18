package excepciones;

public class FormatoNumericoIncorrecto extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public FormatoNumericoIncorrecto(String mensaje){
		this.mensaje=mensaje;
		
	}
	// para recibir y mostrar el mensaje de error que se ha dado
	public String  toString(){
		return mensaje;
		
	}

}
