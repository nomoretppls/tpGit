package comandos;



public class ParserComandos {
	static Comando[] comando = { new Paso(), new Iniciar(),
			new CrearCelulaFC(),new EliminarCelula(), new Vaciar(), new Ayuda(), new Salir(),new Jugar() };

	static public String ayudaComandos() {
		String ayuda = "Posibles comandos:\n";
		for (int i = 0; i < comando.length; i++) {
			ayuda = ayuda + comando[i].textoAyuda();
		}
		return ayuda;
	}

	/**
	 * Te devuelve el comando que se esta leyendo de la entrada, y que se va a
	 * ejecutar.
	 * 
	 * @param cadenas
	 * @return
	 */
	static public Comando parseaComando(String[] cadenas) {
		Comando c = null;
		boolean escomando = false;

		for (int j = 0; j < comando.length && !escomando; j++) {
			Comando aux = comando[j].parsea(cadenas);
			if (aux instanceof Comando) {
				c = aux;
				escomando = true;
			}

		}

		return c;
	}

}
