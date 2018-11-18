package de.fh.albsig.dardan.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*create table Adresse(
		ID           int          primary key,
		Strasse      varchar2(64) not null,
		Hausnummer   varchar2(64) not null,
		Postleitzahl varchar2(64) not null,
		Wohnort      varchar2(64) not null
);*/

@Entity
@Table(name="Adresse")
public class Address implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = 8069872626311731090L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="AddressGenerator")
	@SequenceGenerator(name="AddressGenerator",
		sequenceName="AddressSequence", allocationSize=1)
	@Column(name="ID")
	private int addressID;

	@Column(name="Strasse", nullable=false)
	private String streetname;

	@Column(name="Hausnummer", nullable=false)
	private String streetnumber;

	@Column(name="Postleitzahl", nullable=false)
	private String postalcode;

	@Column(name="Wohnort", nullable=false)
	private String city;


	public Address() {}

	public Address(final String streetname, final String streetnumber,
				   final String postalcode, final String city)
	{
		this.streetname = streetname;
		this.streetnumber = streetnumber;
		this.postalcode = postalcode;
		this.city = city;
	}


	@Override
	public String toString()
	{
		return "Address [addressID=" + this.addressID + ", streetname=" + this.streetname
				+ ", streetnumber=" + this.streetnumber + ", postalcode=" + this.postalcode
				+ ", city=" + this.city + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if (object == null) return false;
		if (this == object) return true;

		if (this.getClass() != object.getClass())
			return false;

		final Address other = (Address) object;
		return Objects.equals(this.addressID, other.getID())
			&& Objects.equals(this.streetname, other.getStreetname())
			&& Objects.equals(this.streetnumber, other.getStreetnumber())
			&& Objects.equals(this.postalcode, other.getPostalcode())
			&& Objects.equals(this.city, other.getCity());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.addressID, this.streetname, this.streetnumber,
							this.postalcode, this.city);
	}


	@Override
	public Integer getID()
	{
		return this.addressID;
	}

	public String getStreetname()
	{
		return this.streetname;
	}

	public String getStreetnumber()
	{
		return this.streetnumber;
	}

	public String getPostalcode()
	{
		return this.postalcode;
	}

	public String getCity()
	{
		return this.city;
	}

}
