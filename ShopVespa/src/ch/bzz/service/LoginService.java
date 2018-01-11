package ch.bzz.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import ch.bzz.model.Bestellung;
import ch.bzz.model.Kunde;

@Stateless
public class LoginService {

	@PersistenceContext(name = "VespaShop_Pool")
	private EntityManager em;

	public boolean validate(String mail, String pwd) {
		try {
			Kunde user = (Kunde) em.createQuery("SELECT k from Kunde k where k.mail = :mail and k.passwort = :password")
					.setParameter("mail", mail).setParameter("password", pwd).getSingleResult();

		} catch (NoResultException e) {
			return false;
		}
		return true;
	}

	public Kunde getUser(String mail) {
		return (Kunde) em.createQuery("SELECT k from Kunde k where k.mail = :mail ").setParameter("mail", mail)
				.getSingleResult();
	}

	public void persist(Bestellung bestellung) {
		em.persist(bestellung);
		
	}
}
