package io.namoosori.travelclub.web.store.jpastore.repository;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {  //JpaRepository를 상속하는 ClubRepository를 정의 후 이를 사용하여 데이터를 저장함 spring data jpa를 사용하기 위함
//제너릭 첫번째는 엔티티로 정의된 객체, 두번째는 식별자 id임
    List<TravelClubJpo> findAllByName(String name);//이걸 정의해주면 이 조건에 맞게 쿼리를 만들어서 보내줌
}
