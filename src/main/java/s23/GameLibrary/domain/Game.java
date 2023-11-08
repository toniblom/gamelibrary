package s23.GameLibrary.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Size(min=2, max=250)
	private String name;
	
	@NotNull(message = "Console cannot be empty!")
	//@Size(min=2, max=250)
	private String console;
	
	@Min(1900)
	private int published;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	// Getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public int getPublished() {
		return published;
	}
	public void setPublished(int published) {
		this.published = published;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	// Constructors
	
	public Game(String name, String console, int published) {
		this.name = name;
		this.console = console;
		this.published = published;
	}
	
	public Game(String name, String console, int published, Category category) {
		this.name = name;
		this.console = console;
		this.published = published;
		this.category = category;
	}
	
	public Game() {}
	
	// toString
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", console=" + console + ", category=" + category + ", published="
				+ published + "]";
	}
	
	
}
