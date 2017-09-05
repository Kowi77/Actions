package kov.improve.action.service;

import kov.improve.action.repository.GiftRepository;
import kov.improve.action.model.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    @Autowired
    GiftRepository repository;

    List<Gift> getAll() {
        return repository.findAllByQuantityGreaterThanOrderByNameAsc(0);
    }

    List<Gift> getAllWithFilter(String part){
        return repository.findAllByQuantityGreaterThanAndNameContainsOrderByNameAsc(0, part);
    }

    Gift get (int id){
        return repository.getOne(id);
    }

    void save (Gift gift){
        repository.save(gift);
    }

   /* Gift findOne(int id) {
       return repository.findOne(id);
    }*/
}
