package de.fh.albsig.dardan.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Bewertung(
	    ID          int primary key,
	    Bewerter    int not null,
	    Yogurt      int not null,
	    Wertung     int not null,
	    Nachricht        varchar2(255) not null,
	    Bewertungsdatum  timestamp     not null,
	    constraint checkWertung check(Wertung >= 1 and Wertung <= 5)
);*/

@Entity
@Table(name="Bewertung")
public class Rating implements Serializable
{

	private static final long serialVersionUID = -4181145249740327005L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="RatingGenerator")
	@SequenceGenerator(name="RatingGenerator",
		sequenceName="RatingSequence", allocationSize=1)
	@Column(name="ID")
	private int ratingID;

	@ManyToOne
	@JoinColumn(name="Bewerter", insertable=false, updatable=false)
	private User evaluator;

	@ManyToOne
	@JoinColumn(name="Yogurt", insertable=false, updatable=false)
	private Yogurt yogurt;

	@Column(name="Wertung", nullable=false)
	private int rating;

	@Column(name="Nachricht", nullable=false)
	private String message;

	@Column(name="Bewertungsdatum", nullable=false)
	private LocalDateTime evaluationdate;


	public Rating() {}

	public Rating(final User evaluator, final Yogurt yogurt,
			      final int rating, final String message)
	{
		Objects.requireNonNull(evaluator, "evaluator is null");
		Objects.requireNonNull(yogurt, "yogurt is null");

		this.evaluator = evaluator;
		this.yogurt = yogurt;
		this.rating = rating;
		this.message = message;
		this.evaluationdate = LocalDateTime.now();
	}


	@Override
	public String toString()
	{
		return "Rating [ratingID=" + this.ratingID
				+ ", evaluator=" + this.evaluator + ", yogurt=" + this.yogurt
				+ ", rating=" + this.rating + ", message=" + this.message
				+ ", evaluationDate=" + this.evaluationdate + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Rating other = (Rating) object;
		return Objects.equals(this.ratingID, other.getID())
			&& Objects.equals(this.evaluator, other.getEvaluator())
			&& Objects.equals(this.yogurt, other.getYogurt())
			&& Objects.equals(this.rating, other.getRating())
			&& Objects.equals(this.message, other.getMessage())
			&& Objects.equals(this.evaluationdate, other.getEvaluationdate());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.ratingID, this.evaluator, this.yogurt,
							this.rating, this.message, this.evaluationdate);
	}


	public int getID()
	{
		return this.ratingID;
	}

	public User getEvaluator()
	{
		return this.evaluator;
	}

	public Yogurt getYogurt()
	{
		return this.yogurt;
	}

	public int getRating()
	{
		return this.rating;
	}

	public String getMessage()
	{
		return this.message;
	}

	public LocalDateTime getEvaluationdate()
	{
		return this.evaluationdate;
	}

}
