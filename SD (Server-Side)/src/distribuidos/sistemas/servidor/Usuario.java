package distribuidos.sistemas.servidor;

import java.io.IOException;
import java.net.Socket;

import distribuidos.sistemas.servidor.servicos.Somar;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:32:56
 *
 */
public class Usuario extends Thread {

	private Socket socket;

	protected Usuario(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			StringBuilder packet = new StringBuilder();
			int atual;

			while ((atual = this.socket.getInputStream().read()) > 0) {
				packet.append((char) atual);
			}

			String mensagem = packet.toString();
			if ((mensagem.isEmpty())) {
				this.enviar("Requisição inválida.");
			} else {
				mensagem = mensagem.trim();
				mensagem = mensagem.substring(1, (mensagem.length() - 1));

				String[] args = mensagem.split("%");
				if ((args.length <= 0)) {
					this.enviar("Parâmetros inválidos.");
				} else {
					ServicoInterface servico = this.getServico(args[0]);
					if ((servico == null)) {
						this.enviar("Serviço '" + args[0] + "' indisponível.");
					} else {
						for (int i = 1; i < args.length; ++i) {
							servico.add(args[i]);
						}

						String resultado = servico.executar();
						this.enviar(resultado);
					}
				}
			}
		} catch (IOException e) {
			// TODO o que fazer aqui?
		} finally {
			this.fechar();
		}
	}

	private ServicoInterface getServico(String nome) {
		if ((nome.equals("somar"))) {
			return new Somar(this);
		} else if ((nome.equals("subtrair"))) {
			
		} else if ((nome.equals("multiplicar"))) {
			
		} else if ((nome.equals("dividir"))) {
			
		}

		return null;
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
