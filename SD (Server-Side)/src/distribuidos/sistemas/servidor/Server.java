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
public class Server extends ServerSocket {

	private static final int PORTA = 5588;

	/* */

	private Controlador controlador;

	public Server() throws IOException {
		super(Server.PORTA);
		this.controlador = new Controlador();
	}

	public void iniciar() {
		this.controlador.iniciar();
		System.out.println("Servidor iniciado em " + Server.PORTA);
	}

	public void run() {
		try {
			Socket socket = super.accept();
			if ((socket != null)) {
				System.out.println(" Nova Conexão > " + socket.getInetAddress());
				Usuario usuario = new Usuario(socket, this.controlador);
				usuario.start();
			}
		} catch (IOException e) {
			// TODO O que fazer aqui?
		}

		// Chamada recursiva pro servidor não parar....
		this.run();
	}

}
