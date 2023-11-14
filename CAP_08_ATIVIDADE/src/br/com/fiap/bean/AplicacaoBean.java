package br.com.fiap.bean;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AplicacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigoAplicacao;
    private String descricaoAplicacao;
    private Date dataAplicacao;
    private double valorAplicacao;
    private String tipoAplicacao;
}