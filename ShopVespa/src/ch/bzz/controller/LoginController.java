package ch.bzz.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bzz.model.Kunde;

@ManagedBean(name="loginController")
public class LoginController {

	@PersistenceContext
	private EntityManager em;

	public String selectUsers() {
		List<Kunde> kunden = em.createQuery("SELECT k FROM Kunde k").getResultList();
		for (Kunde k : kunden) {
			System.out.println(k.getVorname());
		}
		return null;
	}

}
