package com.service;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TesteDAO;
import com.entity.Teste;
import com.interfaces.ITesteService;
import com.sun.faces.util.MessageFactory;

@Service
@Transactional
public class TesteService  implements ITesteService {

	@Autowired TesteDAO testeDAO;
	@PersistenceContext EntityManager entityManager;

	
	@Override
	public void salvar(Teste teste) throws IllegalArgumentException {
		if(teste.getId() == null){
			testeDAO.salvar(teste);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastro Realizado", ""));
		}else if(teste.getId() != null){
			testeDAO.atualizar(teste);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atualização Realizada", ""));
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema","")); 
		}
		
	}

	@Override
	public List<Teste> listaTestes(Teste teste) {
		return testeDAO.listaTestes(teste);
		
	}
	
	@Override
	public void deletar(Teste teste)  throws IllegalArgumentException {
		entityManager.clear();
		if(teste.getId() != null){
			this.testeDAO.excluir(testeDAO.find(teste.getId()));
			}else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Sample info message", MessageFactory.getMessage("Nao_foi_possivel_executar_esta_operacao._Se_o_erro_persistir_entre_em_contato_com_o_administrador_do_sistema","")); 
		}	
	}
		
}
