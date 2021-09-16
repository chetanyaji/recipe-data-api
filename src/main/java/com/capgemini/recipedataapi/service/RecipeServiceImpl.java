package com.capgemini.recipedataapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.recipedataapi.dto.RecipeDTO;
import com.capgemini.recipedataapi.exception.ResourceNotFoundException;
import com.capgemini.recipedataapi.model.Ingredient;
import com.capgemini.recipedataapi.model.Recipe;
import com.capgemini.recipedataapi.repository.RecipeRepository;
import com.capgemini.recipedataapi.util.DateTimeLocal;

/**
 * This class contains all business logic related methods applied on Recipe.
 * 
 * @author chetasin
 *
 */

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RecipeDTO> getRecipeList() {
		List<Recipe> recipeList = recipeRepository.findAll();
		List<RecipeDTO> recipeDTOList = recipeList.stream().map(recipe -> modelMapper.map(recipe, RecipeDTO.class))
				.collect(Collectors.toList());
		return recipeDTOList;
	}

	@Override
	public RecipeDTO getRecipeById(Long id) {
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		return modelMapper.map(recipe, RecipeDTO.class);
	}

	@Override
	public void saveRecipeDetails(RecipeDTO recipeDto) {
		Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
		recipe.setCreationDateTime(DateTimeLocal.getLocalDateTime());
		recipeRepository.save(recipe);
	}

	@Override
	public RecipeDTO updateRecipeDetails(RecipeDTO recipeDto, Long id) {
		Recipe existingRecipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		existingRecipe.setCookingInstructions(recipeDto.getCookingInstructions());
		existingRecipe.setCreationDateTime(DateTimeLocal.getLocalDateTime());
		List<Ingredient> ingredientList = recipeDto.getIngredientList().stream()
				.map(ingredientDto -> modelMapper.map(ingredientDto, Ingredient.class)).collect(Collectors.toList());
		existingRecipe.setIngredientList(ingredientList);
		existingRecipe.setIsVegetarian(recipeDto.getIsVegetarian());
		existingRecipe.setNumberOfPeople(recipeDto.getNumberOfPeople());
		existingRecipe.setName(recipeDto.getName());
		Recipe recipe = recipeRepository.save(existingRecipe);
		return modelMapper.map(recipe, RecipeDTO.class);
	}

	@Override
	public void deleteRecipe(Long id) {
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		recipeRepository.delete(recipe);
	}

}
