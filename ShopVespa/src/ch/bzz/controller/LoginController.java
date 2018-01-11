package ch.bzz.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ch.bzz.service.LoginService;
import ch.bzz.util.SessionUtils;

@ManagedBean(name = "loginController")
public class LoginController {

	private String mail;
	private String pwd;

	@EJB
	private LoginService loginS;

	public String login() {
		boolean valid = loginS.validate(mail, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", mail);
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username or Passowrd", "Please enter correct username and Password"));
			return "";
		}
	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index";
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
