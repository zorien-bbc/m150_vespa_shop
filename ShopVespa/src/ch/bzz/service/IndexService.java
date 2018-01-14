package ch.bzz.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bzz.model.Kategorie;
import ch.bzz.model.Produkt;

@Stateless
public class IndexService {

	@PersistenceContext(name = "VespaShop_Pool")
	private EntityManager em;

	public List<Kategorie> collectKategorien() {
		List<Kategorie> kategorien = em.createNamedQuery("Kategorie.findAll", Kategorie.class).getResultList();
		System.out.println(kategorien);
		return kategorien;
	}

	public List<Produkt> collectFeaturedProdukte() {
		List<Produkt> produkte = em.createNamedQuery("Produkt.findAll", Produkt.class).getResultList();
		while (produkte.size() > 6) {
			produkte.remove(1);
		}
		return produkte;
	}

	public List<Produkt> test() {
		// TODO Auto-generated method stub
		return null;
	}

}
