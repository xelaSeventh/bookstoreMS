package dev.xelaseventh.authorMS.service;

import dev.xelaseventh.authorMS.dto.AuthorRequest;
import dev.xelaseventh.authorMS.dto.AuthorResponse;

import java.util.List;

public interface AuthorService {
    public void createAuthor(AuthorRequest authorRequest);
    public List<AuthorResponse> getAllAuthors();
    public AuthorResponse findAuthorById(String id);
}
