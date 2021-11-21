package ru.voronezhtsev.notes.security;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;*/
}
