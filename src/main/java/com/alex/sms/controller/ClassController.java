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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.ClassNotFoundException;
import com.alex.sms.model.Class;
import com.alex.sms.repository.ClassRepository;
import com.alex.sms.repository.LevelRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.SchoolRepository;
import com.alex.sms.repository.SchoolYearRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassController.
 */
@Controller
@RequestMapping(path="/class")
public class ClassController {
	
	/** The class repository. */
	@Autowired
	private ClassRepository classRepository;
	
	/** The school year repository. */
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	/** The school repository. */
	@Autowired
	private SchoolRepository schoolRepository;
	
	/** The level repository. */
	@Autowired
	private LevelRepository levelRepository;

	/** The registration repository. */
	@Autowired
	private RegistrationRepository registrationRepository;
	
	/**
	 * Class index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String classIndex(Model model) {
        model.addAttribute("class", new Class());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("levels", levelRepository.findAll());
        model.addAttribute("schoolYears", schoolYearRepository.findAll());
        return "class/dashboard";
    }
	
	/**
	 * Gets the class.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the class
	 * @throws ClassNotFoundException the class not found exception
	 */
	@GetMapping(path="/{id}")
	public String getClass (@PathVariable(value = "id") Integer id, Model model)
			throws ClassNotFoundException {
		Class s = classRepository.findById(id)
				.orElseThrow(() -> new ClassNotFoundException());
        model.addAttribute("class", s);
        model.addAttribute("registrations", registrationRepository.findByCId(id));
		return "class/view";
	}
	
	/**
	 * Gets all classes.
	 *
	 * @return all classes
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Class> getAllClasses() {
		return classRepository.findAll();
	}
	
	/**
	 * Search class.
	 *
	 * @param q the q
	 * @param model the model
	 * @return the string
	 * @throws ClassNotFoundException the class not found exception
	 */
	@GetMapping(path="/search")
	public String searchClass (@RequestParam(value = "search", required = false) String q, Model model)
			throws ClassNotFoundException {
		Iterable<Class> classes = classRepository.findByNameContaining(q);
        model.addAttribute("classes", classes);
		return "class/result";
	}

    /**
     * Creates the class.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createClass(@ModelAttribute Class s) {
		classRepository.save(s);
        return "redirect:dashboard";
    }
    
    /**
     * View update form class.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws ClassNotFoundException the class not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormClass(@PathVariable(value = "id") Integer id,
			Model model) throws ClassNotFoundException {
    	Class s = classRepository.findById(id)
				.orElseThrow(() -> new ClassNotFoundException());
    	model.addAttribute("class", s);
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("levels", levelRepository.findAll());
        model.addAttribute("schoolYears", schoolYearRepository.findAll());
		return "class/edit";
	}
	
	/**
	 * Update class.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateClass(@ModelAttribute Class s) {
		classRepository.save(s);
		return "redirect:/class/dashboard";
    }
	
	/**
	 * Delete class.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteClass(@ModelAttribute Class s) {
		classRepository.delete(s);
        return "redirect:dashboard";
    }
}
