package ch.bzz.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bzz.model.Produkt;

@Stateless
public class ProduktService {
	@PersistenceContext(name = "VespaShop_Pool")
	private EntityManager em;

	public List<Produkt> collectAll() {
		List<Produkt> produkte = em.createNamedQuery("Produkt.findAll", Produkt.class).getResultList();
		return produkte;
	}

	public Produkt find(int produktID) {
		System.out.println(produktID);
		return em.find(Produkt.class, produktID);
	}

}
