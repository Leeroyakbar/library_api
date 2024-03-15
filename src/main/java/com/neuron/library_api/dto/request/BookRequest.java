package com.neuron.library_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {

    @NotBlank(message = "name is required")
    private String title;

    @NotBlank(message = "author is required")
    private String author;

    @NotBlank(message = "author is required")
    private String yearPublished;
}
