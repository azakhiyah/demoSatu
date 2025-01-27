package com.demoSatu.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.demoSatu.dao.MemberDao;
import com.demoSatu.dto.SignUpForm;
import com.demoSatu.model.Member;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
    private final MemberDao memberDao;

    
    public RegisterController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @GetMapping("/signup")
    public String register(Model model) {
        model.addAttribute("signup", new SignUpForm());
        return "signup"; // Mengembalikan nama template "signup.html"
    }

    @PostMapping("/signup")
    public String registerMember(@Valid @ModelAttribute ("signup") SignUpForm signupForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        Member member2 = new Member();
        member2.setFullName(signupForm.getFullName());
        member2.setEmail(signupForm.getEmail());
        member2.setPhone(signupForm.getPhone());
        System.out.println("Phone: " + signupForm.getPhone());
        member2.setPassword(signupForm.getPassword());
        memberDao.save(member2);
        return "redirect:/signup-success";

    }

    @GetMapping("/signup-success")
    public String signUpSuccess() {
        return "signup-success"; // Refers to sign-up-success.html
    }

    @PostMapping("/addmember")
    public String processRegister() {
        return "sign-up-success";
    }

}
