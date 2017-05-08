package distribuidos.sistemas;

import java.io.IOException;
import distribuidos.sistemas.servidor.Controlador;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:07:59
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Controlador controlador = new Controlador();
		controlador.iniciar();
	}

}
