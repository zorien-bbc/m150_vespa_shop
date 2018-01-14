package ch.bzz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.bzz.model.Kategorie;
import ch.bzz.model.Kunde;
import ch.bzz.model.Produkt;
import ch.bzz.service.IndexService;
import ch.bzz.service.LoginService;
import ch.bzz.service.ProduktService;

@ManagedBean(name = "indexController")
@ViewScoped
public class IndexController {

	private List<Kategorie> kategorien = new ArrayList<Kategorie>();
	private List<Produkt> produkte = new ArrayList<Produkt>();
	private Kunde registerUser= new Kunde();

	@EJB
	private IndexService indexService;
	@EJB
	ProduktService produktservice;
	@EJB
	LoginService loginService;

	@PostConstruct
	private void init() {
		kategorien = indexService.collectKategorien();
		produkte = indexService.collectFeaturedProdukte();

	}

	public String register() {
		loginService.register(registerUser);
		return "index";
	}

	public List<Kategorie> getKategorien() {
		return kategorien;
	}

	public void setKategorien(List<Kategorie> kategorien) {
		this.kategorien = kategorien;
	}

	public List<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(List<Produkt> produkte) {
		this.produkte = produkte;
	}

	public Kunde getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(Kunde registerUser) {
		this.registerUser = registerUser;
	}

}
