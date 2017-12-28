package ch.bzz.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ch.bzz.model.Produkt;
import ch.bzz.service.ProduktService;

@ViewScoped
@ManagedBean
public class DetailController {
	private int produktId;
	private Produkt produkt;
	@EJB
	ProduktService produktservice;

	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		produktId = Integer.valueOf(req.getParameter("id"));
		System.out.println(produktId);
		produkt = produktservice.find(produktId);
	}

	public int getProduktId() {
		return produktId;
	}

	public void setProduktId(int produktId) {
		this.produktId = produktId;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

}
