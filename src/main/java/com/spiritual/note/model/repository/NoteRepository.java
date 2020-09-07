package com.spiritual.note.model.repository;

import com.spiritual.note.model.entity.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note,Integer> {
}
