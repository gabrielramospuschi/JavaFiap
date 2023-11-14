package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.bean.AplicacaoBean;
import br.com.fiap.bean.CartaoBean;
import br.com.fiap.bean.ContaBancariaBean;
import br.com.fiap.bean.CorretoraBean;
import br.com.fiap.bean.GanhoBean;
import br.com.fiap.bean.GastoBean;
import br.com.fiap.command.FintechCommand;
import br.com.fiap.dao.AplicacaoDAO;
import br.com.fiap.dao.CartaoDAO;
import br.com.fiap.dao.ContaBancariaDAO;
import br.com.fiap.dao.CorretoraDAO;
import br.com.fiap.dao.GanhoDAO;
import br.com.fiap.dao.GastoDAO;

public class TesteListagem {
	
    public static void main(String[] args) throws Exception {
    	List<FintechCommand<?>> commands = List.of(
        	new FintechCommand<AplicacaoBean>(new AplicacaoDAO()),
        	new FintechCommand<CartaoBean>(new CartaoDAO()),
        	new FintechCommand<ContaBancariaBean>(new ContaBancariaDAO()),
        	new FintechCommand<CorretoraBean>(new CorretoraDAO()),
        	new FintechCommand<GanhoBean>(new GanhoDAO()),
        	new FintechCommand<GastoBean>(new GastoDAO())
        );
        	
        for (int i = 0; i < commands.size(); i++) {
    		var lst = commands.get(i).findAll();
    		
    		for (Object object : lst) {
				System.out.println(object);
			}
    	}
    }
}