package de.fh.albsig.dardan.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public final class OrderItemID implements Serializable
{

	private static final long serialVersionUID = 6057115042508716061L;


	@Column(name="BestellungID", nullable=false)
	private int orderID;

	@Column(name="YogurtID", nullable=false)
	private int yogurtID;


	public OrderItemID() {}

	public OrderItemID(final int orderID, final int yogurtID)
	{
		this.orderID = orderID;
		this.yogurtID = yogurtID;
	}


	@Override
	public String toString()
	{
		return "OrderItemID [orderID=" + this.orderID + ", yogurtID=" + this.yogurtID + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final OrderItemID other = (OrderItemID) object;
		return Objects.equals(this.orderID, other.getOrderID())
				&& Objects.equals(this.yogurtID, other.getYogurtID());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.orderID, this.yogurtID);
	}


	public int getOrderID()
	{
		return this.orderID;
	}

	public int getYogurtID()
	{
		return this.yogurtID;
	}

}
