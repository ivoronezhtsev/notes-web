package ru.voronezhtsev.notes;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteDao extends CrudRepository<Note, Integer> {

    List<Note> findByUsername(String username);

}
