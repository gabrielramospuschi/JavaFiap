package br.com.fiap.daofactory;

import br.com.fiap.AplicacaoDAO;
import br.com.fiap.CartaoDAO;
import br.com.fiap.ContaBancariaDAO;
import br.com.fiap.CorretoraDAO;
import br.com.fiap.GanhoDAO;
import br.com.fiap.GastoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    public static AplicacaoDAO getAplicacaoDAO () {
        return new OracleAplicacaoDAO();    
            }
    
    public static CartaoDAO getCartaoDAO () {
        return new OracleCartaoDAO();
    }
    
    public static ContaBancariaDAO getContaBancariaDAO () {
        return new OracleContaBancariaDAO ();        
    }
    
    public static CorretoraDAO getCorretoraDAO () {
        return new OracleCorretoraDAO ();
    }
    
    public static GanhoDAO getGanhoDAO () {
        return new OracleGanhoDao ();
    }
    
    public static GastoDAO getGastoDAO () {
        return new OracleGastoDAO ();
}

}