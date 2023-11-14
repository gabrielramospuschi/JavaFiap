package br.com.fiap.bean;

import java.io.Serializable;

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
public class ContaBancariaBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String codigo;
    private String numeroConta;
    private String nomeTitular;
    private double valorSaldo;
    private String numeroAgencia;
}