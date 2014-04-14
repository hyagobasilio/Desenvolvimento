package com.interfaces;

import java.util.List;

import com.entity.Teste;

public interface ITesteService {
	void salvar(Teste teste) throws IllegalArgumentException;
	List<Teste> listaTestes(Teste teste);
	void deletar(Teste teste);
}
