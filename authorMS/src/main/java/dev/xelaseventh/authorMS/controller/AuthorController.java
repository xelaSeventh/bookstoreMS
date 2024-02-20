package dev.xelaseventh.authorMS.controller;

import dev.xelaseventh.authorMS.dto.AuthorRequest;
import dev.xelaseventh.authorMS.dto.AuthorResponse;
import dev.xelaseventh.authorMS.service.impl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody AuthorRequest authorRequest) {
        authorService.createAuthor(authorRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/search/{id}")
    public AuthorResponse findAuthorById(@PathVariable String id) {
        return authorService.findAuthorById(id);
    }
}
