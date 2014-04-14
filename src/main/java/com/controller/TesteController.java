package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entity.Teste;
import com.service.TesteService;
@Controller
@Component
@Scope("view") 
public class TesteController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Teste teste;
	@Autowired
	private TesteService testeService;
	private List<Teste> listaTeste;
	private Teste testeSelecionada;


	@PostConstruct
	private void init() {
		teste = new Teste();
		this.listaTeste = testeService.listaTestes(teste);
		this.testeSelecionada = null;
	}
	
	public String novo(){
		RequestContext.getCurrentInstance().reset(":form:panel");  
		init();
		return "";
	}
	

	public void salvar() {
		testeService.salvar(teste);
		novo();
	}
	
	public void deletar() {
		testeService.deletar(testeSelecionada);
		novo();
	}
	
	public void onRowSelect(SelectEvent event) {
		Teste object = ((Teste) event.getObject());
		if(object != null){
			this.teste = object; 
		}
	}
 
	public void onRowUnselect(UnselectEvent event) {
		this.testeSelecionada = null;
	}

	public Teste getTesteSelecionada() {
		return testeSelecionada;
	}

	public void setTesteSelecionada(Teste testeSelecionada) {
		this.testeSelecionada = testeSelecionada;
	}

	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	public List<Teste> getListaTeste() {
		return listaTeste;
	}

	public void setListaTeste(List<Teste> listaTeste) {
		this.listaTeste = listaTeste;
	}
	
}
