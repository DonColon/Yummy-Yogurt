package de.fh.albsig.dardan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.fh.albsig.dardan.exception.InvalidArgumentException;

/*create table Yogurt(
	    ID              int              primary key,
	    Name            varchar2(64)     not null,
	    Preis           int              not null,
	    Veroeffentlicht varchar2(8)      not null,
	    Besitzer        int              not null,
	    constraint checkYogurtPreis check(Preis > 0),
	    constraint checkVeroeffentlicht check(Veroeffentlicht in ('true', 'false'))
);*/

@Entity
@Table(name="Yogurt")
public class Yogurt implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = 5744860498318650165L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="YogurtGenerator")
	@SequenceGenerator(name="YogurtGenerator",
		sequenceName="YogurtSequence", allocationSize=1)
	@Column(name="ID")
	private int yogurtID;

	@Column(name="Name", nullable=false)
	private String name;

	@Column(name="Preis", nullable=false)
	private int priceInCents;

	@Column(name="Veroeffentlicht", nullable=false)
	private String visibility;

	@ManyToOne
	@JoinColumn(name="Besitzer", nullable=false)
	private User owner;

	@ManyToMany
	@JoinTable(name="Zutatenliste", joinColumns={@JoinColumn(name="Yogurt")},
		inverseJoinColumns={@JoinColumn(name="Zutat")})
	private List<Ingredient> recipe;

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Yogurt", insertable=false, updatable=false)
	private List<Rating> ratings;


	public Yogurt() {}

	public Yogurt(final String name, final int priceInCents,
				  final boolean visibility, final User owner)
	{
		Objects.requireNonNull(owner, "owner is null");

		this.name = name;
		this.priceInCents = priceInCents;
		this.visibility = Boolean.toString(visibility);
		this.owner = owner;
		this.recipe = new ArrayList<>();
		this.ratings = new ArrayList<>();
	}


	@Override
	public String toString()
	{
		return "Yogurt [yogurtID=" + this.yogurtID + ", name=" + this.name
				+ ", priceInCents=" + this.priceInCents + ", visibility=" + this.visibility
				+ ", owner=" + this.owner + "\n\t recipe=" + this.recipe
				+ "\n\t ratings=" + this.ratings + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Yogurt other = (Yogurt) object;
		return Objects.equals(this.yogurtID, other.getID())
			&& Objects.equals(this.name, other.getName())
			&& Objects.equals(this.owner, other.getOwner());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.yogurtID, this.name, this.owner);
	}


	public void setVisibility(final boolean visibility)
	{
		this.visibility = Boolean.toString(visibility);
	}

	public void addToRecipe(final Ingredient ingredient)
		throws InvalidArgumentException
	{
		if(ingredient == null)
			throw new InvalidArgumentException();

		this.recipe.add(ingredient);
	}

	public void rate(final Rating rating)
		throws InvalidArgumentException
	{
		if(rating == null)
			throw new InvalidArgumentException();

		this.ratings.add(rating);
	}

	@Override
	public Integer getID()
	{
		return this.yogurtID;
	}

	public String getName()
	{
		return this.name;
	}

	public int getPriceInCents()
	{
		return this.priceInCents;
	}

	public boolean isVisibile()
	{
		final Boolean visibility = new Boolean(this.visibility);
		return visibility.booleanValue();
	}

	public User getOwner()
	{
		return this.owner;
	}

	public List<Ingredient> getRecipe()
	{
		return Collections.unmodifiableList(this.recipe);
	}

	public List<Rating> getRatings()
	{
		return Collections.unmodifiableList(this.ratings);
	}

}
