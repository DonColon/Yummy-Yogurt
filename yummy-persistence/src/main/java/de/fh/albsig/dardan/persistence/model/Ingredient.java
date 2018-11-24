package de.fh.albsig.dardan.persistence.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Zutat(
	    ID    int            primary key,
	    Name  varchar2(64)   unique not null,
	    Vegan varchar2(8)    not null,
	    Haram varchar2(8)    not null,
	    Kategorie  int       not null,
	    constraint checkVegan check(Vegan in ('true', 'false')),
	    constraint checkHaram check(Haram in ('true', 'false'))
);*/

@Entity
@Table(name="Zutat")
public class Ingredient implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = 3391019504309836397L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="IngredientGenerator")
	@SequenceGenerator(name="IngredientGenerator",
		sequenceName="IngredientSequence", allocationSize=1)
	@Column(name="ID")
	private int ingredientID;

	@Column(name="Name", unique=true, nullable=false)
	private String name;

	@Column(name="Vegan", nullable=false)
	private String vegan;

	@Column(name="Haram", nullable=false)
	private String haram;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Kategorie", nullable=false)
	private Category category;


	public Ingredient() {}

	public Ingredient(final String name, final boolean vegan,
					  final boolean haram, final Category category)
	{
		Objects.requireNonNull(category, "category is null");

		this.name = name;
		this.vegan = Boolean.toString(vegan);
		this.haram = Boolean.toString(haram);
		this.category = category;
	}


	@Override
	public String toString()
	{
		return "Ingredient [ingredientID=" + this.ingredientID + ", name=" + this.name
				+ ", vegan=" + this.vegan + ", haram=" + this.haram
				+ ", category=" + this.category + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Ingredient other = (Ingredient) object;
		return Objects.equals(this.ingredientID, other.getID())
			&& Objects.equals(this.name, other.getName())
			&& Objects.equals(this.category, other.getCategory());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.ingredientID, this.name, this.category);
	}


	public void setVegan(final boolean vegan)
	{
		this.vegan = Boolean.toString(vegan);
	}

	public void setHaram(final boolean haram)
	{
		this.haram = Boolean.toString(haram);
	}

	@Override
	public Integer getID()
	{
		return this.ingredientID;
	}

	public String getName()
	{
		return this.name;
	}

	public boolean isVegan()
	{
		final Boolean vegan = Boolean.valueOf(this.vegan);
		return vegan.booleanValue();
	}

	public boolean isHaram()
	{
		final Boolean haram = Boolean.valueOf(this.haram);
		return haram.booleanValue();
	}

	public Category getCategory()
	{
		return this.category;
	}

}
