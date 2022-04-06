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

import com.alex.sms.exception.TeachingNotFoundException;
import com.alex.sms.model.Teaching;
import com.alex.sms.repository.ClassRepository;
import com.alex.sms.repository.SubjectRepository;
import com.alex.sms.repository.TeachingRepository;
import com.alex.sms.repository.TeacherRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TeachingController.
 */
@Controller
@RequestMapping(path="/teaching")
public class TeachingController {
	
	/** The teaching repository. */
	@Autowired
	private TeachingRepository teachingRepository;

	/** The subject repository. */
	@Autowired
	private SubjectRepository subjectRepository;
	
	/** The teacher repository. */
	@Autowired
	private TeacherRepository teacherRepository;
	
	/** The class repository. */
	@Autowired
	private ClassRepository classRepository;
	
	/**
	 * Teaching index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String teachingIndex(Model model) {
        model.addAttribute("teaching", new Teaching());
        model.addAttribute("teachings", teachingRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "teaching/dashboard";
    }
	
	/**
	 * Gets the teaching.
	 *
	 * @param id the id
	 * @return the teaching
	 * @throws TeachingNotFoundException the teaching not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Teaching getTeaching (@PathVariable(value = "id") Integer id)
			throws TeachingNotFoundException {
		Teaching s = teachingRepository.findById(id)
				.orElseThrow(() -> new TeachingNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all teachings.
	 *
	 * @return the all teachings
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Teaching> getAllTeachings() {
		return teachingRepository.findAll();
	}

    /**
     * Creates the teaching.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createTeaching(@ModelAttribute Teaching s) {
		teachingRepository.save(s);
        return "redirect:dashboard";
    }
    
    /**
     * View update form teaching.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws TeachingNotFoundException the teaching not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormTeaching(@PathVariable(value = "id") Integer id,
			Model model) throws TeachingNotFoundException {
    	model.addAttribute("teaching", this.getTeaching(id));
        model.addAttribute("teachings", teachingRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
		return "teaching/edit";
	}
	
	/**
	 * Update teaching.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateTeaching(@ModelAttribute Teaching s) {
		teachingRepository.save(s);
		return "redirect:/teaching/dashboard";
    }
	
	/**
	 * Delete teaching.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteTeaching(@ModelAttribute Teaching s) {
		teachingRepository.delete(s);
        return "redirect:dashboard";
    }
}
