package com.testLab.memberStorage.services;

import com.testLab.memberStorage.models.Member;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    private Member savedBob, savedMark, savedJohn;

    @Before
    public void setUp() {
        savedBob = memberService.save(createBob());
        savedMark = memberService.save(createMark());
        savedJohn = memberService.save(createJohn());

    }

    @Test
    public void test_save_success() {
        Member expectedBob = createBob();
        expectedBob.setId(savedBob.getId());

        assertThat(savedBob, is(equalTo(expectedBob)));

    }

    @Test
    public void test_update_success() {

        String updatedFirstName = "Filert";
        Member updatedBob = createBob();
        String savedId = savedBob.getId();
        updatedBob.setId(savedId);
        updatedBob.setFirstName(updatedFirstName);

        Member actualBob = memberService.update(savedId, updatedBob);

        assertThat(actualBob, is(equalTo(updatedBob)));

    }

    @Test
    public void test_findOne_returnBob() {

        Member expectedBob = createBob();
        expectedBob.setId(savedBob.getId());

        Member actualBob = memberService.findOne(savedBob.getId());

        assertThat(actualBob, is(equalTo(expectedBob)));
    }

    @Test(expected = NoSuchElementException.class)
    public void test_findOne_ThrowNoSuchElementException() {

        Member expectedBob = createBob();
        expectedBob.setId(savedBob.getId());

        String wrongId = "Wrong_Id";
        memberService.findOne(wrongId);

    }

    @Test(expected = NoSuchElementException.class)
    public void test_delete_success() {

        String savedId = savedBob.getId();

        memberService.delete(savedId);

        memberService.findOne(savedId);
    }

    private Member createJohn() {
        return new Member("John", "Johnel", new Date(1938, 04, 32), 120327);
    }

    private Member createMark() {
        return new Member("Mark", "Markerer", new Date(1918, 03, 32), 11032);
    }

    private Member createBob() {
        return new Member("Bob", "Bobber", new Date(1958, 02, 32), 124032);
    }

    @After
    public void tearDown() {
        try {
            memberService.delete(savedBob.getId());
        } catch (NoSuchElementException e) {

        }
        memberService.delete(savedMark.getId());
        memberService.delete(savedJohn.getId());

    }
}