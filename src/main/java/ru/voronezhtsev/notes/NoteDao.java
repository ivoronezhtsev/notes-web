package ru.voronezhtsev.notes;


import org.springframework.data.repository.CrudRepository;

public interface NoteDao extends CrudRepository<Note, Integer> {
}
