package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2017-12-12T17:22:58.688+0100")
@StaticMetamodel(Tag.class)
public class Tag_ {
	public static volatile SingularAttribute<Tag, Integer> idTags;
	public static volatile SingularAttribute<Tag, String> name;
	public static volatile ListAttribute<Tag, Produkt> produkts;
}
