package excepciones;

public class PalabraIncorrecta extends Exception{
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public PalabraIncorrecta(String mensaje){
		this.mensaje=mensaje;
		
	}
	// para recibir y mostrar el mensaje de error que se ha dado
	public String  toString(){
		return mensaje;
		
	}

}
