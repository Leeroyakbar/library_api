package com.neuron.library_api.controller;


import com.neuron.library_api.constant.ConstantAPI;
import com.neuron.library_api.constant.ResponseMessage;
import com.neuron.library_api.dto.request.BookRequest;
import com.neuron.library_api.dto.response.BookResponse;
import com.neuron.library_api.dto.response.CommonResponse;
import com.neuron.library_api.entity.Book;
import com.neuron.library_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ConstantAPI.BOOK_API)
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<CommonResponse<BookResponse>> createBook(
            @RequestBody BookRequest request
            ){
        BookResponse bookResponse = bookService.create(request);

        CommonResponse<BookResponse> response = CommonResponse.<BookResponse>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message(ResponseMessage.SUCCESS_CREATED_DATA)
                .data(bookResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<CommonResponse<List<BookResponse>>> getAllBook(){
        List<BookResponse> books = bookService.getAll();


        return null;
    }
}
