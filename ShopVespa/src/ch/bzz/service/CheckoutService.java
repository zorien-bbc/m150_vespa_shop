package ch.bzz.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bzz.model.Bestellung;

@Stateless
public class CheckoutService {
	@PersistenceContext(name = "VespaShop_Pool")
	private EntityManager em;

	public void checkout(Bestellung bestellung) {
		bestellung.setStatus("Bestellt");
		em.merge(bestellung);
	}

	public List<Bestellung> collectAllBestellungen() {
		return em.createNamedQuery("Bestellung.findAll", Bestellung.class).getResultList();
	}
}
