package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.LevelNotFoundException;
import com.alex.sms.model.Level;
import com.alex.sms.repository.LevelRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class LevelController.
 */
@Controller
@RequestMapping(path="/level")
public class LevelController {
	
	/** The level repository. */
	@Autowired
	private LevelRepository levelRepository;
	
	/**
	 * Level index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String levelIndex(Model model) {
        model.addAttribute("level", new Level());
        model.addAttribute("levels", levelRepository.findAll());
        return "level/dashboard";
    }
	
	/**
	 * Gets the level.
	 *
	 * @param id the id
	 * @return the level
	 * @throws LevelNotFoundException the level not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Level getLevel (@PathVariable(value = "id") Integer id)
			throws LevelNotFoundException {
		Level s = levelRepository.findById(id)
				.orElseThrow(() -> new LevelNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all levels.
	 *
	 * @return the all levels
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Level> getAllLevels() {
		return levelRepository.findAll();
	}

    /**
     * Creates the level.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createLevel(@ModelAttribute Level s) {
		levelRepository.save(s);
        return "redirect:dashboard";
    }
    
    /**
     * View update form level.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws LevelNotFoundException the level not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormLevel(@PathVariable(value = "id") Integer id,
			Model model) throws LevelNotFoundException {
    	model.addAttribute("level", this.getLevel(id));
		return "level/edit";
	}
	
	/**
	 * Update level.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateLevel(@ModelAttribute Level s) {
		levelRepository.save(s);
		return "redirect:/level/dashboard";
    }
	
	/**
	 * Delete level.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteLevel(@ModelAttribute Level s) {
		levelRepository.delete(s);
        return "redirect:dashboard";
    }
}
