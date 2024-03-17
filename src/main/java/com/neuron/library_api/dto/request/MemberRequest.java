package com.neuron.library_api.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequest {
    private String id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "mobilePhone is required")
    private String mobilePhone;
}
