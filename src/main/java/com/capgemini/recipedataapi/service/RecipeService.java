package com.capgemini.recipedataapi.service;

import java.util.List;

import com.capgemini.recipedataapi.dto.RecipeDTO;

public interface RecipeService {

	/**
	 * Get List of all Recipes which are present in database table.
	 * 
	 * @return List<Recipe>
	 */
	List<RecipeDTO> getRecipeList();

	/**
	 * Get single Recipe by passing recipe ID
	 * 
	 * @param id
	 * @return Recipe
	 */
	RecipeDTO getRecipeById(Long id);

	/**
	 * Save new Recipe details, ingredients with cooking instructions.
	 */
	void saveRecipeDetails(RecipeDTO recipeDto);

	/**
	 * Update existing Recipe details.
	 * @param recipe - All the details of recipe like name, type, vegetarian, etc..
	 * @param id - Recipe ID
	 * @return - Recipe Object updated.
	 */
	RecipeDTO updateRecipeDetails(RecipeDTO recipeDto, Long id);

	/**
	 * Delete existing Recipe details by passing recipe id.
	 * @param id - Recipe ID
	 */
	void deleteRecipe(Long id);
}
