package org.walkmanx21.springsecurityapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.walkmanx21.springsecurityapp.repositories.PersonRepository;
import org.walkmanx21.springsecurityapp.security.PersonDetails;

@Service
@Transactional
public class PersonService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username)
                .map(PersonDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с данным логином не найден: " + username));
    }
}
