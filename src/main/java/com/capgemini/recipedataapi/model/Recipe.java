package com.capgemini.recipedataapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * This Entity class containing Recipe related data members.
 * 
 * @author chetasin
 */
@Entity
@Table(name = "recipe")
public class Recipe implements Serializable {

	/**
	 * This is serial version UID for serialized class
	 */
	private static final long serialVersionUID = 8227353088497642566L;

	@Id
	@GeneratedValue(generator = "recipe_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq", initialValue = 1, allocationSize = 1)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 50, message = "Recipe name should not be less than 5 and more than 50 character.")
	@Column(name = "name")
	private String name;

	@Min(value = 1, message = "Number of people should be minimum 1 person")
	@Column(name = "number_of_people")
	private Integer numberOfPeople;

	@DateTimeFormat(pattern = "dd‐MM‐yyyy HH:mm")
	@Column(name = "creation_date_time")
	private String creationDateTime;

	@Column(name = "is_vegetarian")
	private Boolean isVegetarian;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id", nullable = false)
	private List<Ingredient> ingredientList;

	@NotNull
	@NotBlank
	@Column(name = "cooking_instructions")
	private String cookingInstructions;

	/**
	 * Default constructor
	 */
	public Recipe() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param name
	 * @param numberOfPeople
	 * @param creationDateTime
	 * @param isVegetarian
	 * @param ingredientList
	 * @param cookingInstructions
	 */
	public Recipe(Long id,
			@NotNull @NotBlank @Size(min = 5, max = 50, message = "Recipe name should not be less than 5 and more than 50 character.") String name,
			@Min(value = 1, message = "Number of people should be minimum 1 person") Integer numberOfPeople,
			String creationDateTime, Boolean isVegetarian, @NotNull @NotBlank List<Ingredient> ingredientList,
			@NotNull @NotBlank String cookingInstructions) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.creationDateTime = creationDateTime;
		this.isVegetarian = isVegetarian;
		this.ingredientList = ingredientList;
		this.cookingInstructions = cookingInstructions;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the numberOfPeople
	 */
	public Integer getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * @param numberOfPeople the numberOfPeople to set
	 */
	public void setNumberOfPeople(Integer numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * @return the creationDateTime
	 */
	public String getCreationDateTime() {
		return creationDateTime;
	}

	/**
	 * @param creationDateTime the creationDateTime to set
	 */
	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	/**
	 * @return the isVegetarian
	 */
	public Boolean getIsVegetarian() {
		return isVegetarian;
	}

	/**
	 * @param isVegetarian the isVegetarian to set
	 */
	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	/**
	 * @return the ingredientList
	 */
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	/**
	 * @param ingredientList the ingredientList to set
	 */
	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	/**
	 * @return the cookingInstructions
	 */
	public String getCookingInstructions() {
		return cookingInstructions;
	}

	/**
	 * @param cookingInstructions the cookingInstructions to set
	 */
	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recipe [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", numberOfPeople=");
		builder.append(numberOfPeople);
		builder.append(", creationDateTime=");
		builder.append(creationDateTime);
		builder.append(", isVegetarian=");
		builder.append(isVegetarian);
		builder.append(", ingredientList=");
		builder.append(ingredientList);
		builder.append(", cookingInstructions=");
		builder.append(cookingInstructions);
		builder.append("]");
		return builder.toString();
	}

}
