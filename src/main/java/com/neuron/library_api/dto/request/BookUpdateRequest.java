package com.neuron.library_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookUpdateRequest {
    @NotBlank(message = "id is required")
    private String id;

    @NotBlank(message = "tittle is required")
    private String title;

    @NotBlank(message = "author is required")
    private String author;

    @NotBlank(message = "year published is required")
    private String yearPublished;
}
