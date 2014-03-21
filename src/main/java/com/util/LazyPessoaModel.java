package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.SortOrder;

import org.primefaces.model.LazyDataModel;

import com.entity.Pessoa;

public class LazyPessoaModel extends LazyDataModel<Pessoa>{

	private static final long serialVersionUID = 1L;
		private List<Pessoa> datasource;
	    
	    public LazyPessoaModel(List<Pessoa> datasource) {
	        this.datasource = datasource;
	    }
	    
	    @Override
	    public Pessoa getRowData(String rowKey) {
	        for(Pessoa pessoa : datasource) {
	            if(pessoa.getId().equals(rowKey))
	                return pessoa;
	        }

	        return null;
	    }

	    @Override
	    public Object getRowKey(Pessoa pessoa) {
	        return pessoa.getId();
	    }

	    public List<Pessoa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
	        List<Pessoa> data = new ArrayList<Pessoa>();

	        //filter
	        for(Pessoa pessoa : datasource) {
	            boolean match = true;

	            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
	                try {
	                    String filterProperty = it.next();
	                    String filterValue = filters.get(filterProperty);
	                    String fieldValue = String.valueOf(pessoa.getClass().getField(filterProperty).get(pessoa));

	                    if(filterValue == null || fieldValue.startsWith(filterValue)) {
	                        match = true;
	                    }
	                    else {
	                        match = false;
	                        break;
	                    }
	                } catch(Exception e) {
	                    match = false;
	                } 
	            }

	            if(match) {
	                data.add(pessoa);
	            }
	        }

	        //sort
	       /* if(sortField != null) {
	            Collections.sort(data, new LazySorter(sortField, sortOrder));
	        }  */

	        //rowCount
	        int dataSize = data.size();
	        this.setRowCount(dataSize);

	        //paginate
	        if(dataSize > pageSize) {
	            try {
	                return data.subList(first, first + pageSize);
	            }
	            catch(IndexOutOfBoundsException e) {
	                return data.subList(first, first + (dataSize % pageSize));
	            }
	        }
	        else {
	            return data;
	        }
	    }
	}
