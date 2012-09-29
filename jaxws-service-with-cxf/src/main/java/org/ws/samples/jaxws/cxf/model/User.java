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
		@NamedQuery(name = User.FIND_BY_NAME, query = "SELECT u FROM User u where u.name = :name") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "findAll";
	public static final String FIND_BY_NAME = "findByName";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(length = 100)
	private String surname;
	@Column(length = 100, nullable = false)
	private String name;

	public User() {
	}

	public User(String surname, String name) {
		this.surname = surname;
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
