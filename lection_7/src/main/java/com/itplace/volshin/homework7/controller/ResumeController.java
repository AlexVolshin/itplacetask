package com.itplace.volshin.homework7.controller;

import com.itplace.volshin.homework7.data.ResumeData;
import com.itplace.volshin.homework7.service.api.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(@Qualifier("resumeServiceImp") ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/resume")
    public String getMyResume(Model model) {
        ResumeData resumeData = this.resumeService.getResumeData();
        if (resumeData == null)
            return "message";
        model.addAttribute("fio", resumeData.getFullname());
        model.addAttribute("dob", resumeData.getBirthday());
        model.addAttribute("phone", resumeData.getPhonenumber());
        model.addAttribute("email", resumeData.getEmail());
        model.addAttribute("skype", resumeData.getSkype());
        model.addAttribute("avatar", resumeData.getImage());
        model.addAttribute("target", resumeData.getTarget());
        model.addAttribute("experience", resumeData.getExperience());
        model.addAttribute("education", resumeData.getEducation());
        model.addAttribute("additional", resumeData.getAdditional());
        model.addAttribute("skills", resumeData.getSkills());
        model.addAttribute("example", resumeData.getExample());
        return "resume";
    }

}
