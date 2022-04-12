package com.database.dbex.service;

import java.util.List;

import org.example.calculate.Calculate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.dbex.dto.PersonResponse;
import com.database.dbex.dto.PresonRequest;
import com.database.dbex.model.Persons;
import com.database.dbex.repository.PersonsRepository;

@Service
public class PersonsService {

	@Autowired
	private PersonsRepository repo;
		
	public PersonResponse savePerson(PresonRequest pReq) {
		Persons p = new Persons();
		/*
		 * p.setFirstName(pReq.getFirstName()); p.setLastName(pReq.getLastName());
		 * p.setAddress(pReq.getAddress());
		 */
		BeanUtils.copyProperties(pReq, p);
		p.setCity("Bangalore");
		Calculate a=new Calculate();
		p.setAge(a.calculateAge(pReq.getDob()));
		if(repo.save(p) != null) {
			PersonResponse pr = new PersonResponse();
			/*
			 * pr.setFirstName(p.getFirstName()); pr.setLastName(p.getLastName());
			 * pr.setAddress(p.getAddress()); pr.setCity(p.getCity());
			 */		
			BeanUtils.copyProperties(p, pr);
			return pr;
		}else {
			return null;
		}
	}

	public List<Persons> getPerson() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public Persons updatePerson(PresonRequest pReq) {
		if(repo.findById(pReq.getId()).isPresent())
		{Persons p = new Persons();
			Calculate a=new Calculate();
			p.setAge(a.calculateAge(pReq.getDob()));
		p.setCity("Bangalore");
		BeanUtils.copyProperties(pReq, p);
return repo.save(p);
		}
		return null;
	}
	public String deletePerson(Long id) {
		if(repo.findById(id).isPresent())
		{//Persons p = new Persons();
		//p.setCity("Bangalore");
		//BeanUtils.copyProperties(pReq, p);
repo.deleteById(id);
return "successfully deleted";
		}
		return "user not found";
		
	}
}
