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

import com.alex.sms.exception.TeacherNotFoundException;
import com.alex.sms.model.Teacher;
import com.alex.sms.repository.TeacherRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TeacherController.
 */
@Controller
@RequestMapping(path="/teacher")
public class TeacherController {
	
	/** The teacher repository. */
	@Autowired
	private TeacherRepository teacherRepository;
	
	/**
	 * Teacher index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String teacherIndex(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teacher/dashboard";
    }
	
	/**
	 * Gets the teacher.
	 *
	 * @param id the id
	 * @return the teacher
	 * @throws TeacherNotFoundException the teacher not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Teacher getTeacher (@PathVariable(value = "id") Integer id)
			throws TeacherNotFoundException {
		Teacher s = teacherRepository.findById(id)
				.orElseThrow(() -> new TeacherNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all teachers.
	 *
	 * @return the all teachers
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

    /**
     * Creates the teacher.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createTeacher(@ModelAttribute Teacher s) {
		teacherRepository.save(s);
        return "redirect:dashboard";
    }
    
    /**
     * View update form teacher.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws TeacherNotFoundException the teacher not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormTeacher(@PathVariable(value = "id") Integer id,
			Model model) throws TeacherNotFoundException {
    	model.addAttribute("teacher", this.getTeacher(id));
		return "teacher/edit";
	}
	
	/**
	 * Update teacher.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateTeacher(@ModelAttribute Teacher s) {
		teacherRepository.save(s);
		return "redirect:/teacher/dashboard";
    }
	
	/**
	 * Delete teacher.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteTeacher(@ModelAttribute Teacher s) {
		teacherRepository.delete(s);
        return "redirect:dashboard";
    }
}
