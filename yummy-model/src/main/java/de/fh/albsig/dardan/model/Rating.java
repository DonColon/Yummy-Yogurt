package de.fh.albsig.dardan.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Bewertung(
	    BenutzerID   int,
	    YogurtID     int,
	    primary key(BenutzerID,YogurtID),
	    
	    Wertung int not null,
	    constraint checkWertung check(Wertung >= 1 and Wertung <= 5)
);*/

@Entity
@Table(name="Bewertung")
@NamedQuery(name="Rating.listAll", query="select r from Rating r")
public final class Rating implements Serializable 
{
	
	private static final long serialVersionUID = 5767727589601503395L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RatingGenerator")
	@SequenceGenerator(name="RatingGenerator", 
		sequenceName="RatingSequence", allocationSize=1)
	@Column(name="ID")
	private int ratingID;
	
	@ManyToOne
	@JoinColumn(name="BenutzerID", insertable=false, updatable=false)
	private User evaluator;
	
	@ManyToOne
	@JoinColumn(name="YogurtID", insertable=false, updatable=false)
	private Yogurt yogurt;
	
	@Column(name="Wertung", nullable=false)
	private int rating;
	
	
	public Rating() {}

	public Rating(final User evaluator, final Yogurt yogurt, final int rating) 
	{
		Objects.requireNonNull(evaluator, "evaluator is null");
		Objects.requireNonNull(yogurt, "yogurt is null");
		
		this.evaluator = evaluator;
		this.yogurt = yogurt;
		this.rating = rating;
	}

	
	@Override
	public String toString() 
	{
		return "Rating [ratingID=" + ratingID + "\n\tevaluator=" + evaluator 
				+ "\n\tyogurt=" + yogurt + "\n\trating=" + rating + "]";
	}

	@Override
	public boolean equals(final Object object) 
	{
		if(object == null) return false;
		if(this == object) return true;
		
		if(this.getClass() != object.getClass())
			return false;
		
		Rating other = (Rating) object;
		return Objects.equals(this.ratingID, other.getID())
			&& Objects.equals(this.evaluator, other.getEvaluator())
			&& Objects.equals(this.yogurt, other.getYogurt())
			&& Objects.equals(this.rating, other.getRating());
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(this.ratingID, this.evaluator, this.yogurt, this.rating);
	}
	
	
	public void updateRating(final int rating) 
	{
		if(rating < 0 || rating > 5)
			throw new IllegalArgumentException();
		
		this.rating = rating;
	}

	public int getID() {return ratingID;}

	public User getEvaluator() {return evaluator;}

	public Yogurt getYogurt() {return yogurt;}

	public int getRating() {return rating;}
	
}
