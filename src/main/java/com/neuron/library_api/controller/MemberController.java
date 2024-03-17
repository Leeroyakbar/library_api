package com.neuron.library_api.controller;


import com.neuron.library_api.constant.ConstantAPI;
import com.neuron.library_api.constant.ResponseMessage;
import com.neuron.library_api.dto.request.MemberRequest;
import com.neuron.library_api.dto.request.MemberUpdateRequest;
import com.neuron.library_api.dto.request.SearchMemberRequest;
import com.neuron.library_api.dto.response.CommonResponse;
import com.neuron.library_api.dto.response.MemberResponse;
import com.neuron.library_api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ConstantAPI.MEMBER_API)
public class MemberController {
    private final MemberService memberService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<MemberResponse>> createMember(
            @RequestBody MemberRequest request
            ){
        CommonResponse.CommonResponseBuilder<MemberResponse> builder = CommonResponse.<MemberResponse>builder();
        HttpStatus httpStatus;
        MemberResponse memberResponse = memberService.create(request);

        if(memberResponse != null){
            builder.statusCode(HttpStatus.CREATED.value())
                    .message(ResponseMessage.SUCCESS_CREATED_DATA)
                    .data(memberResponse)
                    .build();
            httpStatus = HttpStatus.CREATED;
        }else{
            builder.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(ResponseMessage.ERROR_INTERNAL_SERVER)
                    .build();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus).body(builder.build());
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<List<MemberResponse>>> getAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address
    ){
        SearchMemberRequest request = SearchMemberRequest.builder()
                .name(name)
                .address(address)
                .build();

        List<MemberResponse> memberResponses = memberService.getAll(request);

        CommonResponse<List<MemberResponse>> response = CommonResponse.<List<MemberResponse>>builder()
                .statusCode(HttpStatus.OK.value())
                .message(ResponseMessage.SUCCESS_GET_DATA)
                .data(memberResponses)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<MemberResponse>> getById(
            @PathVariable String id
    ){
        CommonResponse.CommonResponseBuilder<MemberResponse> builder = CommonResponse.<MemberResponse>builder();
        HttpStatus httpStatus;
        MemberResponse member = memberService.getById(id);

        if(member != null){
            builder.statusCode(HttpStatus.OK.value())
                    .message(ResponseMessage.SUCCESS_GET_DATA)
                    .data(member)
                    .build();
            httpStatus = HttpStatus.OK;
        }else{
            builder.statusCode(HttpStatus.NOT_FOUND.value())
                    .message(ResponseMessage.ERROR_NOT_FOUND)
                    .build();
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(builder.build());
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CommonResponse<MemberResponse>> update(
            @RequestBody MemberUpdateRequest request
            ){
        CommonResponse.CommonResponseBuilder<MemberResponse> builder = CommonResponse.<MemberResponse>builder();
        HttpStatus httpStatus;
        MemberResponse update = memberService.update(request);

        if(update != null){
            builder.statusCode(HttpStatus.CREATED.value())
                    .message(ResponseMessage.SUCCESS_UPDATE_DATA)
                    .data(update).build();
            httpStatus = HttpStatus.CREATED;
        }else{
            builder.statusCode(HttpStatus.NOT_FOUND.value())
                    .message(ResponseMessage.ERROR_NOT_FOUND)
                    .build();
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(httpStatus).body(builder.build());
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<?>> delete(
            @PathVariable String id
    ){
        CommonResponse.CommonResponseBuilder<Object> builder = CommonResponse.builder();
        HttpStatus httpStatus;
        if (memberService.delete(id)){
            builder.statusCode(HttpStatus.OK.value())
                    .message(ResponseMessage.SUCCESS_DELETE_DATA)
                    .build();
            httpStatus = HttpStatus.OK;
        }else{
            builder.statusCode(HttpStatus.OK.value())
                    .message(ResponseMessage.ERROR_NOT_FOUND)
                    .build();
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(httpStatus).body(builder.build());

    }
}
