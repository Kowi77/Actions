package kov.improve.action.service;

import kov.improve.action.model.Action;
import kov.improve.action.repository.ActionRepository;
import kov.improve.action.repository.GiftRepository;
import kov.improve.action.model.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GiftService {

    @Autowired
    GiftRepository repository;

    @Autowired
    ActionService actionService;

    public List<Gift> getAll() {
        return repository.findAllByQuantityGreaterThanOrderByNameAsc(0);
    }

    public List<Gift> getAllWithFilter(String part){
        return repository.findAllByQuantityGreaterThanAndNameContainsOrderByNameAsc(0, part);
    }

    public Gift get (int id){
        return repository.getOne(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Gift save (Gift gift, Action action) throws Exception{
        if (gift.getQuantity() < 0 || action.getAmount() < 0)
            return null;
        Gift result = repository.save(gift);
        if (result == null || actionService.save(action) == null)
            throw new Exception("Выдача подарка не состоялась!");
        return result;
    }

   /* Gift findOne(int id) {
       return repository.findOne(id);
    }*/
}
