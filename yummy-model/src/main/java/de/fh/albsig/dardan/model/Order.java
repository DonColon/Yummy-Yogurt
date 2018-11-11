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
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Bestellung(
	    ID           int  primary key,
	    BenutzerID   int  not null,
	    Gesamtpreis  int  not null,
	    Bestelldatum timestamp not null,
	    constraint checkGesamtpreis check(Gesamtpreis > 0)
);*/

@Entity
@Table(name="Bestellung")
@NamedQuery(name="Order.listAll", query="select o from Order o")
public final class Order implements Serializable
{

	private static final long serialVersionUID = 1019596392287525485L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OrderGenerator")
	@SequenceGenerator(name="OrderGenerator",
	sequenceName="OrderSequence", allocationSize=1)
	@Column(name="ID")
	private int orderID;

	@ManyToOne
	@JoinColumn(name="BenutzerID", nullable=false)
	private User purchaser;

	@Column(name="Gesamtpreis", nullable=false)
	private int totalPrice;

	@Column(name="Bestelldatum", nullable=false)
	private LocalDateTime orderdate;


	public Order() {}

	public Order(final User purchaser, final int totalPrice)
	{
		Objects.requireNonNull(purchaser, "purchaser is null");

		this.purchaser = purchaser;
		this.totalPrice = totalPrice;
		this.orderdate = LocalDateTime.now();
	}


	@Override
	public String toString()
	{
		return "Order [orderID=" + this.orderID + ", user=" + this.purchaser
				+ ", totalPrice=" + this.totalPrice + ", orderdate=" + this.orderdate + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final Order other = (Order) object;
		return Objects.equals(this.orderID, other.getID())
				&& Objects.equals(this.purchaser, other.getPurchaser())
				&& Objects.equals(this.totalPrice, other.getTotalPrice())
				&& Objects.equals(this.orderdate, other.getOrderdate());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.orderID, this.purchaser, this.totalPrice, this.orderdate);
	}


	public int getID()
	{
		return this.orderID;
	}

	public User getPurchaser()
	{
		return this.purchaser;
	}

	public int getTotalPrice()
	{
		return this.totalPrice;
	}

	public LocalDateTime getOrderdate()
	{
		return this.orderdate;
	}

}
