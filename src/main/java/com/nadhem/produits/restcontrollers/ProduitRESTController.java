package com.nadhem.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.service.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
	
	@Autowired
	ProduitService produitService;
	
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Produit> getAllProduits()
	{
		return produitService.getAllProduits();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Produit createProduit(@RequestBody Produit produit) {
			return produitService.saveProduit(produit);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
			produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
	}
	
	@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
	public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
		return produitService.findByNomProduitContains(nom);
	}

	

}
