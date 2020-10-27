package com.manel.formations;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.manel.formations.entities.Formation;
import com.manel.formations.repos.FormationRepository;
import com.manel.formations.service.FormationService;

@SpringBootTest
class FormationsApplicationTests {

	@Autowired
	private FormationRepository formationRepository;
	private FormationService formationService;
	
	@Test
	public void testCreateFormation()
	{
		Formation form = new Formation("JEE" , "présentielle" , 50.000 , new Date());
		formationRepository.save(form);
	}

	@Test
	public void testFindFormation()
	{ 
		Formation f = formationRepository.findById(1L).get(); 
		System.out.println(f);
	}
	
	@Test
	public void testUpdateFormation()
	{ 
		Formation f = formationRepository.findById(1L).get();
		f.setPrixFormation(100.0);; 
		formationRepository.save(f);
	}
	
	@Test
	public void testDeleteFormation()
	{
		formationRepository.deleteById(1L);;
	}
	
	@Test
	public void ListerTousFormation()
	{
		List<Formation> form = formationRepository.findAll();
		for (Formation f : form)
		{
			System.out.println(f);
		}
	}
	
	@Test
	public void testFindByNomFormationContains()
	{
	Page<Formation> form = formationService.getAllFormationsParPage(0,2);
	System.out.println(form.getSize());
	System.out.println(form.getTotalElements()); 
	System.out.println(form.getTotalPages());
	form.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
}
