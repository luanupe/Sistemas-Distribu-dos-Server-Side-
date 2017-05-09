package distribuidos.sistemas.servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:32:56
 *
 */
public class Usuario extends Thread {

	private Socket socket;
	private Controlador controlador;
	private StringBuilder packet;

	protected Usuario(Socket socket, Controlador controlador) {
		this.packet = new StringBuilder();
		this.socket = socket;
		this.controlador = controlador;
	}

	@Override
	public void run() {
		try {
			int atual;
			while ((atual = this.socket.getInputStream().read()) > 0) {
				this.packet.append((char) atual);
			}

			String[] args = this.packet.toString().split("%");
			List<String> parametros = new ArrayList<String>();
			for (int i = 1; i < args.length; ++i) {
				parametros.add(args[i]);
			}
			
			this.controlador.gerenciar(this, args[0], parametros);
		} catch (IOException e) {
			// TODO o que fazer aqui?
		} finally {
			this.fechar();
		}
	}

	public void enviar(String mensagem) throws IOException {
		mensagem = mensagem + '\0';
		this.socket.getOutputStream().write(mensagem.getBytes());
		this.socket.getOutputStream().flush();
	}

	private void fechar() {
		try {
			Thread.sleep(3000);
			this.socket.close();
		} catch (Exception e) {
			// TODO O que fazer?
		}
	}

}
