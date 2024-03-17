package com.neuron.library_api.dto.request;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowerRequest {
    private String id;
    private String memberId;
    private String bookId;
    private Date loanDate;
}
