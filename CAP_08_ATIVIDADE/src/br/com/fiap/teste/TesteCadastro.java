package br.com.fiap.teste;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

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

public class TesteCadastro {
	
	private static String getId() {
		return UUID.randomUUID().toString();
	}
	
	private static Date getCurrentDate() {
		return new Date(System.currentTimeMillis());
	}	
	
    public static void main(String[] args) throws Exception {

    	List<FintechCommand<?>> commands = List.of(
    		new FintechCommand<AplicacaoBean>(new AplicacaoDAO()),
    		new FintechCommand<CartaoBean>(new CartaoDAO()),
    		new FintechCommand<ContaBancariaBean>(new ContaBancariaDAO()),
    		new FintechCommand<CorretoraBean>(new CorretoraDAO()),
    		new FintechCommand<GanhoBean>(new GanhoDAO()),
    		new FintechCommand<GastoBean>(new GastoDAO())
    	);

    	List<Serializable> beans = List.of(
    		new AplicacaoBean(getId(), "Test", getCurrentDate(), 1.5, "Teste"),
    		new CartaoBean(getId(), "123", "Gabriel", getCurrentDate(), "666"),
    		new ContaBancariaBean(getId(), "123", "Gustavo", 1000000.0, "001"),
    		new CorretoraBean(getId(), "Guzi Bros"),
    		new GanhoBean(getId(), "Texto", getCurrentDate(), 20.9, "Guzi Joga"),
    		new GastoBean(getId(), "Texto", getCurrentDate(), 40.8, "Muito")
    	);
    	
    	for (int i = 0; i < commands.size(); i++) {
			commands.get(i).create(beans.get(i));
		}
    }
}