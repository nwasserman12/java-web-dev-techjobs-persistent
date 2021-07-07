package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String list (Model model){
        return "list";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model){
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors,
                                      Model model){
        if (errors.hasErrors()){
            model.addAttribute("skill", "Add Skill");
            model.addAttribute(new Skill());
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

//    @GetMapping("view/{employerId}")
//    public String displayViewSkill(Model model, @PathVariable int jobId) {
//        Optional optSkill = skillRepository.findById(jobId);
//        if (optSkill.isPresent()) {
//            Skill skill = (Skill) optSkill.get();
//            model.addAttribute("skill", skill);
//            return "employers/view";
//        } else {
//            return "redirect:../";
//        }
//    }
}
