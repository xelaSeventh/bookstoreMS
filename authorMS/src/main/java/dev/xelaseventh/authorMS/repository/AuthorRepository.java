package dev.xelaseventh.authorMS.repository;

import dev.xelaseventh.authorMS.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
}
