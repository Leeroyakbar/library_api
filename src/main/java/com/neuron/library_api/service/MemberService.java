package com.neuron.library_api.service;

import com.neuron.library_api.dto.request.MemberRequest;
import com.neuron.library_api.dto.request.MemberUpdateRequest;
import com.neuron.library_api.dto.request.SearchMemberRequest;
import com.neuron.library_api.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {
    MemberResponse create(MemberRequest request);

    List<MemberResponse> getAll(SearchMemberRequest request);

    MemberResponse getById(String id);
    MemberResponse update(MemberUpdateRequest request);

    Boolean delete(String id);
}
