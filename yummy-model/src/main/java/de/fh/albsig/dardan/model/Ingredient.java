package de.fh.albsig.dardan.model;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Zutat(
	    ID    int           primary key,
	    Name  varchar(64)   unique not null,
	    Vegan varchar(8)    not null,
	    Haram varchar(8)    not null,
	    ZutatenkategorieID  int      not null,
	    constraint checkVegan check(Vegan in ('true', 'false')),
	    constraint checkHaram check(Haram in ('true', 'false'))
);*/

@Entity
@Table(name="Zutat")
@NamedQueries({
	@NamedQuery(name="Ingredient.listAll", query="select i from Ingredient i"),
	@NamedQuery(name="Ingredient.findByName", query="select i from Ingredient i where i.name = :name")
})
public final class Ingredient implements Serializable 
{
	
	private static final long serialVersionUID = -4899690730111444088L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IngredientGenerator")
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
	@JoinColumn(name="ZutatenkategorieID", nullable=false)
	private Category category;
	
	
	public Ingredient() {}

	public Ingredient(final String name, final String isVegan, 
					  final String isHaram, final Category category) 
	{
		Objects.requireNonNull(category, "category is null");
		
		this.name = name;
		this.vegan = isVegan;
		this.haram = isHaram;
		this.category = category;
	}
	

	@Override
	public String toString() 
	{
		return "Ingredient [ingredientID=" + ingredientID + ", name=" + name + ", vegan=" + vegan + ", haram="
				+ haram + "\n\tcategory=" + category + "]";
	}

	@Override
	public boolean equals(final Object object) 
	{
		if(object == null) return false;
		if(this == object) return true;
		
		if(this.getClass() != object.getClass())
			return false;
		
		Ingredient other = (Ingredient) object;
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

	public int getID() {return ingredientID;}

	public String getName() {return name;}

	public boolean isVegan() 
	{
		Boolean vegan = new Boolean(this.vegan);
		return vegan.booleanValue();
	}

	public boolean isHaram() 
	{
		Boolean haram = new Boolean(this.haram);
		return haram.booleanValue();
	}

	public Category getCategory() {return category;}
	
}
