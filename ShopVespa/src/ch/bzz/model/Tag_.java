package ch.bzz.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-08T09:03:29.649+0100")
@StaticMetamodel(Tag.class)
public class Tag_ {
	public static volatile SingularAttribute<Tag, Integer> idTags;
	public static volatile SingularAttribute<Tag, String> name;
	public static volatile ListAttribute<Tag, Produkt> produkts;
}
