package ch.bzz.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.bzz.model.Bestellung;
import ch.bzz.model.Kategorie;
import ch.bzz.model.Produkt;
import ch.bzz.model.Tag;

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

	public Kategorie find(String katname) {
		return (Kategorie) em.createQuery("SELECT k FROM Kategorie k WHERE k.name LIKE :name")
				.setParameter("name", katname).getSingleResult();
	}

	public void addProdukt(Produkt produkt) {
		System.out.println("test");
		em.persist(produkt);

	}

	public Tag collectTag(int i) {
		// TODO Auto-generated method stub
		return em.find(Tag.class, i);
	}

	public List<Produkt> findProductsWithKat(String kategoriename) {
		System.out.println(kategoriename);
		TypedQuery<Kategorie> query = em.createQuery("SELECT k FROM Kategorie k WHERE k.name = :name", Kategorie.class);
		Kategorie kat= (Kategorie) query.setParameter("name", kategoriename).getSingleResult();
		return kat.getProdukts();
	}
	
	public void addToWarenkorb(Produkt pro, Bestellung bes) {
		Query query = em.createNativeQuery("INSERT INTO warenkorb (`Bestellung_idBestellung`, `Produkt_idProdukte`) VALUES (?, ?)");
		query.setParameter(1, bes.getIdBestellung());
		query.setParameter(2, pro.getIdProdukt());
		query.executeUpdate();
	}

}
