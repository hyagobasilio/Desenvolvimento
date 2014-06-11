package com.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;

import com.webService.CalculaFrete;
import com.webService.CorreiosFreteVO;

@ManagedBean
@Controller
@Component
@Scope("view") 
public class CalcularFreteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String sCepDestino;
	private CorreiosFreteVO correiosFreteVO;
	@Autowired private CalculaFrete calculaFrete;
	
	public void getPreco() throws JAXBException, IOException, ParserConfigurationException, SAXException{
		correiosFreteVO = calculaFrete.getPreco("", "", "40010", "71939360", getsCepDestino(), "1","1", "20", "5", "15", "0", "s", "0", "n", "xml");
	}
	
	public CorreiosFreteVO getCorreiosFreteVO() {
		return correiosFreteVO;
	}

	public String getsCepDestino() {
		return sCepDestino;
	}
	
	public void setsCepDestino(String sCepDestino) {
		this.sCepDestino = sCepDestino;
	}
}
