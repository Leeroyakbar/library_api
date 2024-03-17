package com.neuron.library_api.dto.response;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowerResponse {
    private String id;
    private String memberId;
    private String bookId;
    private Date loanDate;
    private Date dateOfReturn;
    private String status;
}
