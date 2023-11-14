package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.ContaBancariaBean;
import br.com.fiap.dao.sql.Queries;
import lombok.extern.java.Log;

@Log
public class ContaBancariaDAO implements IDAO<ContaBancariaBean> {
	
	  public void create(Connection conn, ContaBancariaBean contaBancariaBean) throws SQLException {
	        PreparedStatement pst = null;
	        try{
	            pst = conn.prepareStatement(Queries.INSERT_CONTA_BANCARIA);
	            
	            pst.setString(1, contaBancariaBean.getCodigo());
	            pst.setString(2, contaBancariaBean.getNumeroConta());
	            pst.setString(3, contaBancariaBean.getNomeTitular());
	            pst.setDouble(4, contaBancariaBean.getValorSaldo());
	            pst.execute();
	            
	            pst.close();
	            conn.close();
	            log.info("Conta(s) cadastrada(s) com sucesso!");
	        } catch (SQLException e) {
	            log.info(e.getMessage());
	            throw e;
	        }
	    }
	    
	    public List<ContaBancariaBean> findAll(Connection conn) throws SQLException {
	        List<ContaBancariaBean> lst = new ArrayList<ContaBancariaBean>();
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        try {
	            pst = conn.prepareStatement(Queries.INSERT_CONTA_BANCARIA);
	            rs = pst.executeQuery();

	            while (rs.next()) {
	            	lst.add(getBeanFromResultSet(rs));
	            }
	            
	            pst.close();
	            rs.close();
	            conn.close();
	        } catch (SQLException e) {
	            log.info(e.getMessage());
	            throw e;
	        }
	        return lst;
	    }
	    
	    private ContaBancariaBean getBeanFromResultSet(ResultSet rs) throws SQLException {
	    	ContaBancariaBean ContaBancariaBean = new ContaBancariaBean();
	 
	    	ContaBancariaBean.setCodigo(rs.getString("CD_CONTA"));
	    	ContaBancariaBean.setNumeroConta(rs.getString("NR_CONTA"));
	    	ContaBancariaBean.setNomeTitular(rs.getString("NM_TITULAR"));
	    	ContaBancariaBean.setValorSaldo(rs.getDouble("VL_SALDO"));
	    	ContaBancariaBean.setNumeroAgencia(rs.getString("NR_AGENCIA"));
	    	
	    	return ContaBancariaBean;
	    }
}