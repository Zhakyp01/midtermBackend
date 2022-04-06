package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.SchoolYearNotFoundException;
import com.alex.sms.model.SchoolYear;
import com.alex.sms.repository.SchoolYearRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class SchoolYearController.
 */
@Controller
@RequestMapping(path = "school_year")
public class SchoolYearController {
	
	/** The school year repository. */
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	/**
	 * School year index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String schoolYearIndex(Model model) {
        model.addAttribute("schoolYear", new SchoolYear());
        model.addAttribute("schoolYears", schoolYearRepository.findAll());
        return "school_year/dashboard";
    }
	
	/**
	 * Gets the school year.
	 *
	 * @param id the id
	 * @return the school year
	 * @throws SchoolYearNotFoundException the school year not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody SchoolYear getSchoolYear (@PathVariable(value = "id") Integer id)
			throws SchoolYearNotFoundException {
		SchoolYear s = schoolYearRepository.findById(id)
				.orElseThrow(() -> new SchoolYearNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all school years.
	 *
	 * @return the all school years
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<SchoolYear> getAllSchoolYears() {
		return schoolYearRepository.findAll();
	}

    /**
     * Creates the school year.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createSchoolYear(@ModelAttribute SchoolYear s) {
    	if(!schoolYearRepository.existsById(s.getId()))
    		schoolYearRepository.save(s);
        return "redirect:dashboard";
    }
	
	/**
	 * Delete school year.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteSchoolYear(@ModelAttribute SchoolYear s) {
		schoolYearRepository.delete(s);
        return "redirect:dashboard";
    }
}
