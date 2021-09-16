package com.capgemini.recipedataapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger logger = LogManager.getLogger(RecipeServiceImpl.class);

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RecipeDTO> getRecipeList() {
		logger.debug("Invoke getRecipeList() method.");
		List<Recipe> recipeList = recipeRepository.findAll();
		List<RecipeDTO> recipeDTOList = recipeList.stream().map(recipe -> modelMapper.map(recipe, RecipeDTO.class))
				.collect(Collectors.toList());
		logger.debug("Exit getAllRecipe() method with data RecipeDTO:{}", () -> recipeDTOList);
		return recipeDTOList;
	}

	@Override
	public RecipeDTO getRecipeById(Long id) {
		logger.debug("Invoke getRecipeById() method with ID:{} ", () -> id);
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		logger.debug("Exit getRecipeById() method with data Recipe:{}", () -> recipe);
		return modelMapper.map(recipe, RecipeDTO.class);
	}

	@Override
	public void saveRecipeDetails(RecipeDTO recipeDto) {
		logger.debug("Invoke saveRecipeDetails() method with RecipeDTO:{} ", () -> recipeDto);
		Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
		recipe.setCreationDateTime(DateTimeLocal.getLocalDateTime());
		recipeRepository.save(recipe);
		logger.debug("Exit saveRecipeDetails() method.");
	}

	@Override
	public RecipeDTO updateRecipeDetails(RecipeDTO recipeDto, Long id) {
		logger.debug("Invoke updateRecipeDetails() method with RecipeDTO:{} and ID:{} ", () -> recipeDto, () -> id);
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
		logger.debug("Exit updateRecipeDetails() method with Recipe:{}", () -> recipe);
		return modelMapper.map(recipe, RecipeDTO.class);
	}

	@Override
	public void deleteRecipe(Long id) {
		logger.debug("Invoke deleteRecipe() method with ID:{} ", () -> id);
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Record Found With Given ID: " + id));
		recipeRepository.delete(recipe);
		logger.debug("Exit deleteRecipe() method.");
	}

}
