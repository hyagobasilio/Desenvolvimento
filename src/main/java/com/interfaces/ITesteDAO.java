package com.interfaces;

import java.util.List;

import com.entity.Teste;
import com.util.IDAO;

public interface ITesteDAO extends IDAO<Teste>{
	
	List<Teste> listaTestes (Teste entidade);
}
