package com.neuron.library_api.service;

import com.neuron.library_api.dto.request.BorrowerRequest;
import com.neuron.library_api.dto.request.UpdateBorrowerStatus;
import com.neuron.library_api.dto.response.BorrowerResponse;

import java.util.List;

public interface BorrowerService {
    BorrowerResponse create(BorrowerRequest request);

    List<BorrowerResponse> getAll();
    BorrowerResponse getById();
    BorrowerResponse updateStatus(UpdateBorrowerStatus request);
}
