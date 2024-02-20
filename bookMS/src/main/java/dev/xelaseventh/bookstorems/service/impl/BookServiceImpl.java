package dev.xelaseventh.bookstorems.service.impl;

import dev.xelaseventh.bookstorems.dto.BookRequest;
import dev.xelaseventh.bookstorems.dto.BookResponse;
import dev.xelaseventh.bookstorems.model.Book;
import dev.xelaseventh.bookstorems.repository.BookRepository;
import dev.xelaseventh.bookstorems.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public void createBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .title(bookRequest.getTitle())
                .publisher(bookRequest.getPublisher())
                .publicationDate(bookRequest.getPublicationDate())
                .pages(bookRequest.getPages())
                .price(bookRequest.getPrice())
                .build();

        bookRepository.save(book);
        log.info("Book {} has been successfully saved", book.getId());
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::mapToBookResponse).toList();
    }

    private BookResponse mapToBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .publisher(book.getPublisher())
                .publicationDate(book.getPublicationDate())
                .pages(book.getPages())
                .price(book.getPrice())
                .build();
    }
    @Override
    public BookResponse findBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.stream().map(this::mapToBookResponse).findAny().orElseThrow();
    }
}
