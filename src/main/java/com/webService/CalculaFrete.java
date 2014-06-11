package com.webService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.util.LancaMenssagem;

@Service
public class CalculaFrete {

	@Resource
	LancaMenssagem menssagem;

	public CalculaFreteVO getPreco(String nCdEmpresa, String sDsSenha,
			String nCdServico, String sCepOrigem, String sCepDestino,
			String nVlPeso, String nCdFormato, String nVlComprimento,
			String nVlAltura, String nVlLargura, String nVlDiametro,
			String sCdMaoPropria, String nVlValorDeclarado,
			String sCdAvisoRecebimento, String strRetorno)
			throws JAXBException, IOException {

		String urls = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";

		Properties parameters = new Properties();

		parameters.setProperty("nCdEmpresa", nCdEmpresa);
		parameters.setProperty("sDsSenha", sDsSenha);
		parameters.setProperty("nCdServico", nCdServico);
		parameters.setProperty("sCepOrigem", sCepOrigem);
		parameters.setProperty("sCepDestino", sCepDestino);
		parameters.setProperty("nVlPeso", nVlPeso);
		parameters.setProperty("nCdFormato", nCdFormato);
		parameters.setProperty("nVlComprimento", nVlComprimento);
		parameters.setProperty("nVlAltura", nVlAltura);
		parameters.setProperty("nVlLargura", nVlLargura);
		parameters.setProperty("nVlDiametro", nVlDiametro);
		parameters.setProperty("sCdMaoPropria", sCdMaoPropria);
		parameters.setProperty("nVlValorDeclarado", nVlValorDeclarado);
		parameters.setProperty("sCdAvisoRecebimento", sCdAvisoRecebimento);
		parameters.setProperty("StrRetorno", strRetorno);

		Iterator i = parameters.keySet().iterator();
		int counter = 0;

		while (i.hasNext()) {

			String name = (String) i.next();
			String value = parameters.getProperty(name);
			urls += (++counter == 1 ? "?" : "&") + name + "=" + value;

		}
		/* URL = http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?sCdAvisoRecebimento=n&nCdServico=41106&nVlComprimento=20&sCdMaoPropria=s&nCdEmpresa=&sCepOrigem=71939360&nVlAltura=5&sCepDestino=72151613&nVlValorDeclarado=0&sDsSenha=&nVlLargura=15&nVlDiametro=0&nVlPeso=1&StrRetorno=xml&nCdFormato=1*/
		Client c = Client.create();
		WebResource wr = c.resource(urls);
		return populaVO(wr.get(CalculaFreteVO.class));

	}

	private CalculaFreteVO populaVO(CalculaFreteVO item) {
		CalculaFreteVO vo = new CalculaFreteVO();
		return vo;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		/*	Client c = Client.create();
		WebResource wr = c
				.resource("http://frete.w21studio.com/calFrete.xml?cep=74905660&cod=8697&peso=10&comprimento=60&largura=60&altura=5&servico=3");
		FreteVO vo = wr.get(FreteVO.class);
		System.out.println(vo.getValor_pac());  */
		CorreiosFreteVO vo = new CorreiosFreteVO();
		
		Client c = Client.create();
		WebResource wr = c.resource("http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?sCdAvisoRecebimento=n&nCdServico=41106&nVlComprimento=20&sCdMaoPropria=s&nCdEmpresa=&sCepOrigem=71939360&nVlAltura=5&sCepDestino=72151613&nVlValorDeclarado=0&sDsSenha=&nVlLargura=15&nVlDiametro=0&nVlPeso=1&StrRetorno=xml&nCdFormato=1");
		String xmlString = wr.get(String.class);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();     
		DocumentBuilder db = dbf.newDocumentBuilder();     
		ByteArrayInputStream is = new ByteArrayInputStream (xmlString.getBytes()); 
		Document strXML = db.parse(is); 
		
		Element raiz = strXML.getDocumentElement();
/*		System.out.println("O elemento raiz é:" + raiz.getNodeName()); */
		
		NodeList list = raiz.getElementsByTagName("Servicos");
		
		NodeList valor = raiz.getElementsByTagName("Valor");
		Node valorPac = valor.item(0).getFirstChild();
		vo.setValor(valorPac.getNodeValue()); 
		
		NodeList prazo = raiz.getElementsByTagName("PrazoEntrega");
		Node prazoEntrega = prazo.item(0).getFirstChild();
		vo.setPrazoEntrega(prazoEntrega.getNodeValue()); 
		
		System.out.println("Valor PAC: " + vo.getValor());
		System.out.println("Prazo de Entrega: " +  vo.getPrazoEntrega());
		
		
	}
		

}
