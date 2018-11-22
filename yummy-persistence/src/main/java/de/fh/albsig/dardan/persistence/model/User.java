package de.fh.albsig.dardan.persistence.model;

import java.io.Serializable;
import java.time.LocalDate;
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

import de.fh.albsig.dardan.persistence.exception.InvalidArgumentException;

/*create table Benutzer(
	    ID              int            primary key,
	    Vorname         varchar2(64)   not null,
	    Nachname        varchar2(64)   not null,
	    Benutzername    varchar2(64)   unique not null,
	    Email           varchar2(64)   unique not null,
	    Passwort        varchar2(1024) not null,
	    Geburtsdatum    date           not null,
	    Beitrittsdatum  date           not null,
	    Adresse         int            not null,
	    constraint checkDatum check(Geburtsdatum < Beitrittsdatum)
);*/

@Entity
@Table(name="Benutzer")
public class User implements Serializable, Identifiable<Integer>
{

	private static final long serialVersionUID = 995219797856210395L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
		generator="UserGenerator")
	@SequenceGenerator(name="UserGenerator",
		sequenceName="UserSequence", allocationSize=1)
	@Column(name="ID")
	private int userID;

	@Column(name="Vorname", nullable=false)
	private String firstname;

	@Column(name="Nachname", nullable=false)
	private String familyname;

	@Column(name="Benutzername", unique=true, nullable=false)
	private String username;

	@Column(name="Email", unique=true, nullable=false)
	private String email;

	@Column(name="Passwort", nullable=false)
	private String password;

	@Column(name="Geburtsdatum", nullable=false)
	private LocalDate birthday;

	@Column(name="Beitrittsdatum", nullable=false)
	private LocalDate accessiondate;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="Adresse", nullable=false)
	private Address address;


	public User() {}

	public User(final String firstname, final String familyname, final String username, final String email,
				final String password, final String birthday, final Address address)
	{
		Objects.requireNonNull(address, "address is null");

		this.firstname = firstname;
		this.familyname = familyname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.birthday = LocalDate.parse(birthday);
		this.accessiondate = LocalDate.now();
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "User [userID=" + this.userID + ", firstname=" + this.firstname + ", familyname=" + this.familyname
				+ ", username=" + this.username + ", email=" + this.email + ", password=" + this.password
				+ ", birthday=" + this.birthday + ", accessiondate=" + this.accessiondate
				+ ", address=" + this.address + "]";
	}

	@Override
	public boolean equals(final Object object)
	{
		if(object == null) return false;
		if(this == object) return true;

		if(this.getClass() != object.getClass())
			return false;

		final User other = (User) object;
		return Objects.equals(this.userID, other.getID())
			&& Objects.equals(this.accessiondate, other.getAccessiondate());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.userID, this.accessiondate);
	}


	public void setFirstname(final String firstname)
		throws InvalidArgumentException
	{
		if(firstname.isEmpty() || firstname == null)
			throw new InvalidArgumentException();

		this.firstname = firstname;
	}

	public void setFamilyname(final String familyname)
		throws InvalidArgumentException
	{
		if(familyname.isEmpty() || familyname == null)
			throw new InvalidArgumentException();

		this.familyname = familyname;
	}

	public void setUsername(final String username)
		throws InvalidArgumentException
	{
		if(username.isEmpty() || username == null)
			throw new InvalidArgumentException();

		this.username = username;
	}

	public void setEmail(final String email)
		throws InvalidArgumentException
	{
		if(email.isEmpty() || email == null)
			throw new InvalidArgumentException();

		this.email = email;
	}

	public void setPassword(final String password)
		throws InvalidArgumentException
	{
		if(password.isEmpty() || password == null)
			throw new InvalidArgumentException();

		this.password = password;
	}

	public void setAddress(final Address address)
		throws InvalidArgumentException
	{
		if(address == null)
			throw new InvalidArgumentException();

		this.address = address;
	}

	@Override
	public Integer getID()
	{
		return this.userID;
	}

	public String getFirstname()
	{
		return this.firstname;
	}

	public String getFamilyname()
	{
		return this.familyname;
	}

	public String getUsername()
	{
		return this.username;
	}

	public String getEmail()
	{
		return this.email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	public LocalDate getAccessiondate()
	{
		return this.accessiondate;
	}

	public Address getAddress()
	{
		return this.address;
	}

}
