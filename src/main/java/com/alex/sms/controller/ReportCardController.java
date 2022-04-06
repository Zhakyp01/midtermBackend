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

import com.alex.sms.exception.ReportCardNotFoundException;
import com.alex.sms.model.ReportCard;
import com.alex.sms.repository.QuarterRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.ReportCardRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportCardController.
 */
@Controller
@RequestMapping(path="/report_card")
public class ReportCardController {
	
	/** The report card repository. */
	@Autowired
	private ReportCardRepository reportCardRepository;
	
	/** The registration repository. */
	@Autowired
	private RegistrationRepository registrationRepository;
	
	/** The quarter repository. */
	@Autowired
	private QuarterRepository quarterRepository;
	
	/**
	 * Report card index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String reportCardIndex(Model model) {
        model.addAttribute("reportCard", new ReportCard());
        model.addAttribute("reportCards", reportCardRepository.findAll());
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("quarters", quarterRepository.findAll());
        return "report_card/dashboard";
    }
	
	/**
	 * Gets the report card.
	 *
	 * @param id the id
	 * @return the report card
	 * @throws ReportCardNotFoundException the report card not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody ReportCard getReportCard (@PathVariable(value = "id") Integer id)
			throws ReportCardNotFoundException {
		ReportCard s = reportCardRepository.findById(id)
				.orElseThrow(() -> new ReportCardNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all report cards.
	 *
	 * @return the all report cards
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ReportCard> getAllReportCards() {
		return reportCardRepository.findAll();
	}

    /**
     * Creates the report card.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createReportCard(@ModelAttribute ReportCard s) {
    	if(reportCardRepository.findByRegistrationId(s.getRegistration().getId()) != null)
    		System.out.println("Student already has a class.");
    	else
    		reportCardRepository.save(s);
        return "redirect:/report_card/dashboard";
    }
    
    /**
     * View update form report card.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws ReportCardNotFoundException the report card not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormReportCard(@PathVariable(value = "id") Integer id,
			Model model) throws ReportCardNotFoundException {
    	model.addAttribute("reportCard", this.getReportCard(id));
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("quarters", quarterRepository.findAll());
		return "report_card/edit";
	}
	
	/**
	 * Update report card.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateReportCard(@ModelAttribute ReportCard s) {
		if(reportCardRepository.findByRegistrationId(s.getRegistration().getId()) != null)
    		System.out.println("Student already has a class.");
    	else
    		reportCardRepository.save(s);
		return "redirect:/report_card/dashboard";
    }
	
	/**
	 * Delete report card.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteReportCard(@ModelAttribute ReportCard s) {
		reportCardRepository.delete(s);
        return "redirect:/report_card/dashboard";
    }
}
