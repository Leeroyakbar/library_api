package com.neuron.library_api.service.impl;

import com.neuron.library_api.dto.request.BookRequest;
import com.neuron.library_api.dto.request.BookUpdateRequest;
import com.neuron.library_api.dto.request.SearchBookRequest;
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

    @Transactional(rollbackFor = Exception.class)
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

    @Transactional(readOnly = true)
    @Override
    public List<BookResponse> getAll(SearchBookRequest request) {
        List<Book> books = bookRepository.getAllByFilter(request.getTitle(), request.getAuthor(), request.getYearPublished()
        );

        return books.stream().map(detail -> BookResponse.builder()
                .id(detail.getId())
                .title(detail.getTitle())
                .author(detail.getAuthor())
                .yearPublished(detail.getYearPublished())
                .build()).toList();
    }

    @Override
    public BookResponse getById(String id) {
        Book book = bookRepository.getOneById(id);
        return convertToBookResponse(book);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BookResponse update(BookUpdateRequest request) {
        Integer result = bookRepository.updateBook(request.getId(), request.getTitle(), request.getAuthor(), request.getYearPublished());

        if(result > 0){
            Book book = bookRepository.getOneById(request.getId());
            return convertToBookResponse(book);
        }else{
            return null;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean delete(String id) {
        Integer result = bookRepository.deleteBookById(id);
        return result != 0;
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
