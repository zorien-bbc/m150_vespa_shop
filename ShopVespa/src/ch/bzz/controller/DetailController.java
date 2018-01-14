package ch.bzz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;

import ch.bzz.model.Bestellung;
import ch.bzz.model.Kunde;
import ch.bzz.model.Produkt;
import ch.bzz.service.LoginService;
import ch.bzz.service.ProduktService;
import ch.bzz.util.SessionUtils;

@ViewScoped
@ManagedBean
public class DetailController {
	private int produktId;
	private Produkt produkt;
	List<Produkt> list;

	@EJB
	ProduktService produktservice;
	@EJB
	LoginService loginService;

	public void init() {
		HttpServletRequest req = SessionUtils.getRequest();
		produktId = Integer.valueOf(req.getParameter("id"));
		System.out.println(produktId);
		produkt = produktservice.find(produktId);
	}

	public String addToWarenkorb() {
		Kunde user = loginService.getUser(SessionUtils.getUserName());
		Bestellung bs = produktservice.getLatestBestellung(user);
		bs.setBestelldatum(new Date().toString());
		bs.getProdukts().add(produkt);
		user.addBestellung(bs);
		produktservice.addToWarenkorb(produkt, bs);
		return null;
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

	public List<Produkt> getList() {
		return list;
	}

	public void setList(List<Produkt> list) {
		this.list = list;
	}

}
