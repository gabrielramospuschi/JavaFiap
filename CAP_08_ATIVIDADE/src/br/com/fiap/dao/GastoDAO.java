package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.GastoBean;
import br.com.fiap.dao.sql.Queries;
import lombok.extern.java.Log;

@Log
public class GastoDAO implements IDAO<GastoBean> {
	
	  public void create(Connection conn, GastoBean gastoBean) throws SQLException {
	        PreparedStatement pst = null;
	        try{
	            pst = conn.prepareStatement(Queries.INSERT_GASTO);
	            
	            pst.setString(1, gastoBean.getDescricao());
	            pst.setDate(2, gastoBean.getData());
	            pst.setDouble(3, gastoBean.getValorGasto());
	            pst.setString(4, gastoBean.getNomeInstituicao());
	            pst.execute();
	            
	            pst.close();
	            conn.close();
	            log.info("Gasto(s) cadastrada(s) com sucesso!");
	        } catch (SQLException e) {
	            log.info(e.getMessage());
	            throw e;
	        }
	    }
	    
	    public List<GastoBean> findAll(Connection conn) throws SQLException {
	        List<GastoBean> lst = new ArrayList<GastoBean>();
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        try {
	            pst = conn.prepareStatement(Queries.SELECT_GASTO);
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
	    
	    private GastoBean getBeanFromResultSet(ResultSet rs) throws SQLException {
	    	GastoBean gastoBean = new GastoBean();
	 
	    	gastoBean.setCodigo(rs.getString("CD_GASTO"));
	    	gastoBean.setData(rs.getDate("DT_GASTO"));
	    	gastoBean.setDescricao(rs.getString("DS_GASTO"));
	    	gastoBean.setNomeInstituicao(rs.getString("NM_INSTITUICAO"));
	    	gastoBean.setValorGasto(rs.getDouble("VL_GASTO"));
	    	return gastoBean;
	    }
}