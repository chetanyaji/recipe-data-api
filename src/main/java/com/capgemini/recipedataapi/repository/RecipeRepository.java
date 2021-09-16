package com.capgemini.recipedataapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.recipedataapi.model.Recipe;

/**
 * This recipe repository interface containing transaction related methods.
 * 
 * @author chetasin
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
