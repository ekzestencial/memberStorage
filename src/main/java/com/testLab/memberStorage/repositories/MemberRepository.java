package com.testLab.memberStorage.repositories;

import com.testLab.memberStorage.models.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {

}
