package io.namoosori.travelclub.web.controller;

import io.namoosori.travelclub.web.TravelClubApp;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.web.shared.NameValueList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/club")//이 클래스가 갖고 있는 모든 url 앞에 이게 붙는다.
@RestController
//@Controller //view 페이지가 있을 때 사용함
public class ClubController {

    private ClubService clubService;

    //    @GetMapping("/test")  //이렇게 하면 http://localhost:8090/test에서 아래 함수가 실행된 모습이 보인다.
//    public String test(){
//        return "Hello Spring Mvc";
//    }

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @PostMapping  //localhost:8090/club이 url의 post 방식일 경우 이 함수 호출 함
    public String register(@RequestBody TravelClubCdo travelClubCdo){//@RequestBody를 사용하여 http request의 body에 담아서 오도록 함
        return clubService.registerClub(travelClubCdo);
    }

    @GetMapping("/all")
    public List<TravelClub> findAll(){
        return clubService.findAll();
    }

    @GetMapping("/{clubId}")   //url로 온 요청에서 {clubId}부분을 받아서 아래 함수의 파라미터로 전달함.
    public TravelClub find(@PathVariable String clubId){
        System.out.println(clubId);
        return clubService.findClubById(clubId);
    }

//    @GetMapping("/club/{name}") //이렇게 할 경우 위의  @GetMapping("/club/{clubId}")과 구별 할 수 없어서 오류가 발생함, 또한 /club/name/{name}과 같이 너무 늘어지는 url은 좋지 않다.
//    public List<TravelClub> findByName(@PathVariable String name){
    @GetMapping//localhost:8090/club?name=JavaClub url로 온 요청에서 '?'이후 부분을 받아서 아래 함수의 파라미터로 전달함.
    public List<TravelClub> findByName(@RequestParam String name){
        System.out.println(name);
        return clubService.findClubsByName(name);
    }

    @PutMapping("/{clubId}")//아래 파라미터의 clubId는 {clubId}값을 전달해주고 nameValueList는 put메소드에서 body에 값을 받아와서 보내준다.
    public void modify(@PathVariable String clubId,@RequestBody NameValueList nameValueList){
        clubService.modify(clubId, nameValueList);
    }

    @DeleteMapping("/{clubId}")
    public void delete(@PathVariable String clubId){
        clubService.remove(clubId);
    }

}
