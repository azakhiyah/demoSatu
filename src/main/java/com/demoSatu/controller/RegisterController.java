package com.demoSatu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demoSatu.dao.MemberDao;
import com.demoSatu.dto.RegistrationForm;
import com.demoSatu.model.Member;

@Controller
public class RegisterController {
    private final MemberDao memberDao;

    @Autowired
    public RegisterController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @GetMapping("/sign-up")
    public String register(Model member) {
        member.addAttribute("registrationForm", new RegistrationForm());
        return "sign-up"; // Mengembalikan nama template "register.html"
    }

    @PostMapping("/sign-up")
    public ModelAndView registerMember(@ModelAttribute RegistrationForm form) {
        Member member = new Member();
        member.setFullName(form.getFullName());
        member.setEmail(form.getEmail());
        member.setNomor_handphone(form.getPassword());
        member.setPassword(form.getPassword());
        memberDao.save(member);
        return new ModelAndView("redirect:/sign-up-success");

    }

    @GetMapping("/sign-up-success")
    public String signUpSuccess() {
        return "sign-up-success"; // Refers to sign-up-success.html
    }

    @PostMapping("/addmember")
    public String processRegister() {
        return "sign-up-success";
    }

}
