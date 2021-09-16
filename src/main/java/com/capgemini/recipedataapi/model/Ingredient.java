package com.capgemini.recipedataapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

	/**
	 * This is serial version UID for serialized class
	 */
	private static final long serialVersionUID = -5661909867996399369L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
	@SequenceGenerator(name = "ingredient_seq", sequenceName = "ingredient_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 4, message = "Ingredient name should not be less than 4 characters")
	@Column(name = "name")
	private String name;

	public Ingredient() {
	}

	public Ingredient(Long id,
			@NotNull @NotBlank @Size(min = 4, message = "Ingredient name should not be less than 4 characters") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
