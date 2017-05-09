package distribuidos.sistemas.servidor.servicos;

import java.io.IOException;

import distribuidos.sistemas.servidor.ServicoInterface;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 9 de mai de 2017
 * Time: 14:37:27
 *
 */
public class Multiplicar extends ServicoInterface {

	@Override
	public String executar() throws IOException {
		Double resultado = null;
		for (String arg : super.getArgs()) {
			if ((resultado == null)) {
				resultado = Double.parseDouble(arg);
			} else {
				resultado *= Double.parseDouble(arg);
			}
		}
		return Double.toString(resultado);
	}

}
