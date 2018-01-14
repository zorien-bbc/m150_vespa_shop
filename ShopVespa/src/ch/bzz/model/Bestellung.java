package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Bestellung database table.
 * 
 */
@Entity
@Table(name = "Bestellung")
@NamedQueries(value = { @NamedQuery(name = "Bestellung.findAll", query = "SELECT b FROM Bestellung b"),
		@NamedQuery(name = "Bestellung.latest", query = "Select b FROM Bestellung b WHERE b.kunde = :kunde and b.status = 'Offen'"),
		@NamedQuery(name = "Bestellung.userBestellungen", query = "Select b FROM Bestellung b WHERE b.kunde = :kunde") })

public class Bestellung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBestellung;

	@Column(name = "Bestelldatum")
	private String bestelldatum;

	// bi-directional many-to-one association to Kunde
	@ManyToOne
	@JoinColumn(name = "KundeID")
	private Kunde kunde;

	@Column(name = "Status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// bi-directional many-to-many association to Produkt
	@ManyToMany(mappedBy = "bestellungs")
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