package com.capgemini.recipedataapi.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.recipedataapi.dto.IngredientDTO;
import com.capgemini.recipedataapi.dto.RecipeDTO;
import com.capgemini.recipedataapi.exception.ResourceNotFoundException;
import com.capgemini.recipedataapi.model.Ingredient;
import com.capgemini.recipedataapi.model.Recipe;
import com.capgemini.recipedataapi.repository.RecipeRepository;

/**
 * This class contains Junit testcases for RecipeServiceImpl.java.
 * 
 * @author chetasin
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceTest{
	
	@InjectMocks
	private RecipeServiceImpl recipeService;

	@Mock
	private RecipeRepository recipeRepository;

	@Mock
	private ModelMapper modelMapper;
	
	List<Recipe> recipeList = null;
	List<Ingredient> ingredientList = null;
	List<IngredientDTO> ingredientDTOList = null;
	RecipeDTO recipeDTO = null;
	Recipe recipe = null;
	Ingredient ingredient1 = null;
	IngredientDTO ingredientDTO1 = null;
	
	@BeforeEach
	public void init() {
		ingredientList = new ArrayList<>();
		Ingredient ingredient1 = new Ingredient(Long.valueOf("2"), "SALT");
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(Long.valueOf("3"));
		ingredient2.setName("Chilly");
		ingredient2.getId();
		ingredient2.getName();
		ingredientList.add(ingredient1);
		ingredientList.add(ingredient2);
		recipe = new Recipe(Long.valueOf("1"), "Bergur", 10, "15-09-2021 11:55", true, ingredientList,
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper");
		Recipe recipe2 = new Recipe();
		recipe2.setCookingInstructions(
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper");
		recipe2.setCreationDateTime("15-09-2021 11:55");
		recipe2.setId(Long.valueOf("4"));
		recipe2.setIngredientList(ingredientList);
		recipe2.setIsVegetarian(true);
		recipe2.setName("Test Recipe");
		recipe2.setNumberOfPeople(12);
		recipe2.getCookingInstructions();
		recipe2.getCreationDateTime();
		recipe2.getId();
		recipe2.getIngredientList();
		recipe2.getIsVegetarian();
		recipe2.getName();
		recipe2.getNumberOfPeople();

		recipeList = new ArrayList<>();
		recipeList.add(recipe);
		recipeList.add(recipe2);
		
		ingredientDTOList = new ArrayList<>();
		ingredientDTO1 = new IngredientDTO(Long.valueOf("2"), "SALT");
		IngredientDTO ingredientDTO2 = new IngredientDTO();
		ingredientDTO2.setId(Long.valueOf("3"));
		ingredientDTO2.setName("Chilly");
		ingredientDTOList.add(ingredientDTO1);
		ingredientDTOList.add(ingredientDTO2);
		recipeDTO = new RecipeDTO(Long.valueOf("1"), "Bergur", 10, "15-09-2021 11:55", true,
				ingredientDTOList,
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper");
		recipeDTO.toString();
		ingredient1.toString();
		recipe.toString();
	}

	@Test
	public void getRecipeListTest() {
		when(recipeRepository.findAll()).thenReturn(recipeList);
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(recipeDTO);
		List<RecipeDTO> recipeDTOList = recipeService.getRecipeList();
		assertNotNull(recipeDTOList);
	}

	@Test
	public void getRecipeByIdTest() {
		Optional<Recipe> recipe = Optional.of(new Recipe(Long.valueOf("1"), "Bergur", 10, "15-09-2021 11:55", true, ingredientList,
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper"));
		when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipe);
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(recipeDTO);
		RecipeDTO recipeDTO = recipeService.getRecipeById(Long.valueOf("1"));
		assertNotNull(recipeDTO);
	}
	
//	@Test
//	public void getRecipeByIdResourceNotFoundExceptionTest() {
//		when(recipeRepository.findById(Mockito.anyLong())).thenThrow(ResourceNotFoundException.class);
//		assertThrows(ResourceNotFoundException.class, () -> {
//			recipeService.getRecipeById(Long.valueOf("1"));
//		});
//	}

	@Test
	public void saveRecipeDetailsTest() {
		when(modelMapper.map(Mockito.any(), Mockito.eq(Recipe.class))).thenReturn(recipe);
		recipeService.saveRecipeDetails(recipeDTO);
	}

	@Test
	public void updateRecipeDetailsTest() {
		Optional<Recipe> recipeOptional = Optional.of(new Recipe(Long.valueOf("1"), "Bergur", 10, "15-09-2021 11:55", true, ingredientList,
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper"));
		when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipeOptional);
		when(modelMapper.map(Mockito.any(), Mockito.eq(Ingredient.class))).thenReturn(ingredient1);
		when(recipeRepository.save(Mockito.any())).thenReturn(recipe);
		when(modelMapper.map(Mockito.any(), Mockito.eq(RecipeDTO.class))).thenReturn(recipeDTO);
		RecipeDTO recipeDTOActual = recipeService.updateRecipeDetails(recipeDTO, Long.valueOf("1"));
		assertNotNull(recipeDTOActual);
	}

	@Test
	public void deleteRecipeTest() {
		Optional<Recipe> recipe = Optional.of(new Recipe(Long.valueOf("1"), "Bergur", 10, "15-09-2021 11:55", true, ingredientList,
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper"));
		when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipe);
		recipeService.deleteRecipe(Long.valueOf("1"));
	}

}
