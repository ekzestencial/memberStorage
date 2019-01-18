package com.testLab.memberStorage.services;

import com.testLab.memberStorage.models.Member;

import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member findOne(String id);

    Member update(String id, Member member);

    void delete(String id);

    List<Member> getAll();
}
