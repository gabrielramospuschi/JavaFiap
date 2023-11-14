
package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.CorretoraBean;
import br.com.fiap.dao.sql.Queries;
import lombok.extern.java.Log;

@Log
public class CorretoraDAO implements IDAO<CorretoraBean> {
	
	  public void create(Connection conn, CorretoraBean corretoraBean) throws SQLException {
	        PreparedStatement pst = null;
	        try{
	            pst = conn.prepareStatement(Queries.INSERT_CORRETORA);
	            
	            pst.setString(1, corretoraBean.getCodigoCorretora());
	            pst.setString(2, corretoraBean.getNomeCorretora());
	            pst.execute();
	            
	            pst.close();
	            conn.close();
	            log.info("Conta(s) cadastrada(s) com sucesso!");
	        } catch (SQLException e) {
	            log.info(e.getMessage());
	            throw e;
	        }
	    }
	    
	    public List<CorretoraBean> findAll(Connection conn) throws SQLException {
	        List<CorretoraBean> lst = new ArrayList<CorretoraBean>();
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        try {
	            pst = conn.prepareStatement(Queries.INSERT_CORRETORA);
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
	    
	    private CorretoraBean getBeanFromResultSet(ResultSet rs) throws SQLException {
	    	CorretoraBean corretoraBean = new CorretoraBean();
	 
	    	corretoraBean.setCodigoCorretora(rs.getString("NR_CORRETORA"));
	    	corretoraBean.setNomeCorretora(rs.getString("NM_CORRETORA"));
	    	return corretoraBean;
	    }
}
