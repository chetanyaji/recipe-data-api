package com.capgemini.recipedataapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.recipedataapi.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
