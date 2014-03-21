package com.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PessoaDAO;
import com.entity.Pessoa;
import com.interfaces.IPessoaService;
import com.sun.faces.util.MessageFactory;

@Service
@Transactional
public class PessoaService  implements IPessoaService {

	@Autowired PessoaDAO pessoaDAO;
	@PersistenceContext EntityManager entityManager;

	
	@Override
	public void salvar(Pessoa pessoa) throws IllegalArgumentException {
		if(pessoa.getId() == null){
			pessoaDAO.salvar(pessoa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro Realizado", ""));
		}else if(pessoa.getId() != null){
			pessoaDAO.atualizar(pessoa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização Realizada", ""));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema","")); 
		}
		
	}

	@Override
	public List<Pessoa> listaPessoas(Pessoa pessoa) {
		return pessoaDAO.listaPessoas(pessoa);
		
	}
	
	@Override
	public void deletar(Pessoa pessoa)  throws IllegalArgumentException {
		entityManager.clear();
		if(pessoa.getId() != null){
			this.pessoaDAO.excluir(pessoaDAO.find(pessoa.getId()));
			}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema","")); 
		}	
	}
		
}
