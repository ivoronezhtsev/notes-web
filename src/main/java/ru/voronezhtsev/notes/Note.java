package ru.voronezhtsev.notes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(nullable = false)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Getter
    @Setter
    private String text;

    public  String getText() {
        return text;
    }

    /*@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;*/
}
