package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teste")
public class Teste {
	
	private Long id;
	

	@Id
    @GeneratedValue
    @Column(name = "id_pessoa")
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
}