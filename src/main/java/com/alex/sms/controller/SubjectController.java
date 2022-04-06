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

import com.alex.sms.exception.SubjectNotFoundException;
import com.alex.sms.model.Subject;
import com.alex.sms.repository.SubjectRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class SubjectController.
 */
@Controller
@RequestMapping(path="/subject")
public class SubjectController {
	
	/** The subject repository. */
	@Autowired
	private SubjectRepository subjectRepository;
	
	/**
	 * Subject index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String subjectIndex(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "subject/dashboard";
    }
	
	/**
	 * Gets the subject.
	 *
	 * @param id the id
	 * @return the subject
	 * @throws SubjectNotFoundException the subject not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Subject getSubject (@PathVariable(value = "id") Integer id)
			throws SubjectNotFoundException {
		Subject s = subjectRepository.findById(id)
				.orElseThrow(() -> new SubjectNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all subjects.
	 *
	 * @return the all subjects
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

    /**
     * Creates the subject.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createSubject(@ModelAttribute Subject s) {
		subjectRepository.save(s);
        return "redirect:dashboard";
    }
    
    /**
     * View update form subject.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws SubjectNotFoundException the subject not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormSubject(@PathVariable(value = "id") Integer id,
			Model model) throws SubjectNotFoundException {
    	model.addAttribute("subject", this.getSubject(id));
		return "subject/edit";
	}
	
	/**
	 * Update subject.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateSubject(@ModelAttribute Subject s) {
		subjectRepository.save(s);
		return "redirect:/subject/dashboard";
    }
	
	/**
	 * Delete subject.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteSubject(@ModelAttribute Subject s) {
		subjectRepository.delete(s);
        return "redirect:dashboard";
    }
}
