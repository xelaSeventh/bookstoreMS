package dev.xelaseventh.bookstorems.repository;

import dev.xelaseventh.bookstorems.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
