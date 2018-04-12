package com.itplace.volshin.homework8.controller;

import com.itplace.volshin.homework8.data.SummaryData;
import com.itplace.volshin.homework8.entity.Summary;
import com.itplace.volshin.homework8.repository.SummaryRepository;
import com.itplace.volshin.homework8.service.api.StringListService;
import com.itplace.volshin.homework8.service.api.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SummaryController {

    private SummaryRepository summaryRepository;
    private SummaryService summaryService;
    private StringListService stringListService;

    @Autowired
    public SummaryController(SummaryRepository summaryRepository,
                             SummaryService summaryService,
                             StringListService stringListService) {
        this.summaryRepository = summaryRepository;
        this.summaryService = summaryService;
        this.stringListService = stringListService;
    }

    @GetMapping("/filldatabase")
    public String fillDatabase() {
        this.summaryRepository.deleteAll();
        SummaryData summaryData = summaryService.getData();
        if (summaryData == null)
            return "failure";
        Summary summary = new Summary();
        summary.setFullname(summaryData.getFullname());
        summary.setBirthday(summaryData.getBirthday());
        summary.setPhone(summaryData.getPhonenumber());
        summary.setEmail(summaryData.getEmail());
        summary.setSkype(summaryData.getSkype());
        summary.setImage(summaryData.getImage());
        summary.setTarget(summaryData.getTarget());
        summary.setExperience(summaryData.getExperience());
        summary.setEducation(summaryData.getEducation());
        summary.setAdditional(summaryData.getAdditional());
        summary.setSkills(summaryData.getSkills());
        summary.setExample(summaryData.getExample());
        this.summaryRepository.save(summary);
        return "success";
    }

    @GetMapping("/summary/file")
    public String showSummaryFromFile(Model model) {
        SummaryData summaryData = summaryService.getData();
        if (summaryData == null)
            return "failure";
        model.addAttribute("fio", summaryData.getFullname());
        model.addAttribute("dob", summaryData.getBirthday());
        model.addAttribute("phone", summaryData.getPhonenumber());
        model.addAttribute("email", summaryData.getEmail());
        model.addAttribute("skype", summaryData.getSkype());
        model.addAttribute("avatar", summaryData.getImage());
        model.addAttribute("target", stringListService.stringToList(summaryData.getTarget()));
        model.addAttribute("experience", stringListService.stringToList(summaryData.getExperience()));
        model.addAttribute("education", stringListService.stringToList(summaryData.getEducation()));
        model.addAttribute("additional", stringListService.stringToList(summaryData.getAdditional()));
        model.addAttribute("skills", stringListService.stringToList(summaryData.getSkills()));
        model.addAttribute("example", stringListService.stringToList(summaryData.getExample()));
        return "summary";
    }

    @GetMapping("/summary/db")
    public String showSummaryFromDB(Model model) {
        List<Summary> summaryList = this.summaryRepository.findAll();
        if (summaryList.isEmpty())
            return "summary";
        Summary summary = summaryList.get(0);
        model.addAttribute("fio", summary.getFullname());
        model.addAttribute("dob", summary.getBirthday());
        model.addAttribute("phone", summary.getPhone());
        model.addAttribute("email", summary.getEmail());
        model.addAttribute("skype", summary.getSkype());
        model.addAttribute("avatar", summary.getImage());
        model.addAttribute("target", stringListService.stringToList(summary.getTarget()));
        model.addAttribute("experience", stringListService.stringToList(summary.getExperience()));
        model.addAttribute("education", stringListService.stringToList(summary.getEducation()));
        model.addAttribute("additional", stringListService.stringToList(summary.getAdditional()));
        model.addAttribute("skills", stringListService.stringToList(summary.getSkills()));
        model.addAttribute("example", stringListService.stringToList(summary.getExample()));
        return "summary";
    }

}
