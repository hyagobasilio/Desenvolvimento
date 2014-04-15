package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class GeradorClasse {

	private static BufferedReader br;
	
	private static String DAO = "PessoaDAO.java";
	private static String NOVO_DAO = "TesteDAO.java";
	
	private static String CONTROLLER= "PessoaController.java";
	private static String NOVO_CONTROLLER = "TesteController.java";
	
	private static String ENTIDADE = "Pessoa";
	private static String NOVO_ENTIDADE = "Teste";

	private static String PRE_SUFIXO = "pessoa";
	private static String SUFIXO_ENTIDADE = "teste";
	
	private static String INTERFACES = "IPessoaDAO.java";
	private static String NOVO_INTERFACES = "ITesteDAO.java";
	
	private static String INTERFACES_SERVICE = "IPessoaService.java";
	private static String NOVO_INTERFACE_SERVICE = "ITesteService.java";
	
	private static String SERVICE = "PessoaService.java";
	private static String NOVO_SERVICE = "TesteService.java";
	
	private static String INDEX = "cadastroPessoa.xhtml";
	private static String NOVO_INDEX = "teste.xhtml";
	
	/*private static String CAMINHO = "//Users//JadersonMorais//Documents//workspace//JSF//Desenvolvimento//src//main//java//com";*/
	private static String CAMINHO = "D:\\Estudos\\Desenvolvimento\\src\\main\\java\\com";
	private static String CAMINHO_INDEX = "D:\\Estudos\\Desenvolvimento\\src\\main\\webapp";
	
	private static String SUFIXO_CONTROLLER = "\\controller\\";
	private static String SUFIXO_INTERFACES = "\\interfaces\\";
	private static String SUFIXO_SERVICE = "\\service\\";
	private static String SUFIXO_DAO = "\\dao\\";
	private static String SUFIXO_INDEX = "\\pages\\";
	
	public static void controllerAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
		if(arquivo.exists()){
			System.out.println("Diretório já existe: " + CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_CONTROLLER + CONTROLLER);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			
			br.close();
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			System.out.println("Diretório Criado: " + CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
			
			bw.close();
		}
		
		
	}
	
	public static void interfaceServiceAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		if(arquivo.exists()){
			System.out.println("Diretório já existe: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_INTERFACES + INTERFACES_SERVICE);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.interfaces");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			System.out.println("Diretório Criado: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
			
			bw.close();
		}
		
		
	}
	
	public static void serviceAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
		if(arquivo.exists()){
			System.out.println("Diretório já existe: " + CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_SERVICE + SERVICE);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.service");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			System.out.println("Diretório Criado: " + CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
			
			bw.close();
		}
		
		
	}
	
	public static void interfaceAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		if(arquivo.exists()){
			System.out.println("Diretório já existe: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_INTERFACES + INTERFACES);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.interfaces");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			System.out.println("Diretório Criado: " + CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
			
			bw.close();
		}
		
		
	}
	
	public static void daoAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(CAMINHO + SUFIXO_DAO + NOVO_DAO);
		if(arquivo.exists()){
			System.out.println("Diretório já existe: " + CAMINHO_INDEX + SUFIXO_DAO + NOVO_DAO);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO + SUFIXO_DAO + DAO);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(DAO, NOVO_DAO);
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("com.controller", "com.dao");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			System.out.println("Diretório Criado: " + CAMINHO_INDEX + SUFIXO_DAO + NOVO_DAO);
			
			bw.close();
		}
		
		
	}
	
	public static void indexAserCopiado(String caminhoNovo) throws IOException{
		
		File arquivo = new File(caminhoNovo);
		if(arquivo.exists()){
			System.out.println("Diretório já existe: " + CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX);
		}else{
			
			InputStream is = new FileInputStream(CAMINHO_INDEX + SUFIXO_INDEX + INDEX);
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String s = br.readLine();
			StringBuffer sb =  new StringBuffer();
			
			
			while (s != null){
				
				s = s.replace(ENTIDADE, NOVO_ENTIDADE);
				s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
				s = s.replace("pessoaController", "testeController");
				s = s.replace("pessoas", "testes");
				
				sb.append(s + "\n");
				s = br.readLine();
			}
			
			br.close();
			
			
			OutputStream os = new FileOutputStream(caminhoNovo);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			bw.write(sb.toString());
			
			System.out.println("Diretório Criado: " + CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX);
			bw.close();
			
		}
		
	}
	
	public static void apagarPasta(String caminho) {
		  
		  File arquivo = new File(caminho);
		  if(arquivo.exists()){
			if(arquivo.delete()){
				System.out.println("Diretório apagado: " + caminho);
				}
			}else{
				System.out.println("Diretório não existe: " + caminho);
		  }
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		/* 	GERADOR DE CRUD	     
		controllerAserCopiado(CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);
		interfaceServiceAserCopiado(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		serviceAserCopiado(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
		interfaceAserCopiado(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		daoAserCopiado(CAMINHO + SUFIXO_DAO + NOVO_DAO);
		indexAserCopiado(CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX);      */	
		
		 
		/*  APAGAR OS ARQUIVOS COPIADOS         */
		apagarPasta(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		apagarPasta(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		apagarPasta(CAMINHO + SUFIXO_DAO + NOVO_DAO);
		apagarPasta(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE); 
		apagarPasta(CAMINHO + SUFIXO_CONTROLLER + NOVO_CONTROLLER);   
		apagarPasta(CAMINHO_INDEX + SUFIXO_INDEX + NOVO_INDEX );          
		
			
				
	}
} 
	
