package com.neuron.library_api.service.impl;

import com.neuron.library_api.dto.request.MemberRequest;
import com.neuron.library_api.dto.request.MemberUpdateRequest;
import com.neuron.library_api.dto.request.SearchMemberRequest;
import com.neuron.library_api.dto.response.MemberResponse;
import com.neuron.library_api.entity.Member;
import com.neuron.library_api.repository.MemberRepository;
import com.neuron.library_api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MemberResponse create(MemberRequest request) {
        request.setId(UUID.randomUUID().toString());
        Integer result = memberRepository.save(request.getId(), request.getName(), request.getAddress(), request.getMobilePhone());
        if(result > 0){
            Member member = memberRepository.getOneById(request.getId());
            return convertToMemberResponse(member);
        }else
            return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberResponse> getAll(SearchMemberRequest request) {
        List<Member> members = memberRepository.getAllByFilter(request.getName(), request.getAddress());

        return members.stream().map(detail -> MemberResponse.builder()
                .id(detail.getId())
                .name(detail.getName())
                .address(detail.getAddress())
                .mobilePhone(detail.getMobilePhone())
                .build()).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public MemberResponse getById(String id) {
        Member member = memberRepository.getOneById(id);
        if(member == null) return null;
        return convertToMemberResponse(member);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MemberResponse update(MemberUpdateRequest request) {
        Integer result = memberRepository.updateMember(request.getId(), request.getName(), request.getAddress(), request.getMobilePhone());
        if(result > 0){
            Member member = memberRepository.getOneById(request.getId());
            return convertToMemberResponse(member);
        }else{
            return null;
        }
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean delete(String id) {
        Integer result = memberRepository.deleteMemberById(id);
        return result > 0;
    }

    private static MemberResponse convertToMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .address(member.getAddress())
                .mobilePhone(member.getMobilePhone())
                .build();
    }
}
