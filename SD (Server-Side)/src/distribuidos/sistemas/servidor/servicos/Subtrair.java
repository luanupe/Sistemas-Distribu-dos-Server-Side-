package distribuidos.sistemas.servidor.servicos;

import java.io.IOException;

import distribuidos.sistemas.servidor.ServicoInterface;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 9 de mai de 2017
 * Time: 13:26:47
 *
 */
public class Subtrair extends ServicoInterface {

	@Override
	public String executar() throws IOException {
		Double resultado = null;
		for (String arg : super.getArgs()) {
			try {
				if ((resultado == null)) {
					resultado = Double.parseDouble(arg);
				} else {
					resultado -= Double.parseDouble(arg);
				}
				resultado = Double.parseDouble(arg);
			} catch (NumberFormatException e) {
				return "Por favor, utilize apenas números.";
			}
		}
		return Double.toString(resultado);
	}

}
