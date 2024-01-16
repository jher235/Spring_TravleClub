package io.namoosori.travelclub.spring.service.logic;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;
import io.namoosori.travelclub.spring.store.MemberStore;
import io.namoosori.travelclub.spring.util.exception.MemberDuplicationException;
import io.namoosori.travelclub.spring.util.exception.NoSuchClubException;
import io.namoosori.travelclub.spring.util.exception.NoSuchMemberException;
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
        String email = member.getEmail();
        CommunityMember foundedmember = memberStore.retrieveByEmail(email);

        if(foundedmember != null){
            throw new MemberDuplicationException("Member already exists with email : "+email);
        }
        foundedmember = new CommunityMember(
                member.getEmail(), member.getName(), member.getPhoneNumber()
        );
        foundedmember.setNickName(member.getNickName());
        foundedmember.setBirthDay(member.getBirthDay());

        foundedmember.checkValidation(); //이메일 체크

        memberStore.create(foundedmember);

        return foundedmember.getId();
    }

    @Override
    public CommunityMember findMemberById(String memberId) {
        return memberStore.retrieve(memberId);
    }

    @Override
    public CommunityMember findMemberByEmail(String memberEmail) {
        return memberStore.retrieveByEmail(memberEmail);
    }

    @Override
    public List<CommunityMember> findMembersByName(String name) {

        return memberStore.retrieveByName(name);
    }

    @Override
    public void modifyMember(String memberId, NameValueList nameValueList) {
        CommunityMember targetMember = memberStore.retrieve(memberId);
        if(targetMember ==null){
            throw new NoSuchClubException("No Such member with ID : "+memberId);
        }

        targetMember.modifyValues(nameValueList);
        memberStore.update(targetMember);
    }

    @Override
    public void removeMember(String memberId) {
        if(!memberStore.exists(memberId)){
            throw new NoSuchMemberException("No such member with id : "+memberId);
        }
        memberStore.delete(memberId);
    }
}
