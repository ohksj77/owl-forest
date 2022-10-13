package com.cbu.backend.member.service;

import com.cbu.backend.member.dto.response.MemberResponseDTO;
import com.cbu.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public List<MemberResponseDTO> findAll(Pageable pageable) {
        throw new RuntimeException();
    }
    
}
