package com.neuron.library_api.controller;

import com.neuron.library_api.constant.ConstantAPI;
import com.neuron.library_api.constant.ResponseMessage;
import com.neuron.library_api.dto.request.BorrowerRequest;
import com.neuron.library_api.dto.request.UpdateBorrowerStatus;
import com.neuron.library_api.dto.response.BorrowerResponse;
import com.neuron.library_api.dto.response.CommonResponse;
import com.neuron.library_api.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ConstantAPI.BORROWER_API)
public class BorrowerController {
    private final BorrowerService borrowerService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<BorrowerResponse>> create(
            @RequestBody BorrowerRequest request
            ){
        BorrowerResponse borrowerResponse = borrowerService.create(request);

        CommonResponse<BorrowerResponse> response = CommonResponse.<BorrowerResponse>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message(ResponseMessage.SUCCESS_CREATED_DATA)
                .data(borrowerResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<List<BorrowerResponse>>> getAll(){
        List<BorrowerResponse> borrowers = borrowerService.getAll();

        CommonResponse<List<BorrowerResponse>> response = CommonResponse.<List<BorrowerResponse>>builder()
                .statusCode(HttpStatus.OK.value())
                .message(ResponseMessage.SUCCESS_GET_DATA)
                .data(borrowers)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<BorrowerResponse>> updateStatus(
            @RequestBody UpdateBorrowerStatus request
            ){
        CommonResponse.CommonResponseBuilder<BorrowerResponse> builder = CommonResponse.<BorrowerResponse>builder();
        BorrowerResponse borrowerResponse = borrowerService.updateStatus(request);
        HttpStatus httpStatus;
        if(borrowerResponse != null){
            getCommonResponse(builder.statusCode(HttpStatus.CREATED.value())
                    .message(ResponseMessage.SUCCESS_UPDATE_DATA)
                    .data(borrowerResponse));
            httpStatus = HttpStatus.CREATED;
        }else{
            getCommonResponse(builder.statusCode(HttpStatus.NOT_FOUND.value())
                    .message(ResponseMessage.ERROR_NOT_FOUND));
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(httpStatus).body(builder.build());
    }

    private static void getCommonResponse(CommonResponse.CommonResponseBuilder<BorrowerResponse> builder) {
        builder
                .build();
    }
}
