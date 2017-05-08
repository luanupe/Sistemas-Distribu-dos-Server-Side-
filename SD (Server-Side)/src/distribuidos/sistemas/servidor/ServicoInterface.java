package distribuidos.sistemas.servidor;

import java.io.IOException;
import java.util.ArrayList;
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

	public ServicoInterface(Usuario usuario) {
		this.usuario = usuario;
		this.args = new ArrayList<String>();
	}

	public final void add(String arg) {
		this.args.add(arg);
	}

	public abstract String executar() throws IOException;

	public final Usuario getUsuario() {
		return this.usuario;
	}

	public final List<String> getArgs() {
		return this.args;
	}

}
