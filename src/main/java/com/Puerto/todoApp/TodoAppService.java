package com.Puerto.todoApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TodoAppService {
	
	 	@Autowired
		private ElementItemJpaReporitory elementItemJpaReporitory;

	    //POST
	    public void saveItem(ElementItem elementItem) {
	         elementItemJpaReporitory.save(elementItem);
	    }

	    //GET
	    public List<ElementItem> getItems() {
	        return elementItemJpaReporitory.findAll();
	    }
	    public ElementItem getItemById(int id) {
	        return elementItemJpaReporitory.findById(id).orElse(null);
	    }
	    
	    //DELETE
	    public String deleteItem(Long id) {
	    	elementItemJpaReporitory.deleteById(id);
	        return id + " id -> course removed/completed";
	    }

}
