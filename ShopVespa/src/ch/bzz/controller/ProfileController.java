package ch.bzz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ch.bzz.model.Bestellung;
import ch.bzz.model.Kunde;
import ch.bzz.model.Produkt;
import ch.bzz.service.CheckoutService;
import ch.bzz.service.LoginService;
import ch.bzz.service.ProduktService;
import ch.bzz.util.SessionUtils;

@ManagedBean(name = "profileController")
@RequestScoped
public class ProfileController {
	private Kunde user;

	private List<Bestellung> meineBestellungen;

	@EJB
	LoginService loginService;

	@EJB
	ProduktService produktService;

	@PostConstruct
	public void init() {
		user = loginService.getUser(SessionUtils.getUserName());
		setMeineBestellungen(produktService.getAllFromKunde(user));

	}


	public List<Bestellung> getMeineBestellungen() {
		return meineBestellungen;
	}

	public void setMeineBestellungen(List<Bestellung> meineBestellungen) {
		this.meineBestellungen = meineBestellungen;
	}

	public Kunde getUser() {
		return user;
	}

	public void setUser(Kunde user) {
		this.user = user;
	}

}
