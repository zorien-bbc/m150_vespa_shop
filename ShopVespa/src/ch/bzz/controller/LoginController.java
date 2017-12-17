package ch.bzz.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bzz.model.Kategorie;

@ManagedBean(name="loginController")
public class LoginController {

	@PersistenceContext
	private EntityManager em;

	public String selectUsers() {
		List<Kategorie> kunden = em.createNamedQuery("Kategorie.findAll",Kategorie.class).getResultList();
		for (Kategorie k : kunden) {
			System.out.println(k.getName());
		}
		return null;
	}

}
