package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String email;
    private String relatorio;
    

	@Id
    @GeneratedValue
    @Column(name = "id_pessoa")
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    @Column(name = "nome_pessoa")
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    @Column(name = "idade_pessoa")
    public Integer getIdade() {
        return idade;
    }
 
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
 
    @Column(name = "email_pessoa", unique = true)
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Column(name="sobrenome_pessoa")
    public String getSobrenome() {
    	return sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
    	this.sobrenome = sobrenome;
    }
    
    @Transient
	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}
    
}