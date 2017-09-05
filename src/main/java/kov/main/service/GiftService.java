package kov.main.service;

import kov.main.model.Gift;
import kov.main.repository.GiftRepository;
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
        return repository.findAllByQuantityGreaterThanAndByNameContainsOrderByNameAsc(0, part);
    }

    Gift get (int id){
        return repository.getOne(id);
    }

    void save (Gift gift){
        repository.save(gift);
    }
}
