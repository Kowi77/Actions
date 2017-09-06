package kov.improve.action.repository;

import kov.improve.action.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface GiftRepository extends JpaRepository<Gift, Integer> {

    List<Gift> findAllByQuantityGreaterThanOrderByNameAsc(int ZERO);

    List<Gift> findAllByQuantityGreaterThanAndNameContainsAllIgnoreCaseOrderByNameAsc(int ZERO, String part);

    Gift save(Gift gift);

    Gift getOne(int id);

    Gift findOne(int id);
}
