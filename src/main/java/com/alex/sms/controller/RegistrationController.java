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

import com.alex.sms.exception.RegistrationNotFoundException;
import com.alex.sms.model.Registration;
import com.alex.sms.repository.ClassRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.StudentRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationController.
 */
@Controller
@RequestMapping(path="/registration")
public class RegistrationController {
	
	/** The registration repository. */
	@Autowired
	private RegistrationRepository registrationRepository;

	/** The class repository. */
	@Autowired
	private ClassRepository classRepository;
	
	/** The student repository. */
	@Autowired
	private StudentRepository studentRepository;
	
	/**
	 * Registration index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String registrationIndex(Model model) {
        model.addAttribute("registration", new Registration());
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        return "registration/dashboard";
    }
	
	/**
	 * Gets the registration.
	 *
	 * @param id the id
	 * @return the registration
	 * @throws RegistrationNotFoundException the registration not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Registration getRegistration (@PathVariable(value = "id") Integer id)
			throws RegistrationNotFoundException {
		Registration s = registrationRepository.findById(id)
				.orElseThrow(() -> new RegistrationNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all registrations.
	 *
	 * @return the all registrations
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Registration> getAllRegistrations() {
		return registrationRepository.findAll();
	}

    /**
     * Creates the registration.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createRegistration(@ModelAttribute Registration s) {
    	if(registrationRepository.findByStudentId(s.getStudent().getId()) != null)
    		System.out.println("Student already has a class.");
    	else
    		registrationRepository.save(s);
        return "redirect:dashboard";
    }
    
    /**
     * View update form registration.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws RegistrationNotFoundException the registration not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormRegistration(@PathVariable(value = "id") Integer id,
			Model model) throws RegistrationNotFoundException {
    	model.addAttribute("registration", this.getRegistration(id));
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
		return "registration/edit";
	}
	
	/**
	 * Update registration.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateRegistration(@ModelAttribute Registration s) {
		registrationRepository.save(s);
		return "redirect:/registration/dashboard";
    }
	
	/**
	 * Delete registration.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteRegistration(@ModelAttribute Registration s) {
		registrationRepository.delete(s);
        return "redirect:dashboard";
    }
}
