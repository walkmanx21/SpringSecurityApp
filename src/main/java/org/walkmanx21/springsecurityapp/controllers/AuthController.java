package org.walkmanx21.springsecurityapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.walkmanx21.springsecurityapp.models.Person;
import org.walkmanx21.springsecurityapp.services.PersonService;
import org.walkmanx21.springsecurityapp.util.PersonValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final PersonService personService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthController(PersonService personService, PersonValidator personValidator) {
        this.personService = personService;
        this.personValidator = personValidator;
    }

    @InitBinder("person")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(personValidator);
    }


    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "/auth/registration";
        personService.register(person);
        return "redirect:/auth/login";
    }
}
