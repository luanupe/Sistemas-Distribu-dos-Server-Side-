package distribuidos.sistemas.servidor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import distribuidos.sistemas.servidor.servicos.Somar;

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
	}

	public void gerenciar(Usuario usuario, String nome, List<String> args) {
		try {
			ServicoInterface servico = this.getServico(nome);
			servico.iniciar(usuario, args);
			usuario.enviar(servico.executar());
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
