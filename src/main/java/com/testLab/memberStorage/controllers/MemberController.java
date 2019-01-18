package com.testLab.memberStorage.controllers;

import com.testLab.memberStorage.models.Member;
import com.testLab.memberStorage.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    @Qualifier("memberServiceImpl")
    private MemberService memberService;

    @PostMapping("/member")
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

    @GetMapping("/member/{id}")
    public Member findOne(@PathVariable String id) {
        return memberService.findOne(id);
    }

    @PutMapping("/member/{id}")
    public Member update(@PathVariable String id, @RequestBody Member member) {
        return memberService.update(id, member);
    }

    @DeleteMapping("/member/{id}")
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }

    @GetMapping("/member/")
    public List<Member> getAll() {
        return memberService.getAll();
    }

}
