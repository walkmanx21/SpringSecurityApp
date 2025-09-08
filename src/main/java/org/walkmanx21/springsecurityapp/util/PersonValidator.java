package org.walkmanx21.springsecurityapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.walkmanx21.springsecurityapp.models.Person;
import org.walkmanx21.springsecurityapp.services.PersonService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> mayBePerson = personService.findByUsername(person.getUsername());
        if (mayBePerson.isPresent())
            errors.rejectValue("username", "", "User with this username already exist");
    }
}
