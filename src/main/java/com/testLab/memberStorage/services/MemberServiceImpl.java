package com.testLab.memberStorage.services;

import com.testLab.memberStorage.models.Member;
import com.testLab.memberStorage.repositories.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("memberServiceImpl")
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public Member save(Member member) {
        log.info(String.format("saved %s", member));
        return repository.save(member);
    }

    @Override
    public Member findOne(String id) {
        return repository
                .findById(id)
                .get();
    }

    @Override
    public Member update(String id, Member member) {
        log.info(String.format("updated %s", member));
        repository
                .findById(id)
                .get();

        return repository.save(member);

    }

    @Override
    public void delete(String id) {
        Member existingMember = repository
                .findById(id)
                .get();
        log.info(String.format("deleted %s1", existingMember));
        repository.delete(existingMember);


    }

    @Override
    public List<Member> getAll() {
        return repository.findAll();
    }

}
