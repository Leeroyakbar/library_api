package com.neuron.library_api.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookUpdateRequest {
    private String id;
    private String title;
    private String author;
    private String yearPublished;
}
