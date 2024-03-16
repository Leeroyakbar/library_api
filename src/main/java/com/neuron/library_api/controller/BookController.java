package com.neuron.library_api.controller;


import com.neuron.library_api.constant.ConstantAPI;
import com.neuron.library_api.constant.ResponseMessage;
import com.neuron.library_api.dto.request.BookRequest;
import com.neuron.library_api.dto.request.BookUpdateRequest;
import com.neuron.library_api.dto.request.SearchBookRequest;
import com.neuron.library_api.dto.response.BookResponse;
import com.neuron.library_api.dto.response.CommonResponse;
import com.neuron.library_api.entity.Book;
import com.neuron.library_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ConstantAPI.BOOK_API)
public class BookController {
    private final BookService bookService;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
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

    @GetMapping
    public ResponseEntity<CommonResponse<List<BookResponse>>> getAllBook(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "author", required = false) String author,
            @RequestParam(name = "yearPublished", required = false) String yearPublished
    ){
        SearchBookRequest request = SearchBookRequest.builder()
                .title(title)
                .author(author)
                .yearPublished(yearPublished).build();

        List<BookResponse> books = bookService.getAll(request);

        CommonResponse<List<BookResponse>> response = CommonResponse.<List<BookResponse>>builder()
                .statusCode(HttpStatus.OK.value())
                .message(ResponseMessage.SUCCESS_GET_DATA)
                .data(books)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<BookResponse>> getById(
            @PathVariable String id
    ){
        BookResponse book = bookService.getById(id);

        CommonResponse<BookResponse> response = CommonResponse.<BookResponse>builder()
                .statusCode(HttpStatus.OK.value())
                .message(ResponseMessage.SUCCESS_GET_DATA)
                .data(book).build();

        return ResponseEntity.ok(response);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<BookResponse>> updateBook(
            @RequestBody BookUpdateRequest request
    ){
        CommonResponse.CommonResponseBuilder<BookResponse> builder = CommonResponse.builder();
        BookResponse updated = bookService.update(request);

        if(updated == null){
            builder.statusCode(HttpStatus.NOT_FOUND.value())
                    .message(ResponseMessage.ERROR_NOT_FOUND)
                    .build();
        }else{
            builder.statusCode(HttpStatus.CREATED.value())
                    .message(ResponseMessage.SUCCESS_UPDATE_DATA)
                    .data(updated)
                    .build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(builder.build());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<?>> deleteBookById(
            @PathVariable String id
    ){
        CommonResponse.CommonResponseBuilder<Object> builder = CommonResponse.builder();
        HttpStatus httpStatus;
        if (bookService.delete(id)){
            builder.statusCode(HttpStatus.OK.value())
                    .message(ResponseMessage.SUCCESS_DELETE_DATA)
                    .build();
            httpStatus = HttpStatus.OK;
        }else{
            builder.statusCode(HttpStatus.OK.value())
                    .message(ResponseMessage.ERROR_NOT_FOUND)
                    .build();
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(httpStatus).body(builder.build());
    }

}
