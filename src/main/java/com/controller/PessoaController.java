package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.entity.Pessoa;
import com.service.PessoaService;
import com.util.LancaMenssagem;
import com.util.VerificadorUtil;

@Controller
@Component
@Scope("view") 
public class PessoaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	@Autowired
	private PessoaService pessoaService;
	@Resource LancaMenssagem lancaMenssagem;
	private List<Pessoa> listaPessoa;
	private Pessoa pessoaSelecionada;


	@PostConstruct
	private void init() {
		pessoa = new Pessoa();
		this.listaPessoa = pessoaService.listaPessoas(pessoa);
		this.pessoaSelecionada = null;
	}
	
	public void novo(){
		init();
		RequestContext.getCurrentInstance().reset(":form:panel");  
	}
	

	public void salvar() {
		if (VerificadorUtil.estaNulo(pessoa)){
			lancaMenssagem.lancarMensagemCampoNulos("");
		}else{
			pessoaService.salvar(pessoa);
			novo();
		}
	}
	
	public void deletar() {
		pessoaService.deletar(pessoaSelecionada);
		init();
	}
	
	public void onRowSelect(SelectEvent event) {
		Pessoa object = ((Pessoa) event.getObject());
		if(object != null){
			this.pessoa = object; 
		}
	}
 
	public void onRowUnselect(UnselectEvent event) {
		novo();
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
	
}
