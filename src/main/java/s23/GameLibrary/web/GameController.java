package s23.GameLibrary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import s23.GameLibrary.domain.CategoryRepository;
import s23.GameLibrary.domain.Game;
import s23.GameLibrary.domain.GameRepository;

@Controller
public class GameController {
	
	@Autowired
	private GameRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	// Gamelist
	@RequestMapping(value={"/", "/gamelist"})
	public String gameList(Model model) {
		model.addAttribute("games", repository.findAll());
		return "gamelist";
	}
	
	// Delete game
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGame(@PathVariable("id") Long gameId, Model model) {
		repository.deleteById(gameId);
		return "redirect:../gamelist";
	}

	// Add game
	@PreAuthorize("hasAuthority('ADMIN')")
	//@RequestMapping(value = "/add")
	@GetMapping("/add")
	public String addGame(Model model) {
		model.addAttribute("game", new Game());
		model.addAttribute("categories", crepository.findAll());
		return "addgame";
	}
	
	//@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("game") Game game, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("game", game);
			model.addAttribute("categories", crepository.findAll());
			return "addgame";
		}
		repository.save(game);
		return "redirect:gamelist";
	}
	
	// Edit game
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}")
	public String editGame(@PathVariable("id") Long gameId, Model model) {
		model.addAttribute("game", repository.findById(gameId));
		model.addAttribute("categories", crepository.findAll());
		return "editgame";
	}
	
	// Login
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
}
