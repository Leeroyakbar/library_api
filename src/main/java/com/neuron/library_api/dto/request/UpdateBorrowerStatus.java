package com.neuron.library_api.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UpdateBorrowerStatus {
    private String id;
    private String status;

}
