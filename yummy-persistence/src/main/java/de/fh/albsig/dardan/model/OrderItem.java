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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.fh.albsig.dardan.exception.InvalidArgumentException;

/*create table Bestellposition(
	    ID            int primary key,
	    Bestellung    int not null,
	    Yogurt        int not null,
	    Menge         int not null,
	    constraint checkMenge check(Menge > 0 and Menge <= 2000)
);*/

@Entity
@Table(name="Bestellposition")
public class OrderItem implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = -1351212675685818662L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="OrderItemGenerator")
	@SequenceGenerator(name="OrderItemGenerator",
		sequenceName="OrderItemGenerator", allocationSize=1)
	@Column(name="ID")
	private int orderItemID;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Bestellung", insertable=false, updatable=false)
	private Order order;

	@ManyToOne
	@JoinColumn(name="Yogurt", insertable=false, updatable=false)
	private Yogurt yogurt;

	@Column(name="Menge", nullable=false)
	private int amount;


	public OrderItem() {}

	public OrderItem(final Order order, final Yogurt yogurt, final int amount)
	{
		Objects.requireNonNull(order, "order is null");
		Objects.requireNonNull(yogurt, "yogurt is null");

		this.order = order;
		this.yogurt = yogurt;
		this.amount = amount;
	}


	@Override
	public String toString()
	{
		return "OrderItem [orderItemID=" + this.orderItemID + ", order=" + this.order
				+ ", yogurt=" + this.yogurt + ", amount=" + this.amount + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final OrderItem other = (OrderItem) object;
		return Objects.equals(this.orderItemID, other.getID())
				&& Objects.equals(this.order, other.getOrder())
				&& Objects.equals(this.yogurt, other.getYogurt());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.orderItemID, this.order, this.yogurt);
	}


	public void setAmount(final int amount)
		throws InvalidArgumentException
	{
		if(amount < 0 || amount > 2000)
			throw new InvalidArgumentException();

		this.amount = amount;
	}

	@Override
	public Integer getID()
	{
		return this.orderItemID;
	}

	public Order getOrder()
	{
		return this.order;
	}

	public Yogurt getYogurt()
	{
		return this.yogurt;
	}

	public int getAmount()
	{
		return this.amount;
	}

}
