package ch.bzz.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ch.bzz.model.Produkt;
import ch.bzz.service.ProduktService;

@ManagedBean(name = "searchController")
@SessionScoped
public class SearchController implements Serializable {

	private List<Produkt> produkte = new ArrayList<Produkt>();
	private String searchString="";

	@EJB
	private ProduktService produktService;
		
	public void searchProdukt(){
		produkte = produktService.searchProdukte(searchString);
		for(Produkt p : produkte){
			System.out.println("test"+p.toString());
		}
	}
	
	public String redirect(){
		return "searchResults.xhtml?faces-redirect=true";
	}
	public List<Produkt> getProdukte() {
		return produkte;
	} 

	public void setProdukte(List<Produkt> produkte) {
		this.produkte = produkte;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
}
