package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

//테스트를 하기위한 파일
public class TravelClubApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//스프링 프레임워크에 설정정보가 어딧는지를 알려준다.

        String [] beanNames = context.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(beanNames));


        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);

        String memberId = memberService.registerMember(
                new MemberCdo(
                        "test@nextree.io",
                        "kim",
                        "nickname",
                        "010-0000-0000",
                        "2010.10.10"));

        CommunityMember foundedMember = memberService.findMemberById(memberId);
        System.out.println(foundedMember.toString());

//        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub","TestTravelClub");
//        ClubService clubService = context.getBean("clubService",ClubService.class); //빈을 찾아옴
//
//
//        //서비스로 clubcdo가 넘겨지고 이러게 넘어간 데이터는 다시 TravelClub으로 변환된 다음에 그 TravelClub이 ClubStore로 넘어간다. 그리고 ClubStore에서 map에 저장됨.
//        // ClubStore는 이렇게 저장되면 id를 리턴해주고, id는 다시 ClubService에서 TravelClubApp로 리턴을 해줌
//
//        String clubId = clubService.registerClub(clubCdo);;
//
//        TravelClub foundedClub = clubService.findClubById(clubId);
//
//        System.out.println("Club Name : "+foundedClub.getName());
//        System.out.println("Club Intro : "+foundedClub.getIntro());
////        System.out.println("Club foundationTime : "+foundedClub.getFoundationTime());
//        System.out.println("Club foundationTime : "+new Date(foundedClub.getFoundationTime()));
    }
}
