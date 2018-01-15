package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-14T22:33:21.666+0100")
@StaticMetamodel(Kategorie.class)
public class Kategorie_ {
	public static volatile SingularAttribute<Kategorie, Integer> idKategorie;
	public static volatile SingularAttribute<Kategorie, String> name;
	public static volatile ListAttribute<Kategorie, Produkt> produkts;
}
