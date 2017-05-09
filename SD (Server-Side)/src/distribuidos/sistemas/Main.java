package distribuidos.sistemas;

import java.io.IOException;
import distribuidos.sistemas.servidor.Server;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:07:59
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.iniciar();
		server.run();
	}

}
