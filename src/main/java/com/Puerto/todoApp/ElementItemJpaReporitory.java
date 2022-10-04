package com.Puerto.todoApp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementItemJpaReporitory extends JpaRepository<ElementItem, Long>{

	void deleteById(int id);

	Optional<ElementItem> findById(int id);
	
	Optional<ElementItem> findByEmail(String email);
	
	
	
	

	//ElementItem findByName(String name);

	//List<ElementItem> findAllByUsername(String username);
	

}
