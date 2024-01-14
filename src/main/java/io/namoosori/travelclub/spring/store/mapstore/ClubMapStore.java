package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.store.ClubStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;


@Repository("clubStore")
public class ClubMapStore implements ClubStore {

    private Map<String, TravelClub> clubMap;

    public ClubMapStore(){
        this.clubMap = new LinkedHashMap<>();
    }

    @Override
    public String create(TravelClub club) {// club 파라미터로 새로 저장해야하는 정보들이 넘어옴
        clubMap.put(club.getId(),club);

        return club.getId();
    }

    @Override
    public TravelClub retrieve(String clubId) {


        return clubMap.get(clubId);
    }

    @Override
    public List<TravelClub> retrieveByName(String name) {

        return clubMap.values().stream()
                .filter(club-> club.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void update(TravelClub club) {
        clubMap.put(club.getId(),club);
    }

    @Override
    public void delete(String clubId) {
        clubMap.remove(clubId);
    }

    @Override
    public boolean exists(String clubId) {
//        return clubMap.containsKey(clubId);
        return Optional.ofNullable(clubMap.get(clubId)).isPresent();
    }
}
