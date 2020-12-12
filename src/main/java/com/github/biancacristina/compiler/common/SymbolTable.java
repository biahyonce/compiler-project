package com.github.biancacristina.compiler.common;

import java.util.HashMap;

public class SymbolTable {
    private HashMap<String, Integer> table;
    private Integer index = 0;
    
    public SymbolTable() {
    	table = new HashMap<String, Integer>();
    }
    
    public void insertId(String identificador) {
    	this.table.put(identificador, this.index++);
    } 
   
    public HashMap<String, Integer> getTable() {
		return table;
	}

	public void setTable(HashMap<String, Integer> table) {
		this.table = table;
	}

	public boolean existsId(String identificador) {
    	if(this.table.containsKey(identificador)) {
    		return true;
    	}
    	
    	return false;
    }
    
    public Integer getIndex(String identificador) {
    	if(existsId(identificador)) {
    		return table.get(identificador);
    	} else {
    		insertId(identificador);
    		return table.get(identificador);
    	}
    }
    
}
