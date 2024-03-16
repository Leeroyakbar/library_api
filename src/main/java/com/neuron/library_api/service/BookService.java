package com.neuron.library_api.service;

import com.neuron.library_api.dto.request.BookRequest;
import com.neuron.library_api.dto.request.BookUpdateRequest;
import com.neuron.library_api.dto.request.SearchBookRequest;
import com.neuron.library_api.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse create(BookRequest bookRequest);
    List<BookResponse> getAll(SearchBookRequest request);
    BookResponse getById(String id);
    BookResponse update(BookUpdateRequest updateRequest);
    Boolean delete(String id);
}
