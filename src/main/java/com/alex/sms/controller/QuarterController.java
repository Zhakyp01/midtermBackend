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

import com.alex.sms.exception.QuarterNotFoundException;
import com.alex.sms.exception.SchoolYearNotFoundException;
import com.alex.sms.model.Quarter;
import com.alex.sms.model.SchoolYear;
import com.alex.sms.repository.QuarterRepository;
import com.alex.sms.repository.SchoolYearRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class QuarterController.
 */
@Controller
@RequestMapping(path="/quarter")
public class QuarterController {
	
	/** The quarter repository. */
	@Autowired
	private QuarterRepository quarterRepository;
	
	/** The school year repository. */
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	/**
	 * Quarter index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping(path="/dashboard")
	public String quarterIndex(Model model) {
		model.addAttribute("quarter", new Quarter());
		model.addAttribute("quarters", quarterRepository.findAll());
		return "quarter/dashboard";
	}

	/**
	 * Gets the quarter.
	 *
	 * @param id the id
	 * @return the quarter
	 * @throws QuarterNotFoundException the quarter not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Quarter getQuarter (@PathVariable(value = "id") Integer id)
			throws QuarterNotFoundException {
		Quarter q = quarterRepository.findById(id)
				.orElseThrow(() -> new QuarterNotFoundException());
		return q;
	}

	/**
	 * Gets the all quarters.
	 *
	 * @return the all quarters
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Quarter> getAllQuarters() {
		return quarterRepository.findAll();
	}
	
	/**
	 * Creates the quarter.
	 *
	 * @param q the q
	 * @return the string
	 */
	@PostMapping(path="/create")
	public String createQuarter (@ModelAttribute Quarter q) {
		try {
			schoolYearRepository.findById(q.getSchoolYear().getId())
					.orElseThrow(() -> new SchoolYearNotFoundException());
		} catch (SchoolYearNotFoundException e) {
			SchoolYear schoolYear = new SchoolYear(q.getSchoolYear().getId());
			schoolYearRepository.save(schoolYear);
		}
		quarterRepository.save(q);
		return "redirect:dashboard";
	}
	
	/**
	 * View update form quarter.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 * @throws QuarterNotFoundException the quarter not found exception
	 */
	@GetMapping(path="/{id}/edit")
	public String viewUpdateFormQuarter(@PathVariable(value = "id") Integer id,
			Model model) throws QuarterNotFoundException {
    	model.addAttribute("quarter", this.getQuarter(id));
		return "quarter/edit";
	}
	
	/**
	 * Update quarter.
	 *
	 * @param q the q
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateQuarter(@ModelAttribute Quarter q) {
		try {
			schoolYearRepository.findById(q.getSchoolYear().getId())
					.orElseThrow(() -> new SchoolYearNotFoundException());
		} catch (SchoolYearNotFoundException e) {
			SchoolYear schoolYear = new SchoolYear(q.getSchoolYear().getId());
			schoolYearRepository.save(schoolYear);
		}
		quarterRepository.save(q);
		return "redirect:/quarter/dashboard";
    }
	
	/**
	 * Delete quarter.
	 *
	 * @param q the q
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteQuarter(@ModelAttribute Quarter q) {
		quarterRepository.delete(q);
        return "redirect:dashboard";
    }
}
