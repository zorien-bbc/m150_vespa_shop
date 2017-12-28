package ch.bzz.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.bzz.model.Produkt;
import ch.bzz.service.ProduktService;

@SessionScoped
@ManagedBean
public class AdminController {

	private List<Produkt> lager;

	@EJB
	private ProduktService produktservice;

	@PostConstruct
	public void init() {
		lager = produktservice.collectAll();
	}

	public List<Produkt> getLager() {
		return lager;
	}

	public void setLager(List<Produkt> lager) {
		this.lager = lager;
	}

}
