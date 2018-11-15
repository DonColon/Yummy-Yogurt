package de.fh.albsig.dardan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/*create table Yogurt(
	    ID              int             primary key,
	    Name            varchar(64)     unique not null,
	    Veroeffentlicht varchar(8)      not null,
	    BenutzerID      int             not null,
	    constraint checkVeroeffentlicht check(Veroeffentlicht in ('true', 'false'))
);*/

@Entity
@NamedQueries({
	@NamedQuery(name="Yogurt.listAll", query="select y from Yogurt y"),
	@NamedQuery(name="Yogurt.findByName", query="select y from Yogurt y where y.name = :name"),
	@NamedQuery(name="Yogurt.findByOwner", query="select y from Yogurt y where y.owner.userID = :userID")
})
public class Yogurt implements Serializable
{

	private static final long serialVersionUID = -6134440095691454868L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="YogurtGenerator")
	@SequenceGenerator(name="YogurtGenerator",
	sequenceName="YogurtSequence", allocationSize=1)
	@Column(name="ID")
	private int yogurtID;

	@Column(name="Name", unique=true, nullable=false)
	private String name;

	@Column(name="Veroeffentlicht", nullable=false)
	private String visible;

	@ManyToOne
	@JoinColumn(name="BenutzerID", nullable=false)
	private User owner;

	@ManyToMany
	@JoinTable(name="Zutatenliste", joinColumns={@JoinColumn(name="YogurtID")},
	inverseJoinColumns={@JoinColumn(name="ZutatenID")})
	private List<Ingredient> recipe;

	@OneToMany(mappedBy="yogurt")
	private List<Rating> ratings;


	public Yogurt() {}

	public Yogurt(final String name, final boolean visibility, final User owner)
	{
		Objects.requireNonNull(owner, "owner is null");

		this.name = name;
		this.visible = Boolean.toString(visibility);
		this.owner = owner;
		this.recipe = new ArrayList<>();
		this.ratings = new ArrayList<>();
	}


	@Override
	public String toString()
	{
		return "Yogurt [yogurtID=" + this.yogurtID + ", name=" + this.name + ", visibility=" + this.visible
				+ "\n\towner=" + this.owner + "\n\trecipe=" + this.recipe + "]";
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


	public int getID()
	{
		return this.yogurtID;
	}

	public String getName()
	{
		return this.name;
	}

	public boolean isVisible()
	{
		final Boolean visible = new Boolean(this.visible);
		return visible.booleanValue();
	}

	public void setVisibility(final boolean visible)
	{
		this.visible = Boolean.toString(visible);
	}

	public User getOwner()
	{
		return this.owner;
	}

	public void addToRecipe(final Ingredient ingredient)
	{
		Objects.requireNonNull(ingredient);
		this.recipe.add(ingredient);
	}

	public void rate(final Rating rating)
	{
		Objects.requireNonNull(rating);
		this.ratings.add(rating);
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