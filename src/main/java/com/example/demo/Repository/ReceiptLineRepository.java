package com.example.demo.Repository;

import com.example.demo.Entity.ReceiptLine;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptLineRepository extends CrudRepository<ReceiptLine, Integer> {

    Iterable<ReceiptLine> findAllByReceiptId(Integer id);
}
