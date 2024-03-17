package com.neuron.library_api.dto.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchMemberRequest {
    private String name;
    private String address;
}
