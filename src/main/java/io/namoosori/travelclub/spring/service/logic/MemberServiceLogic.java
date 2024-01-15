package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.MemberStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceLogic implements MemberService {

//    @Autowired //이걸하면 자동으로 MemberMapStore를 넣어줄 것임.
    private MemberStore memberStore;

    public MemberServiceLogic(MemberStore memberStore){ //스프링IOC 컨테이너 입장에서는 여기에 bean객체를 넣어줘야하는데 이 MemberStore를 implements하고있는 spring bean이 MemberMapStore밖에 없음.//여기로 오는 객체가 membermapstore인 것
        this.memberStore = memberStore;
    }

    @Override
    public String registerMember(MemberCdo member) {
        return null;
    }

    @Override
    public CommunityMember findMemberById(String memberId) {
        return null;
    }

    @Override
    public CommunityMember findMemberByEmail(String memberEmail) {
        return null;
    }

    @Override
    public List<CommunityMember> findMembersByName(String name) {
        return null;
    }

    @Override
    public void modifyMember(String memberId, NameValueList member) {

    }

    @Override
    public void removeMember(String memberId) {

    }
}
