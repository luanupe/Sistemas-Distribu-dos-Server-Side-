package distribuidos.sistemas.servidor;

import java.io.IOException;
import java.util.List;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:13:55
 *
 */
public abstract class ServicoInterface {

	private Usuario usuario;
	private List<String> args;

	public final void iniciar(Usuario usuario, List<String> args) {
		this.usuario = usuario;
		this.args = args;
	}

	public abstract String executar() throws IOException;

	public final Usuario getUsuario() {
		return this.usuario;
	}

	public final List<String> getArgs() {
		return this.args;
	}

}
