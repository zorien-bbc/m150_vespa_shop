package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produkt database table.
 * 
 */
@Entity
@Table(name="Produkt")
@NamedQuery(name="Produkt.findAll", query="SELECT p FROM Produkt p")
public class Produkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idProdukte;

	private String artikelNr;

	private String bezeichnung;

	private String bildPfad;

	private String lagerbestand;

	private float preis;

	private String produktcol;

	private int produktkategorieID;

	//bi-directional many-to-one association to Kategorie
	@ManyToOne
	@JoinColumn(name="Kategorie_idKategorie1")
	private Kategorie kategorie;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="TagsID")
	private Tag tag;

	//bi-directional many-to-many association to Bestellung
	@ManyToMany
	@JoinTable(
		name="warenkorb"
		, joinColumns={
			@JoinColumn(name="Produkt_idProdukte")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Bestellung_idBestellung")
			}
		)
	private List<Bestellung> bestellungs;

	public Produkt() {
	}

	public int getIdProdukte() {
		return this.idProdukte;
	}

	public void setIdProdukte(int idProdukte) {
		this.idProdukte = idProdukte;
	}

	public String getArtikelNr() {
		return this.artikelNr;
	}

	public void setArtikelNr(String artikelNr) {
		this.artikelNr = artikelNr;
	}

	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBildPfad() {
		return this.bildPfad;
	}

	public void setBildPfad(String bildPfad) {
		this.bildPfad = bildPfad;
	}

	public String getLagerbestand() {
		return this.lagerbestand;
	}

	public void setLagerbestand(String lagerbestand) {
		this.lagerbestand = lagerbestand;
	}

	public float getPreis() {
		return this.preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public String getProduktcol() {
		return this.produktcol;
	}

	public void setProduktcol(String produktcol) {
		this.produktcol = produktcol;
	}

	public int getProduktkategorieID() {
		return this.produktkategorieID;
	}

	public void setProduktkategorieID(int produktkategorieID) {
		this.produktkategorieID = produktkategorieID;
	}

	public Kategorie getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Bestellung> getBestellungs() {
		return this.bestellungs;
	}

	public void setBestellungs(List<Bestellung> bestellungs) {
		this.bestellungs = bestellungs;
	}

}