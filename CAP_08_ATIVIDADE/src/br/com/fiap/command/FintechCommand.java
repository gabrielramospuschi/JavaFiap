package br.com.fiap.command;

import static br.com.fiap.jdbc.OracleConfig.getConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.IDAO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FintechCommand<Bean> {

	private IDAO<Bean> dao;
	
	@SuppressWarnings("unchecked")
	public void create(Serializable serializable) throws Exception {
		Connection conn = getConn();
		try {			
			dao.create(conn, (Bean) serializable);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			conn.close();
		}
	}
	
	public List<Bean> findAll() throws Exception {
		Connection conn = getConn();
		List<Bean> lst = dao.findAll(getConn());
		conn.close();
		return lst;
	}
	
	private static Connection getConn() throws Exception {
		Connection conn = getConnection();
		if (conn == null) {
			throw new SQLException("Erro: Não foi possível obter a conexão.");
        }
		return conn;
	}
}
