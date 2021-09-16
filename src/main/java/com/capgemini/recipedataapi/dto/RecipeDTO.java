package com.capgemini.recipedataapi.dto;

import java.util.List;

public class RecipeDTO {

	private Long id;
	private String name;
	private Integer numberOfPeople;
	private String creationDateTime;
	private Boolean isVegetarian;
	private List<IngredientDTO> ingredientList;
	private String cookingInstructions;

	public RecipeDTO() {
	}

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

	public Integer getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(Integer numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public Boolean getIsVegetarian() {
		return isVegetarian;
	}

	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public List<IngredientDTO> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<IngredientDTO> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public String getCookingInstructions() {
		return cookingInstructions;
	}

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
