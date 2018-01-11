package ch.bzz.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ch.bzz.model.Kunde;
import ch.bzz.service.LoginService;
import ch.bzz.util.SessionUtils;

@ManagedBean(name = "profileController")
@ViewScoped
public class ProfileController {
	private Kunde user;

	@EJB
	LoginService loginService;

	@PostConstruct
	public void init() {
		user = loginService.getUser(SessionUtils.getUserName());
	}

	public Kunde getUser() {
		return user;
	}

	public void setUser(Kunde user) {
		this.user = user;
	}

}
