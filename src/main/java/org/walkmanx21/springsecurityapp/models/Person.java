package org.walkmanx21.springsecurityapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "Имя пользователя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя пользователя должно быть от 2 до 100 символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Имя пользователя должно содержать только латинские буквы и цифры")
    private String username;

    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Год рождения пользователя должен быть больше, чем 1900")
    @Max(value = 2025 - 18, message = "Пользователь должен быть старше 18 лет")
    private int yearOfBirth;

    @Column(name = "password")
    @NotEmpty
//    @Size(min = 6, max = 20, message = "Пароль должен содержать от 6 до 20 символов")
//    @Pattern(regexp = "^[a-zA-Z0-9{}]+$", message = "Пароль пользователя должен содержать только латинские буквы и цифры")
    private String password;

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", yearOfBirth=" + yearOfBirth +
               '}';
    }
}
