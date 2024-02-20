package dev.xelaseventh.bookstorems.controller;

import dev.xelaseventh.bookstorems.dto.BookRequest;
import dev.xelaseventh.bookstorems.dto.BookResponse;
import dev.xelaseventh.bookstorems.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;
    //http://localhost:8080/api/book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookRequest bookRequest) {
        bookService.createBook(bookRequest);
    }
    //http://localhost:8080/api/book/all
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }
    //http://localhost:8080/api/search/{id]
    @GetMapping("/search/{id}")
    public BookResponse findBookById(@PathVariable String id) {
        return bookService.findBookById(id);
    }
}
