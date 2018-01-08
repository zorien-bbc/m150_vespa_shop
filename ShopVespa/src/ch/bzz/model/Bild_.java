package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-08T09:11:21.183+0100")
@StaticMetamodel(Bild.class)
public class Bild_ {
	public static volatile SingularAttribute<Bild, Integer> idBild;
	public static volatile SingularAttribute<Bild, String> pfad;
	public static volatile SingularAttribute<Bild, Produkt> produkt;
}
