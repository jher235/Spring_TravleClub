package io.namoosori.travelclub.web.store.jpastore.jpo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="TRAVEL_CLUB")//테이블이 생성될 때 이름 설정
public class TravelClubJpo {//데이터 베이스 entity 객체

    @Id //식별자 테이블
    private String id;
    private String name;
    private String intro;
    private long foundationTime;

    //travelclub 이라는 도메인 객체로 데이터를 받아서 TravelClubJpo로 변환하는 것
    public TravelClubJpo(TravelClub travelClub){
//        this.id = travelClub.getId();
//        this.name = travelClub.getName();
//        this.intro = travelClub.getIntro();
//        this.foundationTime = travelClub.getFoundationTime();

        BeanUtils.copyProperties(travelClub,this);  //이 코드로 파라미터로 받아온 travelClub을 복사하여 여기에 맞게 세팅해 줌. 즉, 위의 코드가 생략이 가능함
    }

    public TravelClub toDomain(){   //jpo객체를 domain객체로 변환하는 작업
        TravelClub travelClub = new TravelClub(this.name,this.intro);
        travelClub.setId(this.id);
        travelClub.setFoundationTime(this.foundationTime);
        return travelClub;
    }
}
