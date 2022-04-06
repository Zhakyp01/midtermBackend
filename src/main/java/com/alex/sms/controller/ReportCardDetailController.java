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

import com.alex.sms.exception.ReportCardDetailNotFoundException;
import com.alex.sms.model.ReportCard;
import com.alex.sms.model.ReportCardDetail;
import com.alex.sms.repository.ReportCardDetailRepository;
import com.alex.sms.repository.ReportCardRepository;
import com.alex.sms.repository.TeachingRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportCardDetailController.
 */
@Controller
@RequestMapping(path="/report_card_detail")
public class ReportCardDetailController {
	
	/** The report card detail repository. */
	@Autowired
	private ReportCardDetailRepository reportCardDetailRepository;
	
	/** The report card repository. */
	@Autowired
	private ReportCardRepository reportCardRepository;
	
	/** The teaching repository. */
	@Autowired
	private TeachingRepository teachingRepository;
	
	/**
	 * Report card detail index.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/dashboard")
    public String reportCardDetailIndex(Model model) {
        model.addAttribute("reportCardDetail", new ReportCardDetail());
        model.addAttribute("reportCardDetails", reportCardDetailRepository.findAll());
        model.addAttribute("reportCards", reportCardRepository.findAll());
        model.addAttribute("teachings", teachingRepository.findAll());
        return "report_card_detail/dashboard";
    }
	
	/**
	 * Gets the report card detail.
	 *
	 * @param id the id
	 * @return the report card detail
	 * @throws ReportCardDetailNotFoundException the report card detail not found exception
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody ReportCardDetail getReportCardDetail (@PathVariable(value = "id") Integer id)
			throws ReportCardDetailNotFoundException {
		ReportCardDetail s = reportCardDetailRepository.findById(id)
				.orElseThrow(() -> new ReportCardDetailNotFoundException());
		return s;
	}
	
	/**
	 * Gets the all report card details.
	 *
	 * @return the all report card details
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ReportCard> getAllReportCardDetails() {
		return reportCardRepository.findAll();
	}

    /**
     * Creates the report card detail.
     *
     * @param s the s
     * @return the string
     */
    @PostMapping("/create")
    public String createReportCardDetail(@ModelAttribute ReportCardDetail s) {
		reportCardDetailRepository.save(s);
        return "redirect:/report_card_detail/dashboard";
    }
    
    /**
     * View update form report card detail.
     *
     * @param id the id
     * @param model the model
     * @return the string
     * @throws ReportCardDetailNotFoundException the report card detail not found exception
     */
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormReportCardDetail(@PathVariable(value = "id") Integer id,
			Model model) throws ReportCardDetailNotFoundException {
    	model.addAttribute("reportCardDetail", this.getReportCardDetail(id));
        model.addAttribute("reportCards", reportCardRepository.findAll());
        model.addAttribute("teachings", teachingRepository.findAll());
		return "report_card_detail/edit";
	}
	
	/**
	 * Update report card detail.
	 *
	 * @param s the s
	 * @return the string
	 */
	@PutMapping("/{id}/update")
    public String updateReportCardDetail(@ModelAttribute ReportCardDetail s) {
		reportCardDetailRepository.save(s);
		return "redirect:/report_card_detail/dashboard";
    }
	
	/**
	 * Delete report card detail.
	 *
	 * @param s the s
	 * @return the string
	 */
	@DeleteMapping("/delete")
    public String deleteReportCardDetail(@ModelAttribute ReportCardDetail s) {
		reportCardDetailRepository.delete(s);
        return "redirect:/report_card_detail/dashboard";
    }
}
