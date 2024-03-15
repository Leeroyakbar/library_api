package com.neuron.library_api.service.impl;

import com.neuron.library_api.dto.request.BookRequest;
import com.neuron.library_api.dto.request.BookUpdateRequest;
import com.neuron.library_api.dto.response.BookResponse;
import com.neuron.library_api.entity.Book;
import com.neuron.library_api.repository.BookRepository;
import com.neuron.library_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public BookResponse create(BookRequest request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .yearPublished(request.getYearPublished())
                .build();
        bookRepository.save(book);

        return convertToBookResponse(book);
    }

    @Override
    public List<BookResponse> getAll() {
        return null;
    }

    @Override
    public BookResponse getById(String id) {
        return null;
    }

    @Override
    public BookResponse update(BookUpdateRequest updateRequest) {
        return null;
    }

    @Override
    public void delete(String id) {

    }


    private static BookResponse convertToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .yearPublished(book.getYearPublished())
                .build();
    }
}
