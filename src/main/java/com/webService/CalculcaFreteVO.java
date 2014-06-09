package com.webService;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Servicos")
public class CalculcaFreteVO {

	String nCdEmpresa;
	String sDsSenha;
	String nCdServico;
	String sCepOrigem;
	String sCepDestino;
	String nVlPeso;
	String nCdFormato;
	String nVlComprimento;
	String nVlAltura;
	String nVlLargura;
	String nVlDiametro;
	String sCdMaoPropria;
	String nVlValorDeclarado;
	String sCdAvisoRecebimento;
	String StrRetorno;
	String Valor;

	public String getValor() {
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getnCdEmpresa() {
		return nCdEmpresa;
	}

	public void setnCdEmpresa(String nCdEmpresa) {
		this.nCdEmpresa = nCdEmpresa;
	}

	public String getsDsSenha() {
		return sDsSenha;
	}

	public void setsDsSenha(String sDsSenha) {
		this.sDsSenha = sDsSenha;
	}

	public String getnCdServico() {
		return nCdServico;
	}

	public void setnCdServico(String nCdServico) {
		this.nCdServico = nCdServico;
	}

	public String getsCepOrigem() {
		return sCepOrigem;
	}

	public void setsCepOrigem(String sCepOrigem) {
		this.sCepOrigem = sCepOrigem;
	}

	public String getsCepDestino() {
		return sCepDestino;
	}

	public void setsCepDestino(String sCepDestino) {
		this.sCepDestino = sCepDestino;
	}

	public String getnVlPeso() {
		return nVlPeso;
	}

	public void setnVlPeso(String nVlPeso) {
		this.nVlPeso = nVlPeso;
	}

	public String getnCdFormato() {
		return nCdFormato;
	}

	public void setnCdFormato(String nCdFormato) {
		this.nCdFormato = nCdFormato;
	}

	public String getnVlComprimento() {
		return nVlComprimento;
	}

	public void setnVlComprimento(String nVlComprimento) {
		this.nVlComprimento = nVlComprimento;
	}

	public String getnVlAltura() {
		return nVlAltura;
	}

	public void setnVlAltura(String nVlAltura) {
		this.nVlAltura = nVlAltura;
	}

	public String getnVlLargura() {
		return nVlLargura;
	}

	public void setnVlLargura(String nVlLargura) {
		this.nVlLargura = nVlLargura;
	}

	public String getnVlDiametro() {
		return nVlDiametro;
	}

	public void setnVlDiametro(String nVlDiametro) {
		this.nVlDiametro = nVlDiametro;
	}

	public String getsCdMaoPropria() {
		return sCdMaoPropria;
	}

	public void setsCdMaoPropria(String sCdMaoPropria) {
		this.sCdMaoPropria = sCdMaoPropria;
	}

	public String getnVlValorDeclarado() {
		return nVlValorDeclarado;
	}

	public void setnVlValorDeclarado(String nVlValorDeclarado) {
		this.nVlValorDeclarado = nVlValorDeclarado;
	}

	public String getsCdAvisoRecebimento() {
		return sCdAvisoRecebimento;
	}

	public void setsCdAvisoRecebimento(String sCdAvisoRecebimento) {
		this.sCdAvisoRecebimento = sCdAvisoRecebimento;
	}

	public String getStrRetorno() {
		return StrRetorno;
	}

	public void setStrRetorno(String strRetorno) {
		StrRetorno = strRetorno;
	}

}
