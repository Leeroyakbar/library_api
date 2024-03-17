package com.neuron.library_api.dto.response;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponse {
    private String id;
    private String name;
    private String address;
    private String mobilePhone;
}
