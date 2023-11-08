package s23.GameLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.GameLibrary.domain.Category;
import s23.GameLibrary.domain.CategoryRepository;
import s23.GameLibrary.domain.Game;
import s23.GameLibrary.domain.GameRepository;
import s23.GameLibrary.domain.User;
import s23.GameLibrary.domain.UserRepository;

@SpringBootApplication
public class GameLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GameRepository grepository,
			CategoryRepository crepository,
			UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Platforming"));
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("RPG"));
			crepository.save(new Category("Racing"));
			crepository.save(new Category("MMORPG"));
			
			
			grepository.save(new Game("Super Mario 64", "Nintendo 64", 1996,
					crepository.findByName("Platforming").get(0)));
			grepository.save(new Game("The Legend of Zelda: Ocarina of Time", "Nintendo 64", 1996,
					crepository.findByName("Adventure").get(0)));
			grepository.save(new Game("Super Mario Odyssey", "Nintendo Switch", 2017,
					crepository.findByName("Platforming").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user",
				"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin",
				"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
		};
	}

}
