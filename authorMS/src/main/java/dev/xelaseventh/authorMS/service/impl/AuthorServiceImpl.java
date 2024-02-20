package dev.xelaseventh.authorMS.service.impl;

import dev.xelaseventh.authorMS.dto.AuthorRequest;
import dev.xelaseventh.authorMS.dto.AuthorResponse;
import dev.xelaseventh.authorMS.model.Author;
import dev.xelaseventh.authorMS.repository.AuthorRepository;
import dev.xelaseventh.authorMS.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Override
    public void createAuthor(AuthorRequest authorRequest) {
        Author author = Author.builder()
                .name(authorRequest.getName())
                .nationality(authorRequest.getNationality())
                .biography(authorRequest.getBiography())
                .build();

        authorRepository.save(author);
        log.info("Author {} has been successfully saved", author.getId());
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::mapToAuthorResponse).toList();
    }

    private AuthorResponse mapToAuthorResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .nationality(author.getNationality())
                .biography(author.getBiography())
                .build();
    }
    @Override
    public AuthorResponse findAuthorById(String id) {
            Optional<Author> author = authorRepository.findById(id);
            return author.stream().map(this::mapToAuthorResponse).findAny().orElseThrow();
    }
}
