package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Kategorie database table.
 * 
 */
@Entity
@Table(name="Kategorie")
@NamedQuery(name="Kategorie.findAll", query="SELECT k FROM Kategorie k")
public class Kategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idKategorie;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Produkt
	@OneToMany(mappedBy="kategorie")
	private List<Produkt> produkts;

	public Kategorie() {
	}

	public int getIdKategorie() {
		return this.idKategorie;
	}

	public void setIdKategorie(int idKategorie) {
		this.idKategorie = idKategorie;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Produkt> getProdukts() {
		return this.produkts;
	}

	public void setProdukts(List<Produkt> produkts) {
		this.produkts = produkts;
	}

	public Produkt addProdukt(Produkt produkt) {
		getProdukts().add(produkt);
		produkt.setKategorie(this);

		return produkt;
	}

	public Produkt removeProdukt(Produkt produkt) {
		getProdukts().remove(produkt);
		produkt.setKategorie(null);

		return produkt;
	}

}