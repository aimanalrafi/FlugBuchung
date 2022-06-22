package de.thb.Flight.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    @NotBlank(message = "* First Name is required")
    private String firstname;

    @Column(nullable = false)
    @NotBlank(message = "* Last Name is required")
    private String lastname;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "* Username is required")
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "* Email is required")
    @Email(message = "{errors.invalid_email}")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "* Password is required")
    @Size(min = 8)
    private String password;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

}