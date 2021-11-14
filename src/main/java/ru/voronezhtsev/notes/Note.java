package ru.voronezhtsev.notes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
