package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.TravelClubApp;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller //view 페이지가 있을 때 사용함
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @PostMapping("/club")   //localhost:8090/club이 url의 post 방식일 경우 이 함수 호출 함
    public String register(@RequestBody TravelClubCdo travelClubCdo){//@RequestBody를 사용하여 http request의 body에 담아서 오도록 함
        return clubService.registerClub(travelClubCdo);
    }



//    @GetMapping("/test")  //이렇게 하면 http://localhost:8090/test에서 아래 함수가 실행된 모습이 보인다.
//    public String test(){
//        return "Hello Spring Mvc";
//    }
}
