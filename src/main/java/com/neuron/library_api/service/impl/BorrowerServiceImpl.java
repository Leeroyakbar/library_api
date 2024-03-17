package com.neuron.library_api.service.impl;

import com.neuron.library_api.dto.request.BorrowerRequest;
import com.neuron.library_api.dto.request.UpdateBorrowerStatus;
import com.neuron.library_api.dto.response.BorrowerResponse;
import com.neuron.library_api.entity.Borrower;
import com.neuron.library_api.repository.BorrowerRepository;
import com.neuron.library_api.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {
    private final BorrowerRepository borrowerRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BorrowerResponse create(BorrowerRequest request) {
        request.setId(UUID.randomUUID().toString());
        Integer result = borrowerRepository.create(request.getId(), request.getBookId(), request.getMemberId(), new Date(), "loaned");

        if(result > 0) {
            Borrower borrower = borrowerRepository.getOneById(request.getId());
            return convertToBorrowerResponse(borrower);
        }else{
            return null;
        }
    }

    @Override
    public List<BorrowerResponse> getAll() {
        List<Borrower> borrowers = borrowerRepository.getALl();
        return borrowers.stream().map(this::convertToBorrowerResponse).toList();
    }

    @Override
    public BorrowerResponse getById() {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BorrowerResponse updateStatus(UpdateBorrowerStatus request) {
        Integer result = borrowerRepository.updateBorrowerStatus(request.getId(), new Date(), request.getStatus());
        if(result > 0){
            Borrower borrower = borrowerRepository.getOneById(request.getId());
            return convertToBorrowerResponse(borrower);
        }else{
            return null;
        }
    }

    private BorrowerResponse convertToBorrowerResponse(Borrower borrower) {
        return BorrowerResponse.builder()
                .id(borrower.getId())
                .memberId(borrower.getMember().getId())
                .bookId(borrower.getBook().getId())
                .loanDate(borrower.getLoanDate())
                .dateOfReturn(borrower.getDateOfReturn())
                .status(borrower.getStatus())
                .build();
    }
}
