package com.example.demo.Repository;

import com.example.demo.Entity.Supply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SupplyRepository extends CrudRepository<Supply, Integer> {

    Iterable<Supply> findAllByCreatedBy(Integer id);

    @Query("select s from Supply s where s.id=:id and s.createdBy=:createdBy")
    Supply findMerchandiserSupplies(@Param("id") Integer id, @Param("createdBy") Integer createdBy);

}
