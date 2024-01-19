package com.nuhani.backendassessments.Contract;

import com.nuhani.backendassessments.Model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
    Interface extends MongoRepository and is part of Spring Data MongoDB
    to provide set of methods for basic CRUD operation on Note entity in MongoDB
    Param : Note - entity type that repository will be handling
            id (type String) identifier field in the entity
 */
public interface NoteRepository extends MongoRepository<Note, String> {
}
