package ru.voronezhtsev.notes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String text;

    @Column
    private String username;
}
