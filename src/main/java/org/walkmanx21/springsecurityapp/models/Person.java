package org.walkmanx21.springsecurityapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotEmpty(message = "Год рождения пользователя не может быть пустым")
    @Min(value = 1900, message = "Год рождения пользователя должен быть больше, чем 1900")
    @Pattern(regexp = "^[0-9]+$", message = "Год рождения пользователя должен содержать только латинские буквы и цифры")
    private int yearOfBirth;

    @Column(name = "password")
    @NotEmpty
    @Size(min = 6, max = 20, message = "Пароль должен содержать от 6 до 20 символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Пароль пользователя должен содержать только латинские буквы и цифры")
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
