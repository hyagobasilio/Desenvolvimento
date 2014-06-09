package com.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.webService.CalculaFrete;
import com.webService.CalculcaFreteVO;

@ManagedBean
@Controller
@Component
@Scope("view") 
public class CalcularFreteController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CalculcaFreteVO calculcaFreteVO;
	@Autowired private CalculaFrete calculaFrete;
	
	public void calculaFrete() throws JAXBException, IOException{
		calculcaFreteVO = calculaFrete.getPreco("", "", "41106", "71939360", "72151613", "1",
				"1", "20", "5", "15", "0", "s", "0", "n", "xml");
	}

	public CalculcaFreteVO getCalculcaFreteVO() {
		return calculcaFreteVO;
	}


}
