package distribuidos.sistemas.servidor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import distribuidos.sistemas.servidor.servicos.Multiplicar;
import distribuidos.sistemas.servidor.servicos.Somar;
import distribuidos.sistemas.servidor.servicos.Subtrair;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 9 de mai de 2017
 * Time: 08:56:59
 *
 */
public class Controlador {

	private Map<String, Class<?>> servicos;

	protected Controlador() {
		this.servicos = new HashMap<String, Class<?>>();
	}

	public void iniciar() {
		this.servicos.put("somar", Somar.class);
		this.servicos.put("subtrair", Subtrair.class);
		this.servicos.put("multiplicar", Multiplicar.class);
	}

	public void gerenciar(Usuario usuario, String nome, List<String> args) {
		try {
			ServicoInterface servico = this.getServico(nome);
			if ((servico == null)) {
				usuario.enviar("Serviço " + nome + " não está disponível.");
			} else {
				servico.iniciar(usuario, args);
				String resposta = servico.executar();
				usuario.enviar(resposta);
			}
		} catch (Exception e) { 
			// TODO Cliente desatualizado?
		}
	}

	public ServicoInterface getServico(String nome) throws Exception {
		if ((this.servicos.containsKey(nome) == false)) {
			return null;
		}
		return (ServicoInterface) this.servicos.get(nome).newInstance();
	}

}
