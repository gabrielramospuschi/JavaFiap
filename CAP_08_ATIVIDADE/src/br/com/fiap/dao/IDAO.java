package br.com.fiap.dao;

import java.sql.Connection;
import java.util.List;

public interface IDAO<Bean> {
	
    void create(Connection conn, Bean bean) throws Exception;
    List<Bean> findAll(Connection conn) throws Exception;
}