package distribuidos.sistemas.servidor.servicos;

import java.io.IOException;
import distribuidos.sistemas.servidor.ServicoInterface;

/**
 *
 * Author: Luan Augusto, LAF
 * Date: 7 de mai de 2017
 * Time: 22:13:32
 *
 */
public class Somar extends ServicoInterface {

	@Override
	public String executar() throws IOException {
		double resultado = 0;
		for (String valor : super.getArgs()) {
			try {
				resultado += Double.parseDouble(valor);
			} catch (NumberFormatException e) {
				// Argumento não é um número...
			}
		}
		return Double.toString(resultado);
	}

}
