# recipe-data-api
This Project recipe-data-api is for recipe management and its ingredient

It is a spring boot application, in which CRUD operations will be done using Rest Api's for Recipes.


•For getting all the recipe details from the table.

•URL : http://localhost:8090/recipe/

•Method : GET




•For getting single recipe  record by id.

•URL : http://localhost:8090/recipe/9

•Method : GET




•For CREATE new recipe details.

•URL : http://localhost:8090/recipe/

•Method : POST

•Body: 

{
    
    "name": "Paneer Kolahpuri Extra chilly",
    
    "numberOfPeople": 5,
    
    "isVegetarian": true,
    
    "ingredientList": [
    
        {
        
            "name": "Salt"
            
        },
        
        {
        
            "name": "Chilly"
            
        },
        
        {
        
            "name": "Dry Ginger"
            
        },
        
        {
        
            "name": "Black Papper"
            
        },
        
        {
        
            "name": "Garlic"
            
        }
        
    ],
    
    "cookingInstructions": "Fry Paneer, Make grevy, Add Paneer in Gravy"
    
}


•For UPDATE an existing recipe details.

•URL : http://localhost:8090/recipe/12

•Method : PUT

•Body: 

{
    
    "name": "Rajma Rice With Butter",
    
    "numberOfPeople": 17,
    
    "isVegetarian": true,
    
    "ingredientList": [
    
        {
        
            "name": "Salt"
            
        },
        
        {
        
            "name": "Chilly"
            
        },
        
        {
        
            "name": "Dry Ginger"
            
        },
        
        {
        
            "name": "Black Papper"
            
        },
        
        {
        
            "name": "Garlic"
            
        },
        
        {
        
            "name": "Tejpaat Leaf"
            
        },
        
        {
        
            "name":"Butter"
            
        }
        
    ],
    
    "cookingInstructions": "Boil Rajma, Make Greavy, Add Rajma, Add Spices"
    
}


•For DELETE a existing recipe details.

•URL : http://localhost:8090/recipe/12

•Method : DELETE

