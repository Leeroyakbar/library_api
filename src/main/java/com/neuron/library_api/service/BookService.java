package com.neuron.library_api.service;

import com.neuron.library_api.dto.request.BookRequest;
import com.neuron.library_api.dto.request.BookUpdateRequest;
import com.neuron.library_api.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse create(BookRequest bookRequest);
    List<BookResponse> getAll();
    BookResponse getById(String id);
    BookResponse update(BookUpdateRequest updateRequest);
    void delete(String id);
}
