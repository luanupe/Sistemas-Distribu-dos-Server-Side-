package distribuidos.sistemas.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:09:37
 *
 */
public class Controlador extends ServerSocket {

	private static final int PORTA = 5588;

	/* */

	public Controlador() throws IOException {
		super(Controlador.PORTA);
		System.out.println("Servidor iniciado em " + Controlador.PORTA);
	}

	public void iniciar() {
		while (true) {
			try {
				Socket socket = super.accept();
				if ((socket != null)) {
					System.out.println(" Nova Conexão > " + socket.getInetAddress());
					Usuario usuario = new Usuario(socket);
					usuario.start();
				}
			} catch (IOException e) {
				// TODO O que fazer aqui?
			}
		}
	}

}
