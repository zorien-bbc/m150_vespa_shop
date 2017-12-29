package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-29T15:39:55.697+0100")
@StaticMetamodel(Bild.class)
public class Bild_ {
	public static volatile SingularAttribute<Bild, Integer> idBild;
	public static volatile SingularAttribute<Bild, String> pfad;
	public static volatile SingularAttribute<Bild, Produkt> produkt;
}
