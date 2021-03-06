package de.fh.albsig.dardan.persistence.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Zutatenkategorie(
	    ID    int          primary key,
	    Name  varchar2(64) unique not null,
	    Preis int          not null,
	    constraint checkKategoriePreis check(Preis > 0)
);*/

@Entity
@Table(name="Zutatenkategorie")
public class Category implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = 4911393816666739825L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="CategoryGenerator")
	@SequenceGenerator(name="CategoryGenerator",
		sequenceName="CategorySequence", allocationSize=1)
	@Column(name="ID")
	private int categoryID;

	@Column(name="Name", unique=true, nullable=false)
	private String name;

	@Column(name="Preis", nullable=false)
	private int priceInCents;


	public Category() {}

	public Category(final String name, final int priceInCents)
	{
		this.name = name;
		this.priceInCents = priceInCents;
	}


	@Override
	public String toString()
	{
		return "Category [categoryID=" + this.categoryID + ", name=" + this.name
				+ ", priceInCents=" + this.priceInCents + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Category other = (Category) object;
		return Objects.equals(this.categoryID, other.getID())
			&& Objects.equals(this.name, other.getName());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.categoryID, this.name);
	}


	public void setPriceInCents(final int priceInCents)
	{
		this.priceInCents = priceInCents;
	}

	@Override
	public Integer getID()
	{
		return this.categoryID;
	}

	public String getName()
	{
		return this.name;
	}

	public int getPriceInCents()
	{
		return this.priceInCents;
	}

}
