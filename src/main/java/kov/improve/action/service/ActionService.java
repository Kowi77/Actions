package kov.improve.action.service;

import kov.improve.action.model.Action;
import kov.improve.action.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActionService {

    private ActionRepository repository;

    @Autowired
    public ActionService(ActionRepository repository) {
        this.repository = repository;
    }

    public List<Action> getAll(){
        return repository.findAllByAmountGreaterThanOrderByNameAsc(0);
    }

    public Action get(int id){
       return repository.findOne(id);
    }

    @Transactional
    public Action save(Action action){
        if(get(action.getId()).getAmount() < 0)
            return null;
        return repository.save(action);
    }
}
