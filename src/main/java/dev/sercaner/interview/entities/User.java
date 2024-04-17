package dev.sercaner.interview.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 2, message = "Must be not null")
    @Column(name = "firstName", length = 50)
    private String firstName;

    @NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 2, message = "Must be not null")
    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "registerDate")
    private LocalDateTime registerDate;

//    @Email
//    //@NotNull(message = "Invalid email")
//    @Size(min =11,max = 50)
//    @Column(name = "email", length = 50)
//    private String email;

//    //@NotNull(message = "Invalid Phone number: Number is NULL")
//    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
//    private String mobile;

//    @Min(value = 1, message = "Invalid Age: Equals to zero or Less than zero")
//    @Max(value = 100, message = "Invalid Age: Exceeds 100 years")
//    private int age;
}
