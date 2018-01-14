package ch.bzz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ch.bzz.model.Bestellung;
import ch.bzz.model.Kategorie;
import ch.bzz.model.Kunde;
import ch.bzz.model.Produkt;
import ch.bzz.service.IndexService;
import ch.bzz.service.LoginService;
import ch.bzz.service.ProduktService;
import ch.bzz.util.SessionUtils;

@ManagedBean(name = "indexController")
@ViewScoped
public class IndexController {

	private List<Kategorie> kategorien = new ArrayList<Kategorie>();
	private List<Produkt> produkte = new ArrayList<Produkt>();

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

}
