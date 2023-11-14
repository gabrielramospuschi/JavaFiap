package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.CartaoBean;
import br.com.fiap.dao.sql.Queries;
import lombok.extern.java.Log;

@Log
public class CartaoDAO implements IDAO<CartaoBean> {

    public void create(Connection conn, CartaoBean cartaoBean) throws SQLException {
        PreparedStatement pst = null;
        try{
            pst = conn.prepareStatement(Queries.INSERT_CARTAO);
            
            pst.setString(1, cartaoBean.getNumeroCartao());
            pst.setString(2, cartaoBean.getNomeTitular());
            pst.setDate(3, cartaoBean.getDataValidade());
            pst.setString(4, cartaoBean.getCvv());
            pst.execute();
            
            pst.close();
            conn.close();
            log.info("Cartão cadastrado com sucesso!");
        } catch (SQLException e) {
            log.info(e.getMessage());
            throw e;
        }
    }
    
    public List<CartaoBean> findAll(Connection conn) throws SQLException {
        List<CartaoBean> lst = new ArrayList<CartaoBean>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(Queries.INSERT_CARTAO);
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
    
    private CartaoBean getBeanFromResultSet(ResultSet rs) throws SQLException {
    	CartaoBean cartaoBean = new CartaoBean();
 
    	cartaoBean.setCodigoCartao(rs.getString("CD_CARTÃO"));
    	cartaoBean.setNumeroCartao(rs.getString("NR_CARTÃO"));
    	cartaoBean.setDataValidade(rs.getDate("DT_VALIDADE"));
    	cartaoBean.setNomeTitular(rs.getString("NM_CARTÃO"));
    	cartaoBean.setCvv(rs.getString("NR_CVV"));
    	
    	return cartaoBean;
    }
    
}