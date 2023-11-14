package br.com.fiap.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.GanhoBean;
import br.com.fiap.dao.sql.Queries;
import lombok.extern.java.Log;

@Log
public class GanhoDAO implements IDAO<GanhoBean> {
	
	  public void create(Connection conn, GanhoBean contaBancariaBean) throws SQLException {
	        PreparedStatement pst = null;
	        try{
	            pst = conn.prepareStatement(Queries.INSERT_GANHO);
	            
	            pst.setString(1, contaBancariaBean.getCodigo());
	            pst.setString(2, contaBancariaBean.getDescricao());
	            pst.setDate(3, contaBancariaBean.getData());
	            pst.setString(4, contaBancariaBean.getNomeInstituicao());
	            pst.execute();
	            
	            pst.close();
	            conn.close();
	            log.info("Ganho cadastrado com sucesso!");
	        } catch (SQLException e) {
	            log.info(e.getMessage());
	            throw e;
	        }
	    }
	    
	    public List<GanhoBean> findAll(Connection conn) throws SQLException {
	        List<GanhoBean> lst = new ArrayList<GanhoBean>();
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        try {
	            pst = conn.prepareStatement(Queries.INSERT_GANHO);
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
	    
	    private GanhoBean getBeanFromResultSet(ResultSet rs) throws SQLException {
	    	GanhoBean ganhosBean = new GanhoBean();
	 
	    	ganhosBean.setCodigo(rs.getString("CD_GANHO"));
	    	ganhosBean.setDescricao(rs.getString("DS_GANHO"));
	    	ganhosBean.setData(rs.getDate("DT_GANHO"));
	    	ganhosBean.setValorGanho(rs.getDouble("VL_GANHO"));
	    	ganhosBean.setNomeInstituicao(rs.getString("NM_INSTITUICAO"));
	    	
	    	return ganhosBean;
	    }
}

