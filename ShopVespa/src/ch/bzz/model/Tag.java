package ch.bzz.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Tags database table.
 * 
 */
@Entity
@Table(name="Tags")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTags;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-many association to Produkt
	@ManyToMany
	@JoinTable(
		name="Tags_has_Produkt"
		, joinColumns={
			@JoinColumn(name="Tags_idTags")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Produkt_idProdukte")
			}
		)
	private List<Produkt> produkts;

	public Tag() {
	}

	public int getIdTags() {
		return this.idTags;
	}

	public void setIdTags(int idTags) {
		this.idTags = idTags;
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

}