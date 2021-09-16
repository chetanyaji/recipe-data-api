package com.capgemini.recipedataapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.recipedataapi.dto.RecipeDTO;
import com.capgemini.recipedataapi.service.RecipeService;

/**
 * This Controller having different methods to create, update, delete the Recipe.
 * @author chetasin
 *
 */

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	/**
	 * Get List of all Recipes which are present in database table.
	 * @return List<Recipe>
	 */
	@GetMapping("/")
	public List<RecipeDTO> getAllRecipe(){
		return recipeService.getRecipeList();
	}
	
	/**
	 * Get single Recipe by passing recipe ID
	 * @param id - Recipe id of the recipe
	 * @return Recipe object 
	 */
	@GetMapping("/{id}")
	public RecipeDTO getRecipe(@PathVariable Long id){
		return recipeService.getRecipeById(id);
	}
	
	/**
	 * Insert new Recipe details, ingredients with cooking instructions.
	 * @param recipe - All the details of recipe like name, type, vegetarian, etc..
	 */

	@PostMapping("/")
	public void insertRecipe(@Valid @RequestBody RecipeDTO recipeDto){
		recipeService.saveRecipeDetails(recipeDto);
	}
	
	/**
	 * Update existing Recipe details, ingredients with cooking instructions.
	 * @param recipe - All the details of recipe like name, type, vegetarian, etc..
	 * @param id - Recipe ID
	 * @return - Recipe Object updated.
	 */
	@PutMapping("/{id}")
	public RecipeDTO updateRecipe(@Valid @RequestBody RecipeDTO recipeDto, @PathVariable Long id) {
		return recipeService.updateRecipeDetails(recipeDto, id);
		
	}
	
	/**
	 * Delete existing Recipe details by passing recipe id.
	 * @param id - Recipe ID
	 * @return returns HTTP response as OK
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<RecipeDTO> deleteRecipe(@PathVariable Long id) {
		recipeService.deleteRecipe(id);
		return ResponseEntity.ok().build();
	}
	
}
