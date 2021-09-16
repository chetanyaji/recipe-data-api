package com.capgemini.recipedataapi.dto;

/**
 * This DTO class is containing ingredient related data members.
 * 
 * @author chetasin
 */
public class IngredientDTO {

	private Long id;
	private String name;

	/**
	 * Default constructor
	 */
	public IngredientDTO() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param name
	 */
	public IngredientDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IngredientDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
