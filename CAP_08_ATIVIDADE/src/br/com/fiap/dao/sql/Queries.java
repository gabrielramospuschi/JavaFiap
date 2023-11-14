package br.com.fiap.dao.sql;

public abstract class Queries {

	public static final String INSERT_APLICACAO
	= "INSERT INTO T_APLICACAO "
	+ "(CD_APLIC, DS_APLIC, DT_APLIC, VL_APLIC, DS_TIPO_APLIC) "
	+ "VALUES "
	+ "(SQ_FINTECH.NEXTVAL, ?, ?, ?, ?)";
		
	public static final String SELECT_APLICACAO
	= "SELECT "
	+ "CD_APLIC, DS_APLIC, DT_APLIC, VL_APLIC, DS_TIPO_APLIC "
	+ "FROM T_APLICACAO";
	
	public static final String INSERT_CARTAO
	= "INSERT INTO T_CARTAO "
	+ "(CD_CARTAO, NR_CARTAO, NM_TITULAR, DT_VALIDADE, NR_CVV) "
	+ "VALUES "
	+ "(SQ_FINTECH.NEXTVAL, ?, ?, ?, ?)";
		
	public static final String SELECT_CARTAO
	= "SELECT "
	+ "CD_CARTAO, NR_CARTAO, NM_TITULAR, DT_VALIDADE, NR_CVV "
	+ "FROM T_CARTAO";
	
	public static final String INSERT_CONTA_BANCARIA
	= "INSERT INTO T_CONTA_BANCARIA "
	+ "(CD_CONTA, NR_CONTA, NM_TITULAR, VL_SALDO, NR_AGENCIA) "
	+ "VALUES "
	+ "(SQ_FINTECH.NEXTVAL, ?, ?, ?, ?)";
		
	public static final String SELECT_CONTA_BANCARIA
	= "SELECT "
	+ "CD_CONTA, NR_CONTA, NM_TITULAR, VL_SALDO, NR_AGENCIA "
	+ "FROM T_CONTA_BANCARIA";

	public static final String INSERT_CORRETORA
	= "INSERT INTO T_CORRETORA "
	+ "(CD_CORRETORA, NR_CORRET, NM_CORRETORA) "
	+ "VALUES "
	+ "(SQ_FINTECH.NEXTVAL, ?, ?)";
		
	public static final String SELECT_CORRETORA
	= "SELECT "
	+ "CD_CORRETORA, NR_CORRET, NM_CORRETORA "
	+ "FROM T_CORRETORA";
	
	public static final String INSERT_GANHO
	= "INSERT INTO T_CORRETORA "
	+ "(CD_GANHO, DS_GANHO, DT_GANHO, VL_GANHO, NM_INSTITUICAO) "
	+ "VALUES "
	+ "(SQ_FINTECH.NEXTVAL, ?, ?)";
		
	public static final String SELECT_GANHO
	= "SELECT "
	+ "CD_GANHO, NR_CORRET, NM_CORRETORA "
	+ "FROM T_CORRETORA";
	
	public static final String INSERT_GASTO
	= "INSERT INTO T_CORRETORA "
	+ "(CD_GASTO, DS_GASTO, DT_GASTO, VL_GASTO, NM_INSTITUICAO) "
	+ "VALUES "
	+ "(SQ_FINTECH.NEXTVAL, ?, ?, ?, ?)";
		
	public static final String SELECT_GASTO
	= "SELECT "
	+ "CD_GASTO, DS_GASTO, DT_GASTO, VL_GASTO, NM_INSTITUICAO "
	+ "FROM T_CORRETORA";
}



