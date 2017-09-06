package kov.improve.action.repository;

import kov.improve.action.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ActionRepository extends JpaRepository<Action, Integer> {

    List<Action> findAllByAmountGreaterThanOrderByNameAsc(int ZERO);

    Action save(Action action);

    Action getOne(int id);

    Action findOne(int id);
}
