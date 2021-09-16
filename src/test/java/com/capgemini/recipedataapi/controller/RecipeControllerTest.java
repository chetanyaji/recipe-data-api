package com.capgemini.recipedataapi.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.recipedataapi.dto.IngredientDTO;
import com.capgemini.recipedataapi.dto.RecipeDTO;
import com.capgemini.recipedataapi.service.RecipeService;
import com.capgemini.recipedataapi.util.DateTimeLocal;

/**
 * This test class contains RecipeController Junit test cases.
 * 
 * @author chetasin
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeControllerTest {

	@InjectMocks
	private RecipeController recipeController;

	@Mock
	private RecipeService recipeService;
	
	List<RecipeDTO> recipeDTOList = null;
	RecipeDTO recipeDTO1 = null;
	
	@BeforeEach
	public void init() {
		List<IngredientDTO> ingredientDTOList = new ArrayList<>();
		IngredientDTO ingredientDTO1 = new IngredientDTO(Long.valueOf("2"), "SALT");
		IngredientDTO ingredientDTO2 = new IngredientDTO();
		ingredientDTO2.setId(Long.valueOf("3"));
		ingredientDTO2.setName("Chilly");
		ingredientDTO2.getId();
		ingredientDTO2.getName();
		ingredientDTOList.add(ingredientDTO1);
		ingredientDTOList.add(ingredientDTO2);
		recipeDTO1 = new RecipeDTO(Long.valueOf("1"), "Bergur", 10, "15-09-2021 11:55", true,
				ingredientDTOList,
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper");
		RecipeDTO recipeDTO2 = new RecipeDTO();
		recipeDTO2.setCookingInstructions(
				"Took black Urad dal, Make Oil, Prepair base material with ginger garlic paste,Put dal, Put Makkhan, Coriender, Coriender leaf, Black papper");
		recipeDTO2.setCreationDateTime("15-09-2021 11:55");
		recipeDTO2.setId(Long.valueOf("4"));
		recipeDTO2.setIngredientList(ingredientDTOList);
		recipeDTO2.setIsVegetarian(true);
		recipeDTO2.setName("Test Recipe");
		recipeDTO2.setNumberOfPeople(12);
		recipeDTO2.getCookingInstructions();
		recipeDTO2.getCreationDateTime();
		recipeDTO2.getId();
		recipeDTO2.getIngredientList();
		recipeDTO2.getIsVegetarian();
		recipeDTO2.getName();
		recipeDTO2.getNumberOfPeople();

		recipeDTOList = new ArrayList<>();
		recipeDTOList.add(recipeDTO1);
		recipeDTOList.add(recipeDTO2);
		new DateTimeLocal(); 
	}

	@Test
	public void getAllRecipeTest() {
		when(recipeService.getRecipeList()).thenReturn(recipeDTOList);
		List<RecipeDTO> recipeDTOListActual = recipeController.getAllRecipe();
		recipeDTOListActual.toString();
		assertNotNull(recipeDTOListActual);
	}

	@Test
	public void getRecipeTest() {
		when(recipeService.getRecipeById(Mockito.anyLong())).thenReturn(recipeDTO1);
		RecipeDTO recipeDTOActual = recipeController.getRecipe(Long.valueOf("1"));
		assertNotNull(recipeDTOActual);
	}

	@Test
	public void insertRecipeTest() {
		recipeController.insertRecipe(recipeDTO1);
	}

	@Test
	public void updateRecipeTest() {
		when(recipeService.updateRecipeDetails(Mockito.any(), Mockito.anyLong())).thenReturn(recipeDTO1);
		RecipeDTO recipeDTOActual = recipeController.updateRecipe(recipeDTO1, Long.valueOf("1"));
		assertNotNull(recipeDTOActual);
	}

	@Test
	public void deleteRecipeTest() {
		recipeController.deleteRecipe(Long.valueOf("1"));
	}
}
