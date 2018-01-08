package ch.bzz.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ch.bzz.model.Kategorie;
import ch.bzz.model.Produkt;
import ch.bzz.service.ProduktService;

@ViewScoped
@ManagedBean
public class ListController {
	Kategorie kategorie;
	String kategoriename;
	List<Produkt> produkte = new ArrayList<Produkt>();

	@EJB
	ProduktService produktservice;

	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		kategoriename = req.getParameter("kategorie");
		System.out.println(kategoriename);
		produkte = produktservice.findProductsWithKat(kategoriename);
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public String getKategoriename() {
		return kategoriename;
	}

	public void setKategoriename(String kategoriename) {
		this.kategoriename = kategoriename;
	}

	public List<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(List<Produkt> produkte) {
		this.produkte = produkte;
	}

}
