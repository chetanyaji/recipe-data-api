package com.capgemini.recipedataapi.dto;

import java.util.List;

/**
 * This DTO class containing Recipe related data members.
 * 
 * @author chetasin
 */
public class RecipeDTO {

	private Long id;
	private String name;
	private Integer numberOfPeople;
	private String creationDateTime;
	private Boolean isVegetarian;
	private List<IngredientDTO> ingredientList;
	private String cookingInstructions;

	/**
	 * Default constructor
	 */
	public RecipeDTO() {
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
	public RecipeDTO(Long id, String name, Integer numberOfPeople, String creationDateTime, Boolean isVegetarian,
			List<IngredientDTO> ingredientList, String cookingInstructions) {
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
	public List<IngredientDTO> getIngredientList() {
		return ingredientList;
	}

	/**
	 * @param ingredientList the ingredientList to set
	 */
	public void setIngredientList(List<IngredientDTO> ingredientList) {
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
		builder.append("RecipeDTO [id=");
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
