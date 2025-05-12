package com.example.demo1.service.MemberService;

import com.example.demo1.apiPayload.code.status.ErrorStatus;
import com.example.demo1.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.demo1.converter.MemberConverter;
import com.example.demo1.converter.MemberPreferConverter;
import com.example.demo1.domain.FoodCategory;
import com.example.demo1.domain.Member;
import com.example.demo1.domain.mapping.MemberPrefer;
import com.example.demo1.dto.requestdto.MemberRequestDTO;
import com.example.demo1.repository.foodcatrgoryRepository.FoodCategoryRepository;
import com.example.demo1.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}