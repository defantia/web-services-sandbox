package org.ws.samples.jaxws.cxf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
@NamedQueries({
		@NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u"),
		@NamedQuery(name = User.FIND_BY_LOGIN, query = "SELECT u FROM User u where u.login = :login") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "findAll";
	public static final String FIND_BY_LOGIN = "findByLogin";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(length = 100, unique = true, nullable = false)
	private String login;
	@Column(length = 100)
	private String lastName;
	@Column(length = 100)
	private String firstName;

	public User() {
	}

	public User(String login, String lastName, String firstName) {
		this.login = login;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
