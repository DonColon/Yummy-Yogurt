package de.fh.albsig.dardan.persistence.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.fh.albsig.dardan.persistence.exception.InvalidArgumentException;

/*create table Bestellung(
	    ID           int            primary key,
	    Besteller    int            not null,
	    Gesamtpreis  int            not null,
	    Zahlungsart  varchar2(32)   not null,
	    Bestelldatum timestamp      not null,

	    constraint checkGesamtpreis check(Gesamtpreis > 0),
	    constraint checkZahlungsart check(Zahlungsart in(
	        'PayPal', 'Amazon-Pay', 'Apple-Pay', 'Stripe',
	        'American-Express', 'JCB', 'Visa', 'Mastercard'
	    ))
);*/

@Entity
@Table(name="Bestellung")
public class Order implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = 7115000964015464892L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="OrderGenerator")
	@SequenceGenerator(name="OrderGenerator",
		sequenceName="OrderSequence", allocationSize=1)
	@Column(name="ID")
	private int orderID;

	@ManyToOne
	@JoinColumn(name="Besteller", nullable=false)
	private User purchaser;

	@Column(name="Gesamtpreis", nullable=false)
	private int totalPrice;

	@Column(name="Zahlungsart", nullable=false)
	private String paymentMethod;

	@Column(name="Bestelldatum", nullable=false)
	private LocalDateTime orderdate;

	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Bestellung", insertable=false, updatable=false)
	private List<OrderItem> items;


	public Order() {}

	public Order(final User purchaser, final int totalPrice, final String paymentMethod)
	{
		Objects.requireNonNull(purchaser, "purchaser is null");

		this.purchaser = purchaser;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
		this.orderdate = LocalDateTime.now();
		this.items = new ArrayList<>();
	}

	@Override
	public String toString()
	{
		return "Order [orderID=" + this.orderID + ", purchaser=" + this.purchaser
				+ ", totalPrice=" + this.totalPrice + ", paymentMethod=" + this.paymentMethod
				+ ", orderdate=" + this.orderdate + "]";
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
			&& Objects.equals(this.orderdate, other.getOrderdate());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.orderID, this.purchaser, this.orderdate);
	}


	public void addItem(final OrderItem item)
		throws InvalidArgumentException
	{
		if(item == null)
			throw new InvalidArgumentException();

		this.items.add(item);
	}

	@Override
	public Integer getID()
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

	public String getPaymentMethod()
	{
		return this.paymentMethod;
	}

	public LocalDateTime getOrderdate()
	{
		return this.orderdate;
	}

	public List<OrderItem> getItems()
	{
		return Collections.unmodifiableList(this.items);
	}

}
