package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class GeradorClasse {

	private static BufferedReader br;
	private static StringBuffer sb =  new StringBuffer();
	
	private static String CLASSE = "PessoaDAO.java";
	private static String NOVO_NOME_CLASSE = "TesteDAO.java";
	
	private static String CLASSE_CONTROLLER= "PessoaController.java";
	private static String NOVO_NOME_CONTROLLER = "TesteController.java";
	
	private static String ENTIDADE = "Pessoa";
	private static String NOVO_NOME_ENTIDADE = "Teste";

	private static String PRE_SUFIXO = "pessoa";
	private static String SUFIXO_ENTIDADE = "teste";
	
	private static String INTERFACES = "IPessoaDAO.java";
	private static String NOVO_INTERFACES = "ITesteDAO.java";
	
	private static String INTERFACES_SERVICE = "IPessoaService.java";
	private static String NOVO_INTERFACE_SERVICE = "ITesteService.java";
	
	private static String SERVICE = "PessoaService.java";
	private static String NOVO_SERVICE = "TesteService.java";
	
	private static String CAMINHO = "//Users//JadersonMorais//Documents//workspace//JSF//Desenvolvimento//src//main//java//com";
	
	private static String SUFIXO_CONTROLLER = "//controller//";
	private static String SUFIXO_INTERFACES = "//interfaces//";
	private static String SUFIXO_SERVICE = "//service//";
	private static String SUFIXO_DAO = "//dao//";
	
	public static void controllerAserCopiado() throws IOException{
		
		InputStream is = new FileInputStream(CAMINHO + SUFIXO_CONTROLLER + CLASSE_CONTROLLER);
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String s = br.readLine();
		
		while (s != null){
			
			s = s.replace(CLASSE, NOVO_NOME_CLASSE);
			s = s.replace(ENTIDADE, NOVO_NOME_ENTIDADE);
			s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
			
			sb.append(s + "\n");
			s = br.readLine();
		}

		
		br.close();
		
	
	}
	
	public static void saidaController() throws IOException{
		
		OutputStream os = new FileOutputStream(CAMINHO + SUFIXO_CONTROLLER + NOVO_NOME_CONTROLLER);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write(sb.toString());
		
		bw.close();
		
	}
	
	public static void interfaceServiceAserCopiado() throws IOException{
		
		InputStream is = new FileInputStream(CAMINHO + SUFIXO_INTERFACES + INTERFACES_SERVICE);
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String s = br.readLine();
		
		
		while (s != null){
			
			s = s.replace(CLASSE, NOVO_NOME_CLASSE);
			s = s.replace(ENTIDADE, NOVO_NOME_ENTIDADE);
			s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
			s = s.replace("com.controller", "com.interfaces");
			
			sb.append(s + "\n");
			s = br.readLine();
		}
		
		br.close();
	}
	
	public static void saidaInterfaceService() throws IOException{
		
		OutputStream os = new FileOutputStream(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACE_SERVICE);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write(sb.toString());
		
		bw.close();
		
	}
	
	public static void serviceAserCopiado() throws IOException{
		
		InputStream is = new FileInputStream(CAMINHO + SUFIXO_SERVICE + SERVICE);
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String s = br.readLine();
		
		
		while (s != null){
			
			s = s.replace(CLASSE, NOVO_NOME_CLASSE);
			s = s.replace(ENTIDADE, NOVO_NOME_ENTIDADE);
			s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
			s = s.replace("com.controller", "com.service");
			
			sb.append(s + "\n");
			s = br.readLine();
		}
		
		br.close();
	
	}
	
	public static void saidaService() throws IOException{
		
		OutputStream os = new FileOutputStream(CAMINHO + SUFIXO_SERVICE + NOVO_SERVICE);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write(sb.toString());
		
		bw.close();
		
	}
	
	public static void interfaceAserCopiado() throws IOException{
		
		InputStream is = new FileInputStream(CAMINHO + SUFIXO_INTERFACES + INTERFACES);
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String s = br.readLine();
		
		
		while (s != null){
			
			s = s.replace(CLASSE, NOVO_NOME_CLASSE);
			s = s.replace(ENTIDADE, NOVO_NOME_ENTIDADE);
			s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
			s = s.replace("com.controller", "com.interfaces");
			
			sb.append(s + "\n");
			s = br.readLine();
		}
		
		br.close();
	}
	
	public static void saidaInterface() throws IOException{
		
		OutputStream os = new FileOutputStream(CAMINHO + SUFIXO_INTERFACES + NOVO_INTERFACES);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write(sb.toString());
		
		bw.close();
		
	}
	
	public static void daoAserCopiado() throws IOException{
		
		InputStream is = new FileInputStream(CAMINHO + SUFIXO_DAO + CLASSE);
		InputStreamReader isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		String s = br.readLine();
		
		
		while (s != null){
			
			s = s.replace(CLASSE, NOVO_NOME_CLASSE);
			s = s.replace(ENTIDADE, NOVO_NOME_ENTIDADE);
			s = s.replace(PRE_SUFIXO, SUFIXO_ENTIDADE);
			s = s.replace("com.controller", "com.dao");
			
			sb.append(s + "\n");
			s = br.readLine();
		}
		
		br.close();
		
	}
	
	public static void saidaDAO() throws IOException{
		
		OutputStream os = new FileOutputStream(CAMINHO + SUFIXO_DAO + NOVO_NOME_CLASSE );
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write(sb.toString());
		
		bw.close();
		
	}
	
	public static void main(String[] args) throws IOException {
			
		int i = 4;
			
			switch (i) {
			case 0:
				interfaceServiceAserCopiado();
				saidaInterfaceService();
				break;
			case 1:
				interfaceAserCopiado();
				saidaInterface();
				break;
			case 2:
				daoAserCopiado();
				saidaDAO();
				break;
			case 3:
				serviceAserCopiado();
				saidaService();
				break;
			case 4:
				controllerAserCopiado();
				saidaController();
				break;
				
			default:
				break;
			}
			
		System.out.println("Arquivos Copiado");
		
	}
	
	
}
