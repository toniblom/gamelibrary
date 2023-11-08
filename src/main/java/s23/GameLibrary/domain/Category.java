package s23.GameLibrary.domain;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryId;
	private String name;
	
	//@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Game> games;
	

	// Getters and Setters for category
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	// Constructors for category
	public Category(Long categoryId, String name, List<Game> games) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.games = games;
	}

	public Category(String name, List<Game> games) {
		super();
		this.name = name;
		this.games = games;
	}

	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {}	

}
