package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bestellung database table.
 * 
 */
@Entity
@NamedQuery(name="Bestellung.findAll", query="SELECT b FROM Bestellung b")
public class Bestellung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idBestellung;

	private String bestelldatum;

	//bi-directional many-to-one association to Kunde
	@ManyToOne
	@JoinColumn(name="KundeID")
	private Kunde kunde;

	//bi-directional many-to-many association to Produkt
	@ManyToMany(mappedBy="bestellungs")
	private List<Produkt> produkts;

	public Bestellung() {
	}

	public int getIdBestellung() {
		return this.idBestellung;
	}

	public void setIdBestellung(int idBestellung) {
		this.idBestellung = idBestellung;
	}

	public String getBestelldatum() {
		return this.bestelldatum;
	}

	public void setBestelldatum(String bestelldatum) {
		this.bestelldatum = bestelldatum;
	}

	public Kunde getKunde() {
		return this.kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public List<Produkt> getProdukts() {
		return this.produkts;
	}

	public void setProdukts(List<Produkt> produkts) {
		this.produkts = produkts;
	}

}