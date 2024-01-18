package io.namoosori.travelclub.web.store.jpastore.repository;

import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.store.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {  //JpaRepository를 상속하는 ClubRepository를 정의 후 이를 사용하여 데이터를 저장함
//제너릭 첫번째는 엔티티로 정의된 객체, 두번째는 식별자 id임
}
