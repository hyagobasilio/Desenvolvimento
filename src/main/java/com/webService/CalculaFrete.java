package com.webService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.util.LancaMenssagem;

@Service
public class CalculaFrete {
	
	@Resource LancaMenssagem menssagem;

	public CalculcaFreteVO getPreco(String nCdEmpresa,String sDsSenha,String nCdServico,String sCepOrigem,
			String sCepDestino,String nVlPeso,String nCdFormato,String nVlComprimento,String nVlAltura,
			String nVlLargura,String nVlDiametro,String sCdMaoPropria,String nVlValorDeclarado,
			String sCdAvisoRecebimento, String strRetorno) throws JAXBException,IOException {
		
		
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
		

		try {

			JAXBContext jc = JAXBContext.newInstance(CalculcaFreteVO.class);

			Unmarshaller u = jc.createUnmarshaller();
			URL url = new URL(urls);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Request-Method", "GET");
			CalculcaFreteVO vo = (CalculcaFreteVO) u.unmarshal(url); 
			return vo;

		} catch (Exception e) {
			e.printStackTrace();
			menssagem.lancarMensagem("Erro na conexão com o WebService !");
			return new CalculcaFreteVO();
		}

	}
}
