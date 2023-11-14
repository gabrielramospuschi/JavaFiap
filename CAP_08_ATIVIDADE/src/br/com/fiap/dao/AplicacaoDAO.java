package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.AplicacaoBean;
import br.com.fiap.dao.sql.Queries;
import lombok.extern.java.Log;

@Log
public class AplicacaoDAO implements IDAO<AplicacaoBean> {

    public void create(Connection conn, AplicacaoBean aplicacaoBean) throws SQLException {
        PreparedStatement pst = null;
        try{
            pst = conn.prepareStatement(Queries.INSERT_APLICACAO);
            
            pst.setString(1, aplicacaoBean.getDescricaoAplicacao());
            pst.setDate(2, aplicacaoBean.getDataAplicacao());
            pst.setDouble(3, aplicacaoBean.getValorAplicacao());
            pst.setString(4, aplicacaoBean.getDescricaoAplicacao());
            pst.execute();
            
            pst.close();
            conn.close();
            log.info("Aplicação cadastrado com sucesso!");
        } catch (SQLException e) {
            log.info(e.getMessage());
            throw e;
        }
    }
    
    public List<AplicacaoBean> findAll(Connection conn) throws SQLException {
        List<AplicacaoBean> lst = new ArrayList<AplicacaoBean>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(Queries.SELECT_APLICACAO);
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
    
    private AplicacaoBean getBeanFromResultSet(ResultSet rs) throws SQLException {
    	AplicacaoBean aplicacaoBean = new AplicacaoBean();
    	
    	aplicacaoBean.setCodigoAplicacao(rs.getString("CD_APLIC"));
    	aplicacaoBean.setDataAplicacao(rs.getDate("DT_GASTO"));
    	aplicacaoBean.setDescricaoAplicacao(rs.getString("DS_APLIC"));
    	aplicacaoBean.setTipoAplicacao(rs.getString("DS_TIPO_APLIC"));
    	aplicacaoBean.setValorAplicacao(rs.getDouble("VL_APLIC"));
    	
    	return aplicacaoBean;
    }

}
