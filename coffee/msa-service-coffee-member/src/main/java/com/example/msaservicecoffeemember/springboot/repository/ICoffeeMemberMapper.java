package com.example.msaservicecoffeemember.springboot.repository;

import com.example.msaservicecoffeemember.springboot.repository.dvo.MemberDVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICoffeeMemberMapper {
    MemberDVO existsByMemberName(MemberDVO memberDVO);
    int createMemberTable();
    int insertMemberData();
}