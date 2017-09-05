package kov.main.repository;

import kov.main.model.Gift;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface GiftRepository extends JpaRepository<Gift, Integer> {

    List<Gift> findAllByQuantityGreaterThanOrderByNameAsc(int ZERO);

    List<Gift> findAllByQuantityGreaterThanAndByNameContainsOrderByNameAsc(int ZERO, String part);

 /*   @Transactional
    List<Gift> save(Gift gift);*/

    Gift getOne(int id);

    Gift findOne(Gift gift);
}
