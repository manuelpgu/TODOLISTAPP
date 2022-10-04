package com.Puerto.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ElementController {
    @Autowired
    private TodoAppService todoAppService;
    //POST
    @PostMapping("/addElement")
    public void addElement(ElementItem item) {
        todoAppService.saveItem(item);
    }

    //GET
    @GetMapping("/")
    public String getAllElements(Model model) {
    	
    	ElementItem elementItem = new ElementItem(1L, "Titulo1", "Descripcion1");
    	ElementItem elementItem2 = new ElementItem(2L, "Titulo2", "Descripcion2");
    	
    
    	
    	model.addAttribute("items", todoAppService.getItems());
    	
        return "index";
    }
    
    @GetMapping("/addSome")
    public String addSome() {
    	
    	ElementItem elementItem = new ElementItem(1L, "Titulo1", "Descripcion1");
    	ElementItem elementItem2 = new ElementItem(2L, "Titulo2", "Descripcion2");
    		
    	todoAppService.saveItem(elementItem);
    	todoAppService.saveItem(elementItem2);
    	
    	 return "redirect:/";
    }
    
    @GetMapping("/courseById/{id}")
    public ElementItem findElementById(@PathVariable int id) {
        return todoAppService.getItemById(id);
    }

    //DELETE
    @RequestMapping(value = "/delete_item/{personId}", method = RequestMethod.GET)
    public String handleDeleteUser(@PathVariable String personId) {
    	System.err.print(personId);
    	
    	todoAppService.deleteItem(Long.parseLong((personId)));
        return "redirect:/";
    }
    
    
    
}