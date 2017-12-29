package ch.bzz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.bzz.model.Kategorie;
import ch.bzz.model.Produkt;
import ch.bzz.model.Tag;
import ch.bzz.service.IndexService;
import ch.bzz.service.ProduktService;

@ViewScoped
@ManagedBean
public class AdminController {

	private List<Produkt> lager;
	private Produkt produkt;
	private String kat;
	private List<String> kategorien;

	@EJB
	private ProduktService produktservice;

	@EJB
	private IndexService indexService;

	@PostConstruct
	public void init() {
		lager = produktservice.collectAll();
		produkt = new Produkt();
		kategorien = new ArrayList<String>();
		for (Kategorie k : indexService.collectKategorien()) {
			kategorien.add(k.getName());
		}

	}

	public String addProdukt() {
		Tag tag = new Tag();
		tag.setName("test");
		produkt.setKategorie(produktservice.find(kat));
		produktservice.addProdukt(produkt);
		produkt = new Produkt();
		lager = produktservice.collectAll();
		return null;
	}

	public List<Produkt> getLager() {
		return lager;
	}

	public void setLager(List<Produkt> lager) {
		this.lager = lager;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public String getKat() {
		return kat;
	}

	public void setKat(String kat) {
		this.kat = kat;
	}

	public List<String> getKategorien() {
		return kategorien;
	}

	public void setKategorien(List<String> kategorien) {
		this.kategorien = kategorien;
	}

}
