package dev.xelaseventh.bookstorems.service;

import dev.xelaseventh.bookstorems.dto.BookRequest;
import dev.xelaseventh.bookstorems.dto.BookResponse;

import java.util.List;

public interface BookService {

    public void createBook(BookRequest bookRequest);
    public List<BookResponse> getAllBooks();
    public BookResponse findBookById(String id);

}
