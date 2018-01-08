package ch.bzz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ch.bzz.model.Kategorie;
import ch.bzz.model.Produkt;
import ch.bzz.service.IndexService;

@ManagedBean(name = "indexController")
@ViewScoped
public class IndexController {

	private List<Kategorie> kategorien = new ArrayList<Kategorie>();
	private List<Produkt> produkte = new ArrayList<Produkt>();

	@EJB
	private IndexService indexService;

	@PostConstruct
	private void init() {
		kategorien = indexService.collectKategorien();
		produkte = indexService.collectFeaturedProdukte();
		System.out.println(produkte);
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
