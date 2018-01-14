package ch.bzz.controller;

import java.text.DecimalFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ch.bzz.model.Bestellung;
import ch.bzz.model.Kunde;
import ch.bzz.model.Produkt;
import ch.bzz.service.CheckoutService;
import ch.bzz.service.LoginService;
import ch.bzz.service.ProduktService;
import ch.bzz.util.SessionUtils;

@ManagedBean(name = "warenkorbController")
@RequestScoped
public class WarenkorbController {
	private Bestellung warenkorb;
	private float preis;

	@EJB
	LoginService loginService;

	@EJB
	ProduktService produktService;
	@EJB
	CheckoutService checkoutService;

	@PostConstruct
	public void init() {
		Kunde user;
		user = loginService.getUser(SessionUtils.getUserName());
		warenkorb = produktService.getWarenkorb(user);
		preis=0;
		for (Produkt p : warenkorb.getProdukts()) {
			preis = preis + p.getPreis();
		}
		DecimalFormat df = new DecimalFormat("###.##");
		preis= Float.valueOf(df.format(preis));

	}

	public String checkout() {
		warenkorb.setBestelldatum(new Date().toString());
		checkoutService.checkout(warenkorb);
		return "profile";
	}

	public Bestellung getWarenkorb() {
		return warenkorb;
	}

	public void setWarenkorb(Bestellung warenkorb) {
		this.warenkorb = warenkorb;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

}
