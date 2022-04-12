package com.database.dbex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.database.dbex.model.Persons;

@Repository
public interface PersonsRepository extends JpaRepository<Persons, Long> {
	
	List<Persons> findAll(); 
	
	Page<Persons> findAll(Pageable page);
	
	List<Persons> findAllByFirstName(String fName); 
	
	Page<Persons> findAllByFirstName(String fName,Pageable page); 
		
	List<Persons> findByFirstNameContains(String fName);
	
	Page<Persons> findByFirstNameContains(String fName,Pageable page);

	Optional<Persons> findById(Long id);
	
	Persons findFristById(Long id);
	
	Persons findByFirstName(String fName );
	
	Persons findByLastName(String lName );
	
	Persons findByFirstNameAndLastName(String fName, String lName );
	
}
