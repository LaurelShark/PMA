package com.example.demo.Repository;

import com.example.demo.Entity.SupplyLine;
import org.springframework.data.repository.CrudRepository;

public interface SupplyLineRepository extends CrudRepository<SupplyLine, Integer> {

    Iterable<SupplyLine> findAllBySupplyId(Integer id);

}
