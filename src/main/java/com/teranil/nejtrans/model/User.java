package com.teranil.nejtrans.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 40, message = "First name is too long")
    @NotEmpty(message = "First Name is required.")
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Length(max = 40, message = "Last name is too long")
    @NotEmpty(message = "Last name Name is required.")
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;
    private String address;
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have a minimum of 6 characters")
    @Column(nullable = false)
    private String password;
    @CreationTimestamp
    private Date createdAt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Role> roles = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user")
    private Collection<Dossier> dossier = new ArrayList<>();


    @OneToMany(mappedBy = "eventUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Event> events = new ArrayList<>();

}
